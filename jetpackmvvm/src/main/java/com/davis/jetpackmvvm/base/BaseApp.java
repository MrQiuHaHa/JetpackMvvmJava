package com.davis.jetpackmvvm.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
/*
*   实现在Activity/fragment中获取Application级别的ViewModel
* */
public class BaseApp extends Application implements ViewModelStoreOwner {

    private ViewModelStore mAppViewModelStore;
    private ViewModelProvider.Factory mFactory;
    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return mAppViewModelStore;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppViewModelStore = new ViewModelStore();
    }

    /*
    *   获取一个全局的ViewModel
    * */
    ViewModelProvider getAppViewModelProvider() {
        return new ViewModelProvider(this, this.getAppFactory());
    }

    private ViewModelProvider.Factory getAppFactory() {
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(this);
        }
        return mFactory;
    }
}
