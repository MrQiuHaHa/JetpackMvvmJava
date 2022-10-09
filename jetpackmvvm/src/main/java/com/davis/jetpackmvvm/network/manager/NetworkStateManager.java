package com.davis.jetpackmvvm.network.manager;

import com.davis.jetpackmvvm.callback.livedata.event.EventLiveData;

/**
 * 网络变化管理者
 */
public class NetworkStateManager {
    private NetworkStateManager() {}
    private static final NetworkStateManager manager = new NetworkStateManager();

    public EventLiveData<NetState> mNetworkStateCallback = new  EventLiveData<NetState>();

    public static NetworkStateManager instance() {
        return manager;
    }
}
