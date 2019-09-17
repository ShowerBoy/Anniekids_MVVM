package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Created by shen
 * on 2019/8/28
 */


public class AnimationListViewModel  extends BaseViewModel<DemoRepository> {
    public AnimationListViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }
}
