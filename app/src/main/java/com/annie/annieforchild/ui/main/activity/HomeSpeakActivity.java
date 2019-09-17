package com.annie.annieforchild.ui.main.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityHomeSpeakBinding;
import com.annie.annieforchild.ui.main.vm.HomeSpeakViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class HomeSpeakActivity extends BaseActivity <ActivityHomeSpeakBinding, HomeSpeakViewModel>{


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_home_speak;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public HomeSpeakViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this,factory).get(HomeSpeakViewModel.class);
    }
}
