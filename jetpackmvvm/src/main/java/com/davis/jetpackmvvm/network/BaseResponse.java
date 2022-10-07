package com.davis.jetpackmvvm.network;

/**
 * 描述　: 服务器返回数据的基类
 * 如果需要框架帮你做脱壳处理请继承它！！请注意：
 * 2.必须实现抽象方法，根据自己的业务判断返回请求结果是否成功
 */
public abstract class BaseResponse<T> {
    public abstract Boolean isSucces();
    public abstract T getResponseData();
    public abstract int getResponseCode();
    public abstract String getResponseMsg();
}
