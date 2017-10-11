package cn.tanghaha.mvpDome.util;

import android.util.Log;

import cn.tanghaha.mvpDome.BuildConfig;

/**
 * 日志工具类
 * Created by ${user} on 2017/10/10.
 */

public class L
{
    //调试状态标识 true:调试状态  false:上线状态
    protected static final String TAG = "MVP_DOME";

    /**
     * 打印调试日志信息
     *
     * @param msg 调试日志信息
     */
    public static void d(String msg)
    {
        if (BuildConfig.DEBUG)
            Log.d(TAG, buildMsg(msg));
    }

    /**
     * 打印调试日志信息并记录异常
     *
     * @param msg 调试日志信息
     * @param thr 异常
     */
    public static void d(String msg, Throwable thr)
    {
        if (BuildConfig.DEBUG)
            Log.d(TAG, buildMsg(msg), thr);
    }

    /**
     * 打印日志信息
     *
     * @param msg 日志信息
     */
    public static void i(String msg)
    {
        if (BuildConfig.DEBUG)
            Log.i(TAG, buildMsg(msg));
    }

    /**
     * 打印日志信息并记录异常
     *
     * @param msg 日志信息
     * @param thr 异常
     */
    public static void i(String msg, Throwable thr)
    {
        if (BuildConfig.DEBUG)
            Log.d(TAG, buildMsg(msg), thr);
    }

    /**
     * 打印错误日志消息并记录异常
     *
     * @param msg 错误日志消息
     */
    public static void e(String msg)
    {
        if (BuildConfig.DEBUG)
            Log.e(TAG, buildMsg(msg));
    }

    /**
     * 打印错误日志消息并记录异常
     *
     * @param msg 错误日志消息
     * @param thr 异常
     */
    public static void e(String msg, Throwable thr)
    {
        if (BuildConfig.DEBUG)
            Log.e(TAG, buildMsg(msg), thr);
    }


    /**
     * 创建一个格式为类名.方法名===>日志信息的信息
     * <p>
     * StackTrace简述
     * 1 StackTrace用栈的形式保存了方法的调用信息.
     * 2 获取这些调用信息:
     * 可用Thread.currentThread().getStackTrace()方法
     * 得到当前线程的StackTrace信息.
     * 该方法返回的是一个StackTraceElement数组.
     * 3 该StackTraceElement数组就是StackTrace中的内容.
     * 4 遍历该StackTraceElement数组.就可以看到方法间的调用流程.
     * 比如线程中methodA调用了methodB那么methodA先入栈methodB再入栈.
     * 5 在StackTraceElement数组下标为2的元素中保存了当前方法的所属文件名,当前方法所属
     * 的类名,以及该方法的名字.除此以外还可以获取方法调用的行数.
     * 6 在StackTraceElement数组下标为3的元素中保存了当前方法的调用者的信息和它调用
     * 时的代码行数.
     *
     * @param msg 日志信息
     * @return
     */
    protected static String buildMsg(String msg)
    {
        StackTraceElement caller = new Throwable().fillInStackTrace().getStackTrace()[2];

        return new StringBuilder().append(caller.getClassName()).append(".").append(caller
                .getMethodName()).append("===>").append(msg).toString();
    }
}
