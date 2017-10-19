package cn.tanghaha.mvpDome.model;

/**
 * Created by ${user} on 2017/10/12.
 */

public interface LoginModel
{
    interface OnLoginFinishedListener
    {
        void onSuccess();

        void onUserNameError();

        void onPasswordError();
    }

    void login(String name, String password, OnLoginFinishedListener listenrer);

}
