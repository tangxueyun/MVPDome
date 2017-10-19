package cn.tanghaha.mvpDome.login.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cn.tanghaha.mvpDome.model.LoginModel;
import cn.tanghaha.mvpDome.view.LoginView;
import cn.tanghaha.mvpDome.presenter.LoginPresenter;
import cn.tanghaha.mvpDome.presenter.LoginPresenterImpl;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * 登录逻辑的单元测试
 */
public class LoginPresenterTest
{
    private static String USER_NAME = "123456";
    private static String PASSWORD = "123456";

    private LoginPresenter presenter;
    @Mock
    private LoginView view;
    @Mock
    private LoginModel model;
    @Captor
    private ArgumentCaptor<LoginModel.OnLoginFinishedListener> mLoginListenerCaptor;

    @Before
    public void setUp() throws Exception
    {
        //要在测试中注入@mock,需要调用initMocks方法，否则会报空指针错误
        MockitoAnnotations.initMocks(this);

        presenter = new LoginPresenterImpl(view, model);
    }

    @Test
    public void login()
    {//正确登录
        presenter.login(USER_NAME, PASSWORD);

        verify(view).showProgress(true);
        verify(model).login(eq(USER_NAME), eq(PASSWORD), mLoginListenerCaptor.capture());
        mLoginListenerCaptor.getValue().onSuccess();
        verify(view).showProgress(false);
        verify(view).showLoginInfo();
        verify(view).toHomePage();
    }

    @Test
    public void loginErrorUsername()
    {//用户名错误的登录
        presenter.login("", PASSWORD);

        verify(view).showProgress(true);
        verify(model).login(eq(""), eq(PASSWORD), mLoginListenerCaptor.capture());
        mLoginListenerCaptor.getValue().onUserNameError();
        verify(view).showProgress(false);
        verify(view).loginError("用户名错误");
    }

    @Test
    public void loginErrorPassword()
    {//密码错误的登录
        presenter.login(USER_NAME, "");

        verify(view).showProgress(true);
        verify(model).login(eq(USER_NAME), eq(""), mLoginListenerCaptor.capture());
        mLoginListenerCaptor.getValue().onPasswordError();
        verify(view).showProgress(false);
        verify(view).loginError("密码错误");
    }
}