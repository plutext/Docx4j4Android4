# Docx4j4Android4
Android Studio docx4j sample app

This app is a proof of concept of docx4j 3.3.2 (with a couple of minor changes) running on Android.

Minimum SDK is configured to be API 15, Android 4.03, but something older may well work.

It is using JAXB Reference Implementation, compiled for Java 7, with https://github.com/gf-metro/jaxb/pull/34 so things work even though org.apache.harmony.xml.parsers.SAXParser doesn't support http://javax.xml.XMLConstants/feature/secure-processing

This demo app doesn't actually show anything in the Android UI; it just marshalls/unmarshalls to the console.

A pull request which does something on the actual device would be gratefully accepted!

WARNING:

Note https://github.com/plutext/Docx4j4Android4/issues/1 ; this POC uses --core-library flag

For questions/comments, please post at http://www.docx4java.org/forums/android-f19/ XOR StackOverflow.  Not both!
