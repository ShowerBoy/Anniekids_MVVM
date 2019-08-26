package com.annie.annieforchild.ui.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Fragment基类
 */

public abstract class BaseFragment extends Fragment {

    protected View mContentView;
//    protected LoadingUtil loadingUtil;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(getLayoutId(), container, false);
        initPage();
        return  mContentView;
    }

    @Override
    public void onStart() {
        super.onStart();
//        loadingUtil = new LoadingUtil();
    }

//    public void showLoading(){loadingUtil.showLoadingDialog(getContext());}
//
//    public void hideLoading(){loadingUtil.dismissLoadDialog();}

    /**
     * 返回界面的布局
     */
    protected abstract int getLayoutId();

    //页面初始化
    protected abstract void initPage();
}
