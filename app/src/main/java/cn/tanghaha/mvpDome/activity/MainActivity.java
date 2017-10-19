package cn.tanghaha.mvpDome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
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
import cn.tanghaha.mvpDome.presenter.TextPresenter;
import cn.tanghaha.mvpDome.presenter.TextPresenterImpl;
import cn.tanghaha.mvpDome.view.LoginView;
import cn.tanghaha.mvpDome.view.TextView;
import cn.tanghaha.mvpDome.weight.MyProgressDialog;

/**
 * 首页
 */
public class MainActivity extends BaseActivity implements LoginView, TextView
{
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.login_username_et) EditText loginUsernameEt;
    @BindView(R.id.login_pwd_et) EditText loginPwdEt;
    @BindView(R.id.content_et) EditText contentEt;
    @BindView(R.id.content_tv) android.widget.TextView contentTv;

    private MyProgressDialog dialog = null;

    private LoginPresenter loginPresenter = null;
    private TextPresenter textPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //设置toolbar
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
//        bar.setDisplayHomeAsUpEnabled(true);//左侧显示返回上一级界面的按钮
        bar.setDisplayShowHomeEnabled(true);

        dialog = new MyProgressDialog(this);

        loginPresenter = new LoginPresenterImpl(this);
        textPresenter = new TextPresenterImpl(this);
    }

    @OnClick(R2.id.login_btn)
    public void login()
    {
        loginPresenter.login(loginUsernameEt.getText().toString(), loginPwdEt.getText().toString());
    }

    @OnClick(R2.id.show_content_btn)
    public void showContent()
    {
        textPresenter.checkText(contentEt.getText().toString());
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
    public void toHomePage()
    {
        startActivity(new Intent(this, LoginActivity.class));
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
    public void showText()
    {
        contentTv.setText(contentEt.getText());
    }

    @Override
    public void showErrorMsg()
    {
        contentTv.setText("ERROR:内容文本为空");
    }
}
