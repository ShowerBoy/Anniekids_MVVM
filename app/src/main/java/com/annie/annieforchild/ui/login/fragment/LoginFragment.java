package com.annie.annieforchild.ui.login.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.FragmentLoginBinding;
import com.annie.annieforchild.ui.login.vm.LoginViewModel;
import com.annie.annieforchild.ui.login.vm.VcodeViewModel;
import com.annie.annieforchild.utils.SystemUtils;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.base.BaseViewModel;

public class LoginFragment extends BaseFragment<FragmentLoginBinding, LoginViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_login;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public LoginViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(LoginViewModel.class);
    }

    @Override
    public void initData() {
        binding.editPhone.addTextChangedListener(textWatcher);
        binding.editPsd.addTextChangedListener(textWatcher);
        SystemUtils.setEditTextHintSize(binding.editPhone, "请输入手机号", 12);
        SystemUtils.setEditTextHintSize(binding.editPsd, "请输入密码", 12);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (viewModel.phone.get() != null && viewModel.phone.get().length() > 0
                    && viewModel.psd.get() != null && viewModel.psd.get().length() > 0) {
                binding.loginBtn.setEnabled(true);
            } else {
                binding.loginBtn.setEnabled(false);
            }
        }
    };
}
