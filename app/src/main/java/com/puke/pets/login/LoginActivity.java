package com.puke.pets.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.puke.pets.R;
import com.puke.pets.api.Response;
import com.puke.pets.base.BaseActivity;

import rx.Subscriber;

/**
 * @author zijiao
 * @version 17/10/6
 */
public class LoginActivity extends BaseActivity {

    private EditText mUsername;
    private EditText mPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setHeaderTitle("登录");
        mUsername = find(R.id.username);
        mPassword = find(R.id.password);

        mUsername.setText("123");
        mPassword.setText("123");
    }

    public void onLogin(View view) {
        String username = getStr(mUsername);
        String password = getStr(mPassword);
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            T("用户名或密码不能为空~");
            return;
        }
        LoginService.login(username, password)
                .subscribe(new Subscriber<Response<UserData>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        T("网络状态不好, 请稍后再试~");
                    }

                    @Override
                    public void onNext(Response<UserData> response) {
                        boolean success = response.isSuccess();
                        T(success ? "登录成功" : "登录失败");
                    }
                });
    }

}
