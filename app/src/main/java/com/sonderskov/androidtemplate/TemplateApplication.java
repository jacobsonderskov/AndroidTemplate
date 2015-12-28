package com.sonderskov.androidtemplate;

import android.app.Application;
import android.content.res.Configuration;

import com.google.inject.Stage;

import roboguice.RoboGuice;


public class TemplateApplication extends Application {
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
        //RoboGuice.getOrCreateBaseApplicationInjector(this, BuildConfig.DEBUG ? Stage.DEVELOPMENT : Stage.PRODUCTION, new TemplateModule(), new FormatterModule());
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
