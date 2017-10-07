package com.puke.pets.sp;

import android.content.Context;
import android.content.SharedPreferences;

import com.puke.pets.base.SingleInstance;

/**
 * @author zijiao
 * @version 17/10/7
 */
public class SpUtils {

    public static final int INVALID_VALUE = -1;
    private static final String SP_NAME = "Pets";

    private static final byte[] sInstanceLock = new byte[0];
    private static SpUtils sInstance;

    private SpUtils() {
    }

    public static SpUtils instance() {
        if (sInstance == null) {
            synchronized (sInstanceLock) {
                if (sInstance == null) {
                    sInstance = new SpUtils();
                }
            }
        }
        return sInstance;
    }

    private static SharedPreferences sp() {
        return SingleInstance.sApp().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public static void setString(String key, String value) {
        sp().edit().putString(key, value).apply();
    }

    public static String getString(String key, String defaultValue) {
        return sp().getString(key, defaultValue);
    }

    public static String getString(String key) {
        return sp().getString(key, null);
    }

    public static void setInt(String key, int value) {
        sp().edit().putInt(key, value).apply();
    }

    public static int getInt(String key, int defaultValue) {
        return sp().getInt(key, defaultValue);
    }

    public static int getInt(String key) {
        return sp().getInt(key, INVALID_VALUE);
    }

    public static long getLong(String key, long defaultValue) {
        return sp().getLong(key, defaultValue);
    }

    public static void setLong(String key, long value) {
        sp().edit().putLong(key, value).apply();
    }

    public static long getLong(String key) {
        return sp().getLong(key, INVALID_VALUE);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return sp().getBoolean(key, defaultValue);
    }

    public static boolean getBoolean(String key) {
        return sp().getBoolean(key, false);
    }

}
