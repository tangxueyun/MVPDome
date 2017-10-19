package cn.tanghaha.mvpDome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.tanghaha.mvpDome.R;
import cn.tanghaha.mvpDome.R2;
import cn.tanghaha.mvpDome.base.BaseActivity;
import cn.tanghaha.mvpDome.presenter.LoginPresenter;
import cn.tanghaha.mvpDome.presenter.LoginPresenterImpl;
import cn.tanghaha.mvpDome.view.LoginView;
import cn.tanghaha.mvpDome.activity.MainActivity;
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
    public void showProgress(boolean isShow)
    {
        if (dialog == null) return;
        if (isShow)
            dialog.show();
        else dialog.dismiss();
    }

    @Override
    public void showErrorProgress()
    {
    }

    @Override
    public void hideErrorProgress()
    {
    }

    @Override
    public void toHomePage()
    {
        startActivity(new Intent(this, MainActivity.class));
    }

}
