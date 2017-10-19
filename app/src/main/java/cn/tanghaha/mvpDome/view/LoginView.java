package cn.tanghaha.mvpDome.view;

import cn.tanghaha.mvpDome.base.BaseView;


public interface LoginView extends BaseView
{
    void showLoginInfo();

    void loginError(String msg);

    void toHomePage();
}
