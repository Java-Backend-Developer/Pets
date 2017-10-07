package com.puke.pets.api;

import com.puke.pets.util.RequestHeaderInterceptor;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author zijiao
 * @version 17/10/6
 */
public class RetrofitService {

    private static final int N_THREADS = 10;
    private static final String BASE_URL = "http://18575t363y.51mypc.cn";

    private static OkHttpClient sClient = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(new RequestHeaderInterceptor())
            .build();

    private static Retrofit sRetrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .callbackExecutor(Executors.newFixedThreadPool(N_THREADS))
            .baseUrl(BASE_URL)
            .client(sClient)
            .build();

    public static <T> T create(Class<T> serviceType) {
        return sRetrofit.create(serviceType);
    }


}
