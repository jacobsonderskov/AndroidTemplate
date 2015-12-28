package com.sonderskov.androidtemplate;

import android.app.Application;
import android.content.res.Configuration;

import roboguice.RoboGuice;


public class MyApplication extends Application {
    static {
        RoboGuice.setUseAnnotationDatabases(false);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
