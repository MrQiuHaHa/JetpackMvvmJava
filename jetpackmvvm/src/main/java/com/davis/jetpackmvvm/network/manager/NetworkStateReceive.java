package com.davis.jetpackmvvm.network.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.davis.jetpackmvvm.network.NetworkUtil;

/**
 * 网络变化接收器
 */
public class NetworkStateReceive extends BroadcastReceiver {

    boolean isInit = true;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction() == ConnectivityManager.CONNECTIVITY_ACTION) {
            if (!isInit) {
                NetState state = NetworkStateManager.instance().mNetworkStateCallback.getValue();
                if (!NetworkUtil.isNetworkAvailable(context)) {
                    //收到没有网络时判断之前的值是不是有网络，如果有网络才提示通知 ，防止重复通知
                    if (state == null || state.isSuccess) {
                        NetworkStateManager.instance().mNetworkStateCallback.setValue(new NetState(false));
                    }
                } else {
                    //收到有网络时判断之前的值是不是没有网络，如果没有网络才提示通知 ，防止重复通知
                    if (state == null || !state.isSuccess) {
                        NetworkStateManager.instance().mNetworkStateCallback.setValue(new NetState(true));
                    }
                }
            }

            isInit = false;
        }
    }
}
