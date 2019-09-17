package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.ui.main.activity.EarListActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * Created by shen
 * on 2019/8/28
 */


public class HomeEarViewModel  extends BaseViewModel<DemoRepository> {
   public ObservableField<String> name=new ObservableField<>();

    public HomeEarViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

    public BindingCommand onBindEarClik  =new BindingCommand(new BindingAction() {
        @Override
        public void call() {
//            startActivity(EarListActivity.class);
        }
    });



}
