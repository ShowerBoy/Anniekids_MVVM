package com.annie.annieforchild.ui.main.activity;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityEarListBinding;
import com.annie.annieforchild.ui.main.vm.EarListViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class EarListActivity extends BaseActivity<ActivityEarListBinding, EarListViewModel> {



    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_ear_list;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public EarListViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this,factory).get(EarListViewModel.class);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        binding.onBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
