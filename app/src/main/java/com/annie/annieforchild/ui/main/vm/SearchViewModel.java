package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class SearchViewModel   extends BaseViewModel<DemoRepository> {

    public SearchViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }
}
