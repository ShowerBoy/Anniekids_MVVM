package com.annie.annieforchild.ui.main.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivitySearchBinding;
import com.annie.annieforchild.ui.main.vm.SearchViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class SearchActivity extends BaseActivity <ActivitySearchBinding, SearchViewModel>{

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_search;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public SearchViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this,factory).get(SearchViewModel.class);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        binding.ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.annikidsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           startActivity(SortSearchActivity.class);

            }
        });
    }
}
