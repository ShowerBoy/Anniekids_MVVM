package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseViewModel;

public class SortSearchViewModel  extends BaseViewModel<DemoRepository> {
    public ObservableField<String> key =new ObservableField<>();


    public SortSearchViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);

    }


}
