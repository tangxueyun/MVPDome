package cn.tanghaha.mvpDome.login.presenter;

import org.junit.Before;
import org.junit.Test;

import cn.tanghaha.mvpDome.login.model.LoginModel;
import cn.tanghaha.mvpDome.login.view.LoginView;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by ${user} on 2017/10/11.
 */
public class LoginPresenterTest
{
    LoginPresenter presenter;
    LoginView view;
    LoginModel model;

    @Before
    public void setUp() throws Exception
    {
        view = mock(LoginView.class);
        model = mock(LoginModel.class);

        presenter = new LoginPresenterImpl(view, model);
    }

    @Test
    public void login() throws Exception
    {

    }

}