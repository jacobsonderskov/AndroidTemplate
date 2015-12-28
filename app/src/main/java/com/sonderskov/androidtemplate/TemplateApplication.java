package com.sonderskov.androidtemplate;

import android.app.Application;
import android.content.res.Configuration;

import roboguice.RoboGuice;


public class TemplateApplication extends Application {
    static {
        // https://github.com/roboguice/roboguice/wiki/RoboBlender-wiki
        // Disables RoboBlender which will generate an Annotation Database to speed up injection.
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
