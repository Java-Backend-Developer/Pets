package com.puke.pets.user;

import com.puke.pets.sp.SpUtils;

/**
 * @author zijiao
 * @version 17/10/7
 */
public class UserManager {

    private static final String KEY_TOKEN = "UserManager_Key_Token";
    private static final byte[] sInstanceLock = new byte[0];
    private static UserManager sInstance;

    private UserManager() {
    }

    public static UserManager instance() {
        if (sInstance == null) {
            synchronized (sInstanceLock) {
                if (sInstance == null) {
                    sInstance = new UserManager();
                }
            }
        }
        return sInstance;
    }

    public void setToken(String token) {
        SpUtils.setString(KEY_TOKEN, token);
    }

    public String getToken() {
        return SpUtils.getString(KEY_TOKEN);
    }

}
