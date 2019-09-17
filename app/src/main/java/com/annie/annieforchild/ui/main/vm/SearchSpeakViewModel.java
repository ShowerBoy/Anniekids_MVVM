package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class SearchSpeakViewModel  extends BaseViewModel<DemoRepository> {
    public SearchSpeakViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }
}
