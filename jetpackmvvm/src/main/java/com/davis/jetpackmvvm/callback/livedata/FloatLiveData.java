package com.davis.jetpackmvvm.callback.livedata;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

public class FloatLiveData extends MutableLiveData<Float> {
    @Nullable
    @Override
    public Float getValue() {
        return super.getValue() != null ? super.getValue() : 0f;
    }
}
