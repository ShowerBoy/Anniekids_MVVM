package com.annie.annieforchild.ui.main.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityClassTypeBinding;
import com.annie.annieforchild.ui.main.home.adapter.SimpleAdapter;
import com.annie.annieforchild.ui.main.vm.ClassTypeViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ClassTypeActivity extends BaseActivity<ActivityClassTypeBinding, ClassTypeViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_class_type;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public ClassTypeViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(ClassTypeViewModel.class);
    }

    @Override
    public void initData() {
        super.initData();
    }
}
