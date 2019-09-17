package com.annie.annieforchild.ui.main.home.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.R;
import com.annie.annieforchild.constant.Constant;
import com.annie.annieforchild.databinding.FragmentBridgeBookBinding;
import com.annie.annieforchild.entity.PictureBookBean;
import com.annie.annieforchild.ui.main.home.adapter.PictureBookAdapter;
import com.annie.annieforchild.ui.main.vm.BridgeBookVieModel;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by shen
 * on 2019/8/31
 */


public class BridgeBookFragment  extends BaseFragment<FragmentBridgeBookBinding, BridgeBookVieModel> {

    public ViewModelProvider  viewModelProvider;
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_bridge_book;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        GridLayoutManager  manager =new GridLayoutManager(getContext(),3);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.bridgeBookRcview.setLayoutManager(manager);
    }


    @Override
    public BridgeBookVieModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.destroyInstance(getActivity().getApplication());
         return ViewModelProviders.of(this,factory).get(BridgeBookVieModel.class);
    }

    @Override
    public void initData() {
        super.initData();
        List<PictureBookBean> bookBeans=new ArrayList<>();
        bookBeans.add(new PictureBookBean(Constant.TEST_IMG1,"亲子故事会1","23本"));
        bookBeans.add(new PictureBookBean(Constant.TEST_IMG2,"亲子故事会2","23本"));
        bookBeans.add(new PictureBookBean(Constant.TEST_IMG3,"亲子故事会3","23本"));

//        PictureBookAdapter adapter=new PictureBookAdapter(getContext(),bookBeans,viewModelProvider);
//        binding.bridgeBookRcview.setAdapter(adapter);
    }
}
