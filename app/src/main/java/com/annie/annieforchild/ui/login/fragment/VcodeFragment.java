package com.annie.annieforchild.ui.login.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.R;
import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.databinding.FragmentVcodeBinding;
import com.annie.annieforchild.ui.login.vm.LoginViewModel;
import com.annie.annieforchild.ui.login.vm.VcodeViewModel;
import com.annie.annieforchild.utils.SystemUtils;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.base.BaseViewModel;

public class VcodeFragment extends BaseFragment<FragmentVcodeBinding, VcodeViewModel> {
    private CountDownTimer countDownTimer;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_vcode;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public VcodeViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(VcodeViewModel.class);
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
        binding.editVphone.addTextChangedListener(textWatcher);
        binding.editVcode.addTextChangedListener(textWatcher);
        SystemUtils.setEditTextHintSize(binding.editVphone, "请输入手机号", 12);
        SystemUtils.setEditTextHintSize(binding.editVcode, "请输入验证码", 12);
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
                    && viewModel.vcode.get() != null && viewModel.vcode.get().length() > 0) {
                binding.vloginBtn.setEnabled(true);
            } else {
                binding.vloginBtn.setEnabled(false);
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
        countDownTimer = null;
    }
}
