package com.puke.pets.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Handler;

/**
 * @author zijiao
 * @version 17/10/6
 */
public class SingleInstance {

    @SuppressLint("StaticFieldLeak")
    private static Application sApp;
    private static final Handler sHandler = new Handler();

    public static void setApplication(Application application) {
        sApp = application;
    }

    public static Application sApp() {
        return sApp;
    }

    public static Handler sHandler() {
        return sHandler;
    }

}
