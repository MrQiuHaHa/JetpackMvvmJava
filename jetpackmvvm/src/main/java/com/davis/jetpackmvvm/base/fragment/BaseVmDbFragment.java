package com.davis.jetpackmvvm.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.davis.jetpackmvvm.base.viewmodel.BaseViewModel;

public abstract class BaseVmDbFragment<VM extends BaseViewModel, DB extends ViewDataBinding> extends BaseVmFragment<VM> {
    @Override
    int layoutId() {
        return 0;
    }

    public DB _binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        _binding  = inflateBindingWithGeneric(inflater,container,false);
        return _binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        _binding = null;
    }
}
