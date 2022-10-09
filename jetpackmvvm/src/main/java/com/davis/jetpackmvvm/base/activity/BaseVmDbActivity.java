package com.davis.jetpackmvvm.base.activity;

import android.view.View;

import androidx.databinding.ViewDataBinding;

import com.davis.jetpackmvvm.base.viewmodel.BaseViewModel;

public abstract class BaseVmDbActivity<VM extends BaseViewModel, DB extends ViewDataBinding> extends BaseVmActivity<VM> {

    @Override
    public int layoutId() {
        return 0;
    }

    public DB mDatabind;

    @Override
    public View initDataBind() {
//        mDatabind = inflateBindingWithGeneric(getLayoutInflater());
        return mDatabind.getRoot();
    }
}
