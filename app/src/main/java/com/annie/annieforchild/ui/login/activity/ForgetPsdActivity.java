package com.annie.annieforchild.ui.login.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityForgetPsdBinding;
import com.annie.annieforchild.ui.login.vm.ForgetPsdViewModel;
import com.annie.annieforchild.ui.login.vm.VcodeViewModel;
import com.annie.annieforchild.utils.SystemUtils;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.RegexUtils;

public class ForgetPsdActivity extends BaseActivity<ActivityForgetPsdBinding, ForgetPsdViewModel> {
    private CountDownTimer countDownTimer;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_forget_psd;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public ForgetPsdViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(ForgetPsdViewModel.class);
    }

    @Override
    public void initViewObservable() {
        viewModel.uc.pVcodeEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (viewModel.uc.pVcodeEvent.getValue()) {
                    binding.getVcode.setClickable(false);
                    countDownTimer.start();
                }
            }
        });
    }

    @Override
    public void initData() {
        binding.goBack.setVisibility(View.VISIBLE);
        binding.titleBar.setText("忘记密码");
        binding.forgetPhone.addTextChangedListener(textWatcher);
        binding.forgetVcode.addTextChangedListener(textWatcher);
        binding.forgetPsd.addTextChangedListener(textWatcher);
        binding.forgetConfirmPsd.addTextChangedListener(textWatcher);
        SystemUtils.setEditTextInhibitInputSpeChat(binding.forgetPsd);
        SystemUtils.setEditTextInhibitInputSpeChat(binding.forgetConfirmPsd);
        SystemUtils.setEditTextHintSize(binding.forgetPhone, "请输入手机号", 12);
        SystemUtils.setEditTextHintSize(binding.forgetVcode, "请输入验证码", 12);
        SystemUtils.setEditTextHintSize(binding.forgetPsd, "请输入至少6位密码", 12);
        SystemUtils.setEditTextHintSize(binding.forgetConfirmPsd, "请再次输入密码", 12);
        countDownTimer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                binding.getVcode.setText(l / 1000 + "s后重新发送");
                binding.getVcode.setTextColor(getResources().getColor(R.color.text_gray));
            }

            @Override
            public void onFinish() {
                binding.getVcode.setText("获取验证码");
                binding.getVcode.setTextColor(getResources().getColor(R.color.text_orange));
                viewModel.uc.pVcodeEvent.setValue(false);
                binding.getVcode.setClickable(true);
            }
        };
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
                    && viewModel.vcode.get() != null && viewModel.vcode.get().length() > 0
                    && viewModel.psd.get() != null && viewModel.psd.get().length() > 0
                    && viewModel.confirmPsd.get() != null && viewModel.confirmPsd.get().length() > 0) {
                binding.confirmBtn.setEnabled(true);
            } else {
                binding.confirmBtn.setEnabled(false);
            }
        }
    };
}
