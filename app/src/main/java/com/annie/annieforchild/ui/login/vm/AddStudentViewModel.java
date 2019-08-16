package com.annie.annieforchild.ui.login.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.ui.login.activity.AddStuActivity;
import com.annie.annieforchild.ui.login.activity.BindStuActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class AddStudentViewModel extends BaseViewModel<DemoRepository> {

    public AddStudentViewModel(@NonNull Application application) {
        super(application);
    }

    public AddStudentViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

    public BindingCommand onBindStuClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(BindStuActivity.class);
        }
    });

    public BindingCommand onAddStuClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(AddStuActivity.class);
        }
    });
}
