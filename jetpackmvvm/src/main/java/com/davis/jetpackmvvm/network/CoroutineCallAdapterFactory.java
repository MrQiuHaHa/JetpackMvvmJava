package com.davis.jetpackmvvm.network;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class CoroutineCallAdapterFactory extends CallAdapter.Factory {
    private CoroutineCallAdapterFactory() {}
    private static final CoroutineCallAdapterFactory factory = new CoroutineCallAdapterFactory();

    public static CoroutineCallAdapterFactory create() {
        return factory;
    }
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {

        return null;
    }
}
