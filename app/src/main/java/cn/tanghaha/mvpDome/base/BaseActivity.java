package cn.tanghaha.mvpDome.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.tanghaha.mvpDome.R;

/**
 * 用于被继承的activity基类
 */
public class BaseActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
