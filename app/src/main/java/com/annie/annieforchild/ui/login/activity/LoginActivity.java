package com.annie.annieforchild.ui.login.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityLoginBinding;
import com.annie.annieforchild.ui.adapter.BaseFragmentPagerAdapter;
import com.annie.annieforchild.ui.login.fragment.LoginFragment;
import com.annie.annieforchild.ui.login.fragment.VcodeFragment;
import com.annie.annieforchild.ui.login.vm.LoginViewModel;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {
    private List<Fragment> fragments;
    private List<String> strings;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public LoginViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(LoginViewModel.class);
    }

    @Override
    public void initData() {
        binding.topLayout.goBack.setVisibility(View.GONE);
        binding.topLayout.titleBar.setText("登陆");
        initViewPager();
    }

    private void initViewPager() {
        fragments = new ArrayList<>();
        strings = new ArrayList<>();
        fragments.add(new VcodeFragment());
        fragments.add(new LoginFragment());
        strings.add("验证码登陆");
        strings.add("密码登陆");
        BaseFragmentPagerAdapter pagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager(), fragments, strings);
        binding.viewPager.setOffscreenPageLimit(2);
        binding.viewPager.setAdapter(pagerAdapter);
        pagerAdapter.notifyDataSetChanged();
        binding.materialTabLayout.setViewPager(binding.viewPager);
    }
}
