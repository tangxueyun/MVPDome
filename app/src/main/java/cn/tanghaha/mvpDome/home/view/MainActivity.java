package cn.tanghaha.mvpDome.home.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.tanghaha.mvpDome.R;
import cn.tanghaha.mvpDome.R2;
import cn.tanghaha.mvpDome.base.BaseActivity;
import cn.tanghaha.mvpDome.util.L;

import static cn.tanghaha.mvpDome.R.id.fab;

/**
 * 首页
 */
public class MainActivity extends BaseActivity
{
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fabtn;

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
    }

    @OnClick(R2.id.fab)
    public void btnAction(View view)
    {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


}
