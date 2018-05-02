-keepattributes *Annotation*,Signature

-dontwarn com.google.appengine.api.urlfetch.**
-dontwarn com.squareup.okhttp.**
-dontwarn okio.BufferedSink
-dontwarn rx.**

-keep public class com.google.gson.** {
  public protected *;
}
-keep class retrofit.** { *; }