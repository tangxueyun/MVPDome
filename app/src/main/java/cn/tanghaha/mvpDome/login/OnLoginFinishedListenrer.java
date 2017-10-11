package cn.tanghaha.mvpDome.login;

/**
 * 登录事件监听器
 * Created by ${user} on 2017/10/11.
 */

public interface OnLoginFinishedListenrer
{
    void onSuccess();

    void onUserNameError();

    void onPasswordError();
}
