-keep public class android.support.v7.app.AppCompatActivity {
  public protected *;
}

-keep public class com.google.android.gms.instantapps.InstantApps {
  public static *** getInstantAppsClient(***);
  public static *** getPackageManagerCompat(***);
}

-keep public class com.google.android.gms.instantapps.PackageManagerCompat {
  public protected boolean isInstantApp();
}