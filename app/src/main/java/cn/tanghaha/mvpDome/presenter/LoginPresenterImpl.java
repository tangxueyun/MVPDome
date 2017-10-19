package cn.tanghaha.mvpDome.presenter;

import android.support.annotation.NonNull;

import cn.tanghaha.mvpDome.model.LoginModel;
import cn.tanghaha.mvpDome.model.LoginModelImpl;
import cn.tanghaha.mvpDome.view.LoginView;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * 实现LoginPresenter接口，和对登录界面的model层和view层的交互和操作
 * Created by ${user} on 2017/10/11.
 */

public class LoginPresenterImpl implements LoginPresenter
{
    private LoginView loginView = null;
    private LoginModel loginModel = null;


    public LoginPresenterImpl(LoginView loginView)
    {
        this.loginView = loginView;
        loginModel = new LoginModelImpl();
    }

    public LoginPresenterImpl(@NonNull LoginView loginView, @NonNull LoginModel loginModel)
    {
        this.loginView = checkNotNull(loginView, "loginView cannot be null");
        this.loginModel = checkNotNull(loginModel, "loginModel cannot be null");
    }

    @Override
    public void loadStart()
    {

    }

    @Override
    public void login(String userName, String password)
    {

        if (loginView != null)
            loginView.showProgress(true);

        loginModel.login(userName, password, new LoginModel.OnLoginFinishedListener()
        {
            @Override
            public void onSuccess()
            {
                if (loginView != null)
                {
                    loginView.showProgress(false);
                    loginView.showLoginInfo();
                    loginView.toHomePage();
                }
            }

            @Override
            public void onUserNameError()
            {
                if (loginView != null)
                {
                    loginView.showProgress(false);
                    loginView.loginError("用户名错误");
                }
            }

            @Override
            public void onPasswordError()
            {
                if (loginView != null)
                {
                    loginView.showProgress(false);
                    loginView.loginError("密码错误");
                }
            }
        });
    }
}
