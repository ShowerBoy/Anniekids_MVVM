package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.ui.Base.App;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Created by shen
 * on 2019/8/31
 */


public class PictureBookViewModel  extends BaseViewModel<DemoRepository> {
    public ObservableField<String> image=new ObservableField<>();
    public   ObservableField<String> title=new ObservableField<>();
    public ObservableField<String> bookNumber=new ObservableField<>();


    public PictureBookViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);

    }




//    public BindingCommand  picture=new BindingCommand(new BindingAction() {
//        @Override
//        public void call() {
//             if (!TextUtils.isEmpty(image.get())){
//                 ToastUtils.showShort("数据不能为空");
//             }
//        }
//
//    });


}
