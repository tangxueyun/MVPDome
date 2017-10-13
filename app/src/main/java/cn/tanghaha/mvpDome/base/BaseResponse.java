package cn.tanghaha.mvpDome.base;

/**
 * 请求网络接口的数据基类
 * Created by ${user} on 2017/10/13.
 */

public class BaseResponse<T>
{
    private String msg;
    private int code;
    private T data;

    public String getMsg()
    {
        return msg;
    }

    public int getCode()
    {
        return code;
    }

    public T getData()
    {
        return data;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
