package com.davis.jetpackmvvm.base;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.davis.jetpackmvvm.network.manager.NetworkStateReceive;

public class Ktx extends ContentProvider {

    static Application app;
    static boolean watchActivityLife = true;
    static boolean watchAppLife = true;
    static private NetworkStateReceive mNetworkStateReceive;

    @Override
    public boolean onCreate() {
        Application application = (Application)getContext().getApplicationContext();
        install(application);
        return true;
    }

    private void install(Application application) {
        Ktx.app = application;
        Ktx.mNetworkStateReceive = new NetworkStateReceive();
        Ktx.app.registerReceiver(
                Ktx.mNetworkStateReceive,
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        );
        if (Ktx.watchActivityLife) {
//            application.registerActivityLifecycleCallbacks();
        }
        if (Ktx.watchAppLife) {
//            ProcessLifecycleOwner.get().getLifecycle().addObserver();
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
