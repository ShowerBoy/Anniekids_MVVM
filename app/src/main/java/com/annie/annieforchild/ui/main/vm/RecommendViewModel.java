package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class RecommendViewModel extends BaseViewModel<DemoRepository> {

    public RecommendViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }


}
