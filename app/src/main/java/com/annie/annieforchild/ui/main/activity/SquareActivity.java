package com.annie.annieforchild.ui.main.activity;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivitySquareBinding;
import com.annie.annieforchild.ui.main.vm.SquareViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class SquareActivity extends BaseActivity<ActivitySquareBinding, SquareViewModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_square;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public SquareViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this,factory).get(SquareViewModel.class);
    }
}
