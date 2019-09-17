package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Created by shen
 * on 2019/8/28
 */


public class HomeReadViewModel  extends BaseViewModel<DemoRepository> {
    public ObservableField<String> name=new ObservableField<>();

    public HomeReadViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }
}
