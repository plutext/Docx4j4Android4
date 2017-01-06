package docx4j.org.docx4j4android4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.sun.xml.bind.v2.runtime.JAXBContextImpl;

import org.docx4j.XmlUtils;
import org.docx4j.convert.out.html.HtmlExporterNonXSLT;
import org.docx4j.jaxb.Context;
import org.docx4j.jaxb.XPathBinderAssociationIsPartialException;
import org.docx4j.model.images.ConversionImageHandler;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.io.LoadFromZipNG;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Document;

import javax.xml.bind.JAXBException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        try {
            System.out.println("about to create package");

            // org.apache.harmony.xml.parsers.SAXParserFactoryImpl throws SAXNotRecognizedException
            // for feature http://javax.xml.XMLConstants/feature/secure-processing
            // so either disable XML security, or use a different parser.  Here we disable it.
            org.docx4j.jaxb.ProviderProperties.getProviderProperties().put(JAXBContextImpl.DISABLE_XML_SECURITY, Boolean.TRUE);

            // Can we init the Context?
            // You can delete this if you want...
            System.out.println(Context.getJaxbImplementation());
            System.out.println(Context.jc.getClass().getName());

            // Create WordprocessingMLPackage
            WordprocessingMLPackage w = WordprocessingMLPackage.createPackage();
            w.getMainDocumentPart().setJaxbElement(new Document() );
            w.getMainDocumentPart().addParagraphOfText("hello from android");

            // Test marshalling works
            String XML = XmlUtils.marshaltoString(w.getMainDocumentPart().getXML());

            System.out.println(XML);

            // Test unmarshalling works
            try {
                Object o = XmlUtils.unmarshalString(XML, Context.jc);
                System.out.println(o.getClass().getName());
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            // Test XPath works
            try {
                java.util.List<Object> results = w.getMainDocumentPart().getJAXBNodesViaXPath("//w:t", false);
                System.out.println("Xpath result count:" + results.size());
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (XPathBinderAssociationIsPartialException e) {
                e.printStackTrace();
            }

            System.out.println("done!");

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
