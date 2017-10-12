package cn.tanghaha.mvpDome.login.model;

import android.text.TextUtils;

/**
 * 登录模块的model层：登录接口的操作
 * Created by ${user} on 2017/10/11.
 */

public class LoginModelImpl implements LoginModel
{
    public void login(String userName, String password, OnLoginFinishedListener
            listenrer)
    {
//        new Handler().postDelayed(new Runnable()
//        {
//            @Override
//            public void run()
//            {
        if (TextUtils.isEmpty(userName))
            listenrer.onUserNameError();
        else if (TextUtils.isEmpty(password))
            listenrer.onPasswordError();
        else listenrer.onSuccess();
//
//            }
//        }, 1000);

    }
}