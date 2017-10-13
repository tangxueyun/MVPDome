package cn.tanghaha.mvpDome.constant;

import cn.tanghaha.mvpDome.BuildConfig;

/**
 * app中的全局常量
 * Created by ${user} on 2017/10/13.
 */

public class Constants
{
    public static String getHost()
    {
        if (BuildConfig.DEBUG)
            //测试服
            return "";
        else //正式服
            return "";
    }

}
