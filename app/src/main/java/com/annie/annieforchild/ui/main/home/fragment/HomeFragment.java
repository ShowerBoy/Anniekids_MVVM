package com.annie.annieforchild.ui.main.home.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.FragmentHomeBinding;

import com.annie.annieforchild.ui.main.activity.SearchActivity;
import com.annie.annieforchild.ui.main.home.adapter.SimpleAdapter;
import com.annie.annieforchild.ui.main.vm.HomepageViewModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseFragment;


public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomepageViewModel> implements OnRefreshListener {
    public Context context;
    private List mData;
    private SimpleAdapter adapter;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return R.layout.fragment_home;
     }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }



    @Override
    public HomepageViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this,factory).get(HomepageViewModel.class);
    }

    @Override
    public void initData() {
        super.initData();
        initObservable();
        initRecycler();
        viewModel.getData("https://testapici.anniekids.com/Api/v2/Homepage/getHomeData");

    }

    private void initObservable() {
        viewModel.listData.observe(this , new Observer<List>() {
            @Override
            public void onChanged(@Nullable List list) {
                binding.swipLayout.finishRefresh();
                mData = list;
                adapter.setmData(mData);
            }
        });

    }

    private void initRecycler() {
        mData=new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.homeRcv.setLayoutManager(manager);
        binding.homeRcv.setHasFixedSize(true);
        binding.homeRcv.setNestedScrollingEnabled(false);


        adapter = new SimpleAdapter(getContext(),mData,this,ViewModelProviders.of(this,AppViewModelFactory.getInstance(getActivity().getApplication())));
        binding.homeRcv.setAdapter(adapter);
        binding.swipLayout.setOnRefreshListener(this);

        binding.imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SearchActivity.class);
            }
        });

    }


    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        viewModel.getData("https://testapici.anniekids.com/Api/v2/Homepage/getHomeData");
    }


}
