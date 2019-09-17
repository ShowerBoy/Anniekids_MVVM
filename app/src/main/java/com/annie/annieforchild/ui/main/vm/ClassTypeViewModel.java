package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.ui.main.activity.ClassTypeActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * Created by shen
 * on 2019/8/28
 */


public class ClassTypeViewModel  extends BaseViewModel<DemoRepository> {
    public ObservableField<String> name=new ObservableField<>();
    public ObservableField<String> age=new ObservableField<>();


    public ClassTypeViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

    public BindingCommand  onBindClassTypeClik=new BindingCommand(new BindingAction() {
        @Override
        public void call() {
              startActivity(ClassTypeActivity.class);
        }
    });


}
