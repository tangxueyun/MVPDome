package cn.tanghaha.mvpDome.login.model;

import android.os.Handler;
import android.text.TextUtils;

import cn.tanghaha.mvpDome.login.OnLoginFinishedListenrer;

/**
 * 登录模块的model层：登录接口的操作
 * Created by ${user} on 2017/10/11.
 */

public class LoginModel
{
    public void login(final String userName, final String password, final OnLoginFinishedListenrer
            listenrer)
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if (TextUtils.isEmpty(userName))
                    listenrer.onUserNameError();
                else if (TextUtils.isEmpty(password))
                    listenrer.onPasswordError();
                else listenrer.onSuccess();

            }
        }, 1000);
    }
}