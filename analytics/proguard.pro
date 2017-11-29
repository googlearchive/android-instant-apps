-keep class android.support.v7.app.AppCompatActivity {
  public void onCreate(...);
}
-keep class com.google.firebase.analytics.FirebaseAnalytics {
  public protected *;
}
-keep class com.google.android.instantapps.InstantApps {
  public boolean isInstantApp(...);
}
