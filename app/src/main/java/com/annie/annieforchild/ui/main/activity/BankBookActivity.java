package com.annie.annieforchild.ui.main.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;

import com.annie.annieforchild.databinding.ActivityBankBookBinding;
import com.annie.annieforchild.ui.main.vm.BankBookViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class BankBookActivity extends BaseActivity<ActivityBankBookBinding, BankBookViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_bank_book;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public BankBookViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this,factory).get(BankBookViewModel.class);

    }
}
