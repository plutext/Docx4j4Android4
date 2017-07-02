# Docx4j4Android4
Android Studio docx4j sample app

This app is a proof of concept of docx4j 3.3.4 running on Android.

Tested working in emulator (API 23, API 26), build on Android Studio 2.3.3.

Please note currently known issue running on API 21: https://github.com/plutext/Docx4j4Android4/issues/3

So, TODO: test on API 22.

It is using JAXB Reference Implementation, compiled for Java 7,
with https://github.com/gf-metro/jaxb/pull/34 so things work even
though org.apache.harmony.xml.parsers.SAXParser doesn't support
http://javax.xml.XMLConstants/feature/secure-processing

This demo app doesn't actually show anything in the Android UI; it just marshalls/unmarshalls
to logcat (Android Monitor in Android Studio).

Sometime I'll add a docx file chooser, then open the docx with docx4j, then display the XML of the MainDocumentPart.

WARNING:

Note https://github.com/plutext/Docx4j4Android4/issues/1 ; this POC uses --core-library flag

For questions/comments, please post at http://www.docx4java.org/forums/android-f19/ XOR StackOverflow.  Not both!
