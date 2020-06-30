package com.example.myapplication;

import android.app.Application;
import android.util.Log;
import android.widget.Button;

import com.facebook.stetho.Stetho;

public class App extends Application {

    private static final String TAG = "APP_TAG";

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );

        // Enable command line interface
        initializerBuilder.enableDumpapp(
                Stetho.defaultDumperPluginsProvider(this)
        );

        // Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer);
    }
}

