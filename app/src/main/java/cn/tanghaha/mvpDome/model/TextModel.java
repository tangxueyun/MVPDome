package cn.tanghaha.mvpDome.model;

/**
 * Created by ${user} on 2017/10/19.
 */

public interface TextModel
{
    interface OnTextListener
    {
        void onSuccess();

        void onError();
    }

    void checkText(String text, OnTextListener listener);
}
