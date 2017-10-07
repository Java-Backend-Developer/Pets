package com.puke.pets.login;

import com.puke.pets.api.Response;
import com.puke.pets.api.RetrofitService;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author zijiao
 * @version 17/10/6
 */
public class LoginService {

    public static final String LOGIN_URL = "app_user/app_login";

    interface LoginApi {
        @GET(LOGIN_URL)
        Observable<Response<UserData>> login(
                @Query("username") String username,
                @Query("password") String password
        );
    }

    public static Observable<Response<UserData>> login(String username, String password) {
        return RetrofitService.create(LoginApi.class)
                .login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
