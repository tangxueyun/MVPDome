package cn.tanghaha.mvpDome.weight;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import cn.tanghaha.mvpDome.R;

/**
 * Created by ${user} on 2017/10/11.
 */

public class MyProgressDialog extends ProgressDialog
{
    public MyProgressDialog(Context context)
    {
        super(context, R.style.ProgressDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //设置不可取消，点击其他区域不能取消，实际中可以抽出去封装供外包设置
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        //自定义界面
        setContentView(R.layout.dialog_progress);


        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

//    @Override
//    public void show()
//    {
//        super.show();
//    }
}
