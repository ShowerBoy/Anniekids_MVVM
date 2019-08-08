package com.annie.annieforchild.ui.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.FragmentLoginBinding;
import com.annie.annieforchild.ui.login.vm.LoginViewModel;
import com.annie.annieforchild.ui.login.vm.VcodeViewModel;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.base.BaseViewModel;

public class LoginFragment extends BaseFragment{
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_login;
    }

    @Override
    public int initVariableId() {
        return 0;
    }
}
