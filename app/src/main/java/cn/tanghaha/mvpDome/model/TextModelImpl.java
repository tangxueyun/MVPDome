package cn.tanghaha.mvpDome.model;

import android.text.TextUtils;

/**
 * Created by ${user} on 2017/10/19.
 */

public class TextModelImpl implements TextModel
{

    @Override
    public void checkText(String text, OnTextListener listener)
    {
        if (TextUtils.isEmpty(text))
            listener.onError();
        else listener.onSuccess();
    }
}
