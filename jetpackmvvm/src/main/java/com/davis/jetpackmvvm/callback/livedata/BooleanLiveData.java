package com.davis.jetpackmvvm.callback.livedata;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

/**
 * 自定义的Boolean类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 */
public class BooleanLiveData extends MutableLiveData<Boolean> {
    @Nullable
    @Override
    public Boolean getValue() {
        return super.getValue() != null ? super.getValue() : false;
    }
}
