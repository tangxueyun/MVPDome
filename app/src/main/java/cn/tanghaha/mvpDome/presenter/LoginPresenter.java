package cn.tanghaha.mvpDome.presenter;

import cn.tanghaha.mvpDome.base.BasePresenter;

/**
 * 继承BasePresenter，和对登录界面的model层和view层的交互和操作
 * Created by ${user} on 2017/10/11.
 */

public interface LoginPresenter extends BasePresenter
{
    void login(String userName, String password);
}
