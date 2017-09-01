package com.google.android.instantapps.base;

import android.app.Application;
import android.util.Log;


public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        Log.d("Neige", "Base Application");
    }
}
