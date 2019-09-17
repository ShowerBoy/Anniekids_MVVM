package com.annie.annieforchild.ui.main.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityHomeReadBinding;
import com.annie.annieforchild.ui.main.vm.HomeReadViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class HomeReadActivity extends BaseActivity<ActivityHomeReadBinding, HomeReadViewModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_home_read;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public HomeReadViewModel initViewModel() {

        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this,factory).get(HomeReadViewModel.class);
    }
}
