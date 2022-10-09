package com.davis.jetpackmvvm.base.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.davis.jetpackmvvm.base.viewmodel.BaseViewModel;
import com.davis.jetpackmvvm.network.manager.NetState;
import com.davis.jetpackmvvm.network.manager.NetworkStateManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseVmActivity<VM extends BaseViewModel> extends AppCompatActivity {

    public VM mViewModel;

    public abstract int layoutId();

    public abstract void initView(Bundle savedInstanceState);

    public abstract void showLoading(String message);

    public abstract void dismissLoading();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = initDataBind();
        if (view != null) {
            setContentView(view);
        } else {
            setContentView(layoutId());
        }
        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        mViewModel = createViewModel();
        registerUiChange();
        initView(savedInstanceState);
        createObserver();
        NetworkStateManager.instance().mNetworkStateCallback.observe(this, new Observer<NetState>() {
            @Override
            public void onChanged(NetState netState) {
                onNetworkStateChanged(netState);
            }
        });
    }

    /**
     * 获取当前类绑定的泛型实例ViewModel-clazz
     * @return
     */
    private VM createViewModel() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        VM vm = (VM) new ViewModelProvider(this).get((VM)actualTypeArguments[0]);
        return vm;
    }

    /**
     * 网络变化监听 子类重写
     */
    public void onNetworkStateChanged(NetState netState) {}

    /**
     * 创建LiveData数据观察者
     */
    public abstract void createObserver();

    /**
     * 注册UI 事件
     */
    private void registerUiChange() {
        //显示弹窗
        mViewModel.loadingChange.showDialog.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                showLoading(s);
            }
        });

        //关闭弹窗
        mViewModel.loadingChange.dismissDialog.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                dismissLoading();
            }
        });
    }

    /**
     * 将非该Activity绑定的ViewModel添加 loading回调 防止出现请求时不显示 loading 弹窗bug
     * @param viewModels Array<out BaseViewModel>
     */
    protected void addLoadingObserve(BaseViewModel[] viewModels) {
        for (BaseViewModel viewModel : viewModels) {
            //显示弹窗
            viewModel.loadingChange.showDialog.observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    showLoading(s);
                }
            });

            //关闭弹窗
            viewModel.loadingChange.dismissDialog.observe(this, new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean aBoolean) {
                    dismissLoading();
                }
            });
        }
    }

    /**
     * 供子类BaseVmDbActivity 初始化Databinding操作
     */
    public View initDataBind() {
        return null;
    }
}
