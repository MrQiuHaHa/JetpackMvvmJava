package com.davis.jetpackmvvm.network;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public abstract class BaseNetworkApi {

    public <T> T getApi(Class<T> serviceClass, String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOKHttpClient());

        return setRetrofitBuilder(builder).build().create(serviceClass);
    }

    /**
     * 实现重写父类的setHttpClientBuilder方法，
     * 在这里可以添加拦截器，可以对 OkHttpClient.Builder 做任意操作
     */
    public abstract OkHttpClient.Builder setHttpClientBuilder(OkHttpClient.Builder builder);

    /**
     * 实现重写父类的setRetrofitBuilder方法，
     * 在这里可以对Retrofit.Builder做任意操作，比如添加GSON解析器，Protocol
     */
    public abstract Retrofit.Builder setRetrofitBuilder(Retrofit.Builder builder);

    /**
     * 配置http
     */
    private OkHttpClient getOKHttpClient() {
        OkHttpClient.Builder builder = RetrofitUrlManager.getInstance().with(new OkHttpClient.Builder());
        builder = setHttpClientBuilder(builder);
        return builder.build();
    }
}
