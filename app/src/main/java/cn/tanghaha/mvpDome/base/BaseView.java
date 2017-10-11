package cn.tanghaha.mvpDome.base;

/**
 * view的抽象接口
 * Created by ${user} on 2017/10/10.
 */

public interface BaseView<T>
{
    /**
     * 显示进度框的抽象方法
     */
    void showProgress();

    /**
     * 隐藏进度框的抽象方法
     */
    void hideProgress();

    /**
     * 显示加载错误进度框的抽象方法
     */
    void showErrorProgress();

    /**
     * 隐藏加载错误进度框的抽象方法
     */
    void hideErrorProgress();
}
