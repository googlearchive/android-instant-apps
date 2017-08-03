package com.instantappsamples.feature.bye;

import android.app.Application;
import android.util.Log;

public class ByeApplication extends Application implements Toto {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("laurent", "class : " + this.getClass().getName());
    }

    @Override
    public void sayToto() {
        Log.e("laurent", "class : " + this.getClass().getName() + " TOTO ByeApplicationByeApplicationByeApplication");
    }
}
