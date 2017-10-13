package cn.tanghaha.mvpDome.util;

import cn.tanghaha.mvpDome.base.BaseResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 网络回调接口
 * Created by ${user} on 2017/10/13.
 */

public abstract class WebCallback<T extends BaseResponse> implements Callback
{

    @Override
    public void onResponse(Call call, Response response)
    {

    }


    @Override
    public void onFailure(Call call, Throwable t)
    {

    }

}
