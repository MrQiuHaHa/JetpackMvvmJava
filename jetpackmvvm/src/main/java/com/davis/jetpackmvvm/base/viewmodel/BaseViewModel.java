package com.davis.jetpackmvvm.base.viewmodel;

import androidx.lifecycle.ViewModel;

import com.davis.jetpackmvvm.callback.livedata.event.EventLiveData;

public class BaseViewModel extends ViewModel {

    public UiLoadingChange loadingChange = new UiLoadingChange();

    /**
     * 内置封装好的可通知Activity/fragment 显示隐藏加载框 因为需要跟网络请求显示隐藏loading配套才加的
     */
    public class UiLoadingChange {
        //显示加载框
        public EventLiveData<String> showDialog = new EventLiveData<String>();
        //隐藏加载框
        public EventLiveData<Boolean> dismissDialog = new EventLiveData<Boolean>();
    }
}
