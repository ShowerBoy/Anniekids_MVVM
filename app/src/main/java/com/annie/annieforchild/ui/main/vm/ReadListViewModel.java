package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * Created by shen
 * on 2019/8/28
 */


public class ReadListViewModel extends BaseViewModel<DemoRepository> {
    public ReadListViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

    public BindingCommand onBackClik=new BindingCommand(new BindingAction() {
        @Override
        public void call() {
finish();
        }
    });
}
