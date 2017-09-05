package com.google.android.instantapps;


import android.app.Application;
import android.util.Log;

public class InstalledApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("Neige", "Installed Application");
    }
}
