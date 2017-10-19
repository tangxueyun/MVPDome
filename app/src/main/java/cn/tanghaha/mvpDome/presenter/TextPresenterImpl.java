package cn.tanghaha.mvpDome.presenter;

import cn.tanghaha.mvpDome.model.TextModel;
import cn.tanghaha.mvpDome.model.TextModelImpl;
import cn.tanghaha.mvpDome.view.TextView;

/**
 * Created by ${user} on 2017/10/19.
 */

public class TextPresenterImpl implements TextPresenter
{
    private TextView view = null;
    private TextModel model = null;

    public TextPresenterImpl(TextView view)
    {
        this.view = view;
        model = new TextModelImpl();
    }

    @Override
    public void loadStart()
    {
    }

    @Override
    public void checkText(String text)
    {
        if (view != null) view.showProgress(true);

        model.checkText(text, new TextModel.OnTextListener()
        {
            @Override
            public void onSuccess()
            {
                if (view != null)
                {
                    view.showProgress(false);
                    view.showText();
                }
            }

            @Override
            public void onError()
            {
                if (view != null)
                {
                    view.showProgress(false);
                    view.showErrorMsg();
                }
            }
        });
    }
}