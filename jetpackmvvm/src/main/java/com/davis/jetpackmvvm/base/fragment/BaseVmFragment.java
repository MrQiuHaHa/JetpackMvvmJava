package com.davis.jetpackmvvm.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.davis.jetpackmvvm.base.viewmodel.BaseViewModel;
import com.davis.jetpackmvvm.network.manager.NetState;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseVmFragment<VM extends BaseViewModel> extends Fragment {
    private Handler handler = new Handler();
    private Boolean isFirst = true;
    public VM mViewModel;
    public AppCompatActivity mActivity;

    /**
     * 当前Fragment绑定的视图布局
     */
    abstract int layoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutId(), container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (AppCompatActivity)context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isFirst = true;
        mViewModel = createViewModel();
        initView(savedInstanceState);
        createObserver();
        registerUiChange();
        initData();
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

    public abstract void initView(Bundle savedInstanceState);

    public abstract void showLoading(String message);

    public abstract void dismissLoading();

    /**
     * 网络变化监听 子类重写
     */
    public void onNetworkStateChanged(NetState netState) {}

    /**
     * 创建LiveData数据观察者
     */
    public abstract void createObserver();

    /**
     * Fragment执行onCreate后触发的方法
     */
    public void initData() {}

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
}
