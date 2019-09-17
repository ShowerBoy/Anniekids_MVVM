package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Created by shen
 * on 2019/8/31
 */


public class BridgeBookVieModel extends BaseViewModel<DemoRepository> {

    public ObservableField<String> image=new ObservableField<>();
    public   ObservableField<String> title=new ObservableField<>();
    public ObservableField<String> bookNumber=new ObservableField<>();

    public BridgeBookVieModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }


}
