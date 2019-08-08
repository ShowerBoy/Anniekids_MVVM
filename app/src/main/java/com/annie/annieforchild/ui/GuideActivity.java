package com.annie.annieforchild.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityGuideBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

public class GuideActivity extends BaseActivity<ActivityGuideBinding, GuideViewModel> {

    @Override
    public void initData() {
        viewModel.guide();
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_guide;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public GuideViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(GuideViewModel.class);
    }
}
