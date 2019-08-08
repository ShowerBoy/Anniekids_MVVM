package com.annie.annieforchild.ui.login.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.ui.login.activity.LoginActivity;
import com.annie.annieforchild.ui.main.activity.MainActivity;
import com.annie.annieforchild.ui.main.vm.MainViewModel;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class LoginViewModel extends BaseViewModel<DemoRepository> {

    public LoginViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

    /**
     * 获取验证码
     */
    public BindingCommand onGetVcodeClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });

    public void login() {

    }

}
