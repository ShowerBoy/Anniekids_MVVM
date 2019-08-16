package com.annie.annieforchild.ui.login.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityAddStuBinding;
import com.annie.annieforchild.ui.login.vm.AddStuViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class AddStuActivity extends BaseActivity<ActivityAddStuBinding, AddStuViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_add_stu;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {

    }

    @Override
    public AddStuViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(AddStuViewModel.class);
    }
}
