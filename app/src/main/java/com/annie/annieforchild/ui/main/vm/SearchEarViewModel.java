package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class SearchEarViewModel  extends BaseViewModel<DemoRepository> {
    public SearchEarViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }
}
