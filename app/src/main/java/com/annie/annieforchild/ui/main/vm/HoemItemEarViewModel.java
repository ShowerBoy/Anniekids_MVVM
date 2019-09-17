package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class HoemItemEarViewModel extends BaseViewModel<DemoRepository> {
    public ObservableField<String> title=new ObservableField<>();

    public HoemItemEarViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }
}
