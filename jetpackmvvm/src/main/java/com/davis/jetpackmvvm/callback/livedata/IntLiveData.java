package com.davis.jetpackmvvm.callback.livedata;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

/**
 * :自定义的Int类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 */
public class IntLiveData extends MutableLiveData<Integer> {
    @Nullable
    @Override
    public Integer getValue() {
        return super.getValue() == null ? 0 : super.getValue();
    }
}
