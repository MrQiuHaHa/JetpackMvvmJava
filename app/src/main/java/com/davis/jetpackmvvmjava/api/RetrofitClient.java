package com.davis.jetpackmvvmjava.api;

import com.davis.business.student.Api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://192.168.0.117:8080/pagingserver_war/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
    }

    private OkHttpClient getClient() { return new OkHttpClient.Builder().build(); }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public <T> T getApi(Class<T> servic) {
        return retrofit.create(servic);
    }
}
