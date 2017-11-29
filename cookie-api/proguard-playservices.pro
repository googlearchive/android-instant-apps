
-keep class com.google.android.gms.instantapps.PackageManagerCompat { *; }
-keep class com.google.android.gms.instantapps.InstantApps {
    public static *** getPackageManagerCompat(***);
}