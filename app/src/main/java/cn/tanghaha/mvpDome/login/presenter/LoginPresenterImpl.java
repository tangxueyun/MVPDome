package cn.tanghaha.mvpDome.login.presenter;

import cn.tanghaha.mvpDome.login.OnLoginFinishedListenrer;
import cn.tanghaha.mvpDome.login.model.LoginModel;
import cn.tanghaha.mvpDome.login.view.LoginView;

/**
 * 实现LoginPresenter接口，和对登录界面的model层和view层的交互和操作
 * Created by ${user} on 2017/10/11.
 */

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListenrer
{
    private LoginView loginView = null;
    private LoginModel loginModel = null;


    public LoginPresenterImpl(LoginView loginView)
    {
        this.loginView = loginView;
        loginModel = new LoginModel();
    }

    public LoginPresenterImpl(LoginView loginView, LoginModel loginModel)
    {
        this.loginModel = loginModel;
        this.loginView = loginView;
    }

    @Override
    public void loadStart()
    {
    }

    @Override
    public void onSuccess()
    {
        if (loginView != null)
        {
            loginView.hideProgress();
            loginView.showLoginInfo();
        }
    }

    @Override
    public void onUserNameError()
    {
        if (loginView != null)
        {
            loginView.hideProgress();
            loginView.loginError("用户名错误");
        }
    }

    @Override
    public void onPasswordError()
    {
        if (loginView != null)
        {
            loginView.hideProgress();
            loginView.loginError("密码错误");
        }
    }

    @Override
    public void login(String userName, String password)
    {

        if (loginView != null)
            loginView.showProgress();

        loginModel.login(userName, password, this);
    }
}
