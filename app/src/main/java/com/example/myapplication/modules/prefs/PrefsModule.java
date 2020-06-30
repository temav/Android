package com.example.myapplication.modules.prefs;

import android.content.Context;

public class PrefsModule {
    private static IPrefs prefsInstance = null;

    public static IPrefs getPrefs(Context context) {
        synchronized (PrefsModule.class) {
            if (prefsInstance == null) {
                prefsInstance = new ConcretePrefs(context);
            }
            return prefsInstance;
        }
    }
}
