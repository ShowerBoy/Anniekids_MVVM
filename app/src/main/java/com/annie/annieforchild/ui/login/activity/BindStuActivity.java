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
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityBindStuBinding;
import com.annie.annieforchild.ui.login.vm.AddStuViewModel;
import com.annie.annieforchild.utils.SystemUtils;

import me.goldze.mvvmhabit.base.BaseActivity;

public class BindStuActivity extends BaseActivity<ActivityBindStuBinding, AddStuViewModel> {
    private CountDownTimer countDownTimer;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_bind_stu;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        binding.goBack.setVisibility(View.VISIBLE);
        binding.titleBar.setText("绑定");
        binding.bindStuUsername.addTextChangedListener(textWatcher);
        binding.bindStuVcode.addTextChangedListener(textWatcher);
        SystemUtils.setEditTextHintSize(binding.bindStuUsername, "请输入学员ID号 例：100412345", 12);
        SystemUtils.setEditTextHintSize(binding.bindStuVcode, "请输入验证码", 12);
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

    @Override
    public AddStuViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(AddStuViewModel.class);
    }

    @Override
    public void initViewObservable() {
        viewModel.uc.pVcodeEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (viewModel.uc.pVcodeEvent.getValue()){
                    binding.getVcode.setClickable(false);
                    countDownTimer.start();
                }
            }
        });
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
            if (viewModel.username.get() != null && viewModel.username.get().length() > 0
                    && viewModel.vcode.get() != null && viewModel.vcode.get().length() > 0) {
                binding.confirmBtn.setEnabled(true);
            } else {
                binding.confirmBtn.setEnabled(false);
            }
        }
    };
}
