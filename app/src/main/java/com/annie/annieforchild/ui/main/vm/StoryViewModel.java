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


public class StoryViewModel extends BaseViewModel<DemoRepository> {

public ObservableField<String> title=new ObservableField<>();
public  ObservableField<String> addBook=new ObservableField<>();
public  ObservableField<String> collect=new ObservableField<>();
public  ObservableField<String> addTable=new ObservableField<>();
public ObservableField<String> number=new ObservableField<>();

    public StoryViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }


}
