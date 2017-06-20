# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\jharrop\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}



-ignorewarnings
-dontobfuscate

-keep class ae.com.sun.** { public protected private *; }
-keep class ae.sun.** { public protected private *; }
-keep class ae.javax.** { public protected private *; }

#-keep class org.apache.** { public protected private *; }
-keep class org.docx4j.** { public protected private *; }
-keep class org.opendope.** { public protected private *; }
#-keep class com.sun.** { public protected private *; }

# but still get:
# "The number of method references in a .dex file cannot exceed 64K.
# trouble writing output: Too many method references: 75993;
# max is 65536. Too many classes to fit in one dex file.
# so configure multidex in build.gradle