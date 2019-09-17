package com.annie.annieforchild.ui.main.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivitySortSearchBinding;
import com.annie.annieforchild.ui.main.home.adapter.HomeSearchPagerAdapter;
import com.annie.annieforchild.ui.main.vm.SortSearchViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class SortSearchActivity extends BaseActivity<ActivitySortSearchBinding, SortSearchViewModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_sort_search;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public SortSearchViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());

        return ViewModelProviders.of(this,factory).get(SortSearchViewModel.class);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        HomeSearchPagerAdapter  adapter=new HomeSearchPagerAdapter(getSupportFragmentManager());
        binding.tabSearch.setupWithViewPager(binding.searchViewpager);
        binding.searchViewpager.setAdapter(adapter);
    }

    @Override
    public void initData() {
        super.initData();
        initRcycler();
    }

    private void initRcycler() {
        binding.ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
