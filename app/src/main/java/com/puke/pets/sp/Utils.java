package com.puke.pets.sp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.puke.pets.base.SingleInstance;

/**
 * @author zijiao
 * @version 17/10/7
 */
public class Utils {

    @SuppressLint("HardwareIds")
    public static String getIMIE() {
        TelephonyManager tm = (TelephonyManager) SingleInstance.sApp()
                .getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

}
