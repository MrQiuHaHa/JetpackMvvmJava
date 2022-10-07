package com.davis.jetpackmvvm.callback.livedata;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

/**
 * 自定义的Double类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 */
public class DoubleLiveData extends MutableLiveData<Double> {
    @Nullable
    @Override
    public Double getValue() {
        return super.getValue() == null ? 0.0 : super.getValue();
    }
}
