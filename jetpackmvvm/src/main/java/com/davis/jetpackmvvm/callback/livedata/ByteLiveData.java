package com.davis.jetpackmvvm.callback.livedata;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

/**
 * 自定义的Short类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 */
public class ByteLiveData extends MutableLiveData<Byte> {
    @Nullable
    @Override
    public Byte getValue() {
        return super.getValue() == null ? 0 : super.getValue();
    }
}
