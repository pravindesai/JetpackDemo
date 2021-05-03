package com.example.jetpackdemo.BaseClasses;

import android.app.Application;
import android.content.Context;

public class JetpackApplication extends Application {
    private static Context AppContext, BaseContext;

    public JetpackApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        JetpackApplication.AppContext = getApplicationContext();
        JetpackApplication.BaseContext = getBaseContext();
    }

    public static Context getAppContext() {
        return AppContext;
    }


    public static Context getMyBaseContext() {
        return BaseContext;
    }
}
