package com.puke.pets.base;

import android.app.Application;

/**
 * @author zijiao
 * @version 17/10/6
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SingleInstance.setApplication(this);
    }
}
