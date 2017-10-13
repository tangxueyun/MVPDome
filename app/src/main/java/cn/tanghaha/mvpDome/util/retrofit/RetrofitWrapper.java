package cn.tanghaha.mvpDome.util.retrofit;

import java.util.concurrent.TimeUnit;

import cn.tanghaha.mvpDome.constant.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络接口的工具类
 * Created by ${user} on 2017/10/13.
 */

public class RetrofitWrapper
{
    private static RetrofitWrapper instance;
    private Retrofit retrofit;

    public static final int DEFAULT_TIMEOUT = 30;

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor
                    (new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    /**
     * 构造器
     */
    private RetrofitWrapper()
    {
        retrofit = new Retrofit.Builder().baseUrl(Constants.getHost()).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    /**
     * 单例模式
     *
     * @return RetrofitWrapper的实例对象
     */
    public static RetrofitWrapper getInstance()
    {
        if (instance == null)
        {
            synchronized (RetrofitWrapper.class)
            {
                if (instance == null)
                    instance = new RetrofitWrapper();
            }
        }
        return instance;
    }

    /**
     * 创建请求服务
     *
     * @param service 接口服务
     * @param <T>
     * @return
     */
    public <T> T create(final Class<T> service)
    {
        return retrofit.create(service);
    }
}
