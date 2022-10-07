package com.davis.jetpackmvvm.callback.livedata;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

/**
 * 自定义的Short类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 */
public class ShortLiveData extends MutableLiveData<Short> {
    @Nullable
    @Override
    public Short getValue() {
        return super.getValue() == null ? 0 : super.getValue();
    }
}
