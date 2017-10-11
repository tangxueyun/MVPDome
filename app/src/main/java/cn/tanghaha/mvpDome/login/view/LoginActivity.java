package cn.tanghaha.mvpDome.login.view;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.tanghaha.mvpDome.R;
import cn.tanghaha.mvpDome.R2;
import cn.tanghaha.mvpDome.base.BaseActivity;
import cn.tanghaha.mvpDome.login.presenter.LoginPresenter;
import cn.tanghaha.mvpDome.login.presenter.LoginPresenterImpl;
import cn.tanghaha.mvpDome.weight.MyProgressDialog;

public class LoginActivity extends BaseActivity implements LoginView
{
    @BindView(R.id.login_username_et) EditText loginUsernameEt;
    @BindView(R.id.login_pwd_et) EditText loginPwdEt;

    private MyProgressDialog dialog = null;
    private LoginPresenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        dialog = new MyProgressDialog(this);
        presenter = new LoginPresenterImpl(this);
    }

    @OnClick(R2.id.login_btn)
    public void login()
    {
        presenter.login(loginUsernameEt.getText().toString(), loginPwdEt.getText().toString());
    }

    @Override
    public void showLoginInfo()
    {
        Toast.makeText(this, "用户名：" + loginUsernameEt.getText().toString() + "\n密码：" + loginPwdEt
                .getText().toString(), Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void loginError(String msg)
    {
        Toast.makeText(this, "登录失败：" + msg, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showProgress()
    {
        if (dialog == null)
            dialog = new MyProgressDialog(this);
        dialog.show();
    }

    @Override
    public void hideProgress()
    {
        if (dialog != null) dialog.dismiss();
    }

    @Override
    public void showErrorProgress()
    {
    }

    @Override
    public void hideErrorProgress()
    {
    }
}
