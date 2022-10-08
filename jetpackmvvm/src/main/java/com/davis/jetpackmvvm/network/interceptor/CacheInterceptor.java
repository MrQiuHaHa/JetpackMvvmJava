package com.davis.jetpackmvvm.network.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 缓存拦截器, 缓存天数 默认7天
 */
public class CacheInterceptor implements Interceptor {

    public int day = 7;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        return null;
    }
}
