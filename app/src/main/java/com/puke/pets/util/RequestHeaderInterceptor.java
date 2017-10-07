package com.puke.pets.util;

import android.os.Build;

import com.puke.pets.login.LoginService;
import com.puke.pets.sp.Utils;
import com.puke.pets.user.UserManager;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 请求头拦截器, 添加设备信息
 *
 * @author zijiao
 * @version 17/10/7
 */
public class RequestHeaderInterceptor implements Interceptor {

    private static final String HEADER_KEY_TOKEN = "appToken";
    private static final Map<String, String> sAlias = new HashMap<>();

    static {
        sAlias.put("id", "appId");
        sAlias.put("user", "appUserName");
        sAlias.put("type", "appType");
        sAlias.put("sdk_int", "versionCode");
    }

    private static String handleHeaderName(String header) {
        String headerAlias = sAlias.get(header);
        return headerAlias == null ? header : headerAlias;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        addCommonHeader(builder);
        addLoginHeader(request, builder);
        return chain.proceed(builder.build());
    }

    private void addCommonHeader(Request.Builder builder) {
        builder.addHeader(HEADER_KEY_TOKEN, UserManager.instance().getToken());
    }

    private void addLoginHeader(Request request, Request.Builder builder) {
        if (request.url().toString().contains(LoginService.LOGIN_URL)) {
            Class<Build> buildClass = Build.class;
            for (Field field : buildClass.getFields()) {
                try {
                    String name = handleHeaderName(field.getName().toLowerCase());
                    builder.addHeader(name, String.valueOf(field.get(null)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            builder.header("serial", Utils.getIMIE());
        }
    }
}
