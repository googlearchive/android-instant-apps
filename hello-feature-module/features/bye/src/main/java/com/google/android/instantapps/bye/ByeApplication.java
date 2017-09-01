package com.google.android.instantapps.bye;

import android.app.Application;
import android.util.Log;


public class ByeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("Neige", "Bye Application");
    }
}
