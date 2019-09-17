package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.support.annotation.NonNull;
import android.view.View;

import com.annie.annieforchild.R;
import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.ui.main.activity.EarListActivity;
import com.annie.annieforchild.ui.main.activity.ReadListActivity;
import com.annie.annieforchild.ui.main.activity.SpeakListActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class HomeGridViewModel extends BaseViewModel<DemoRepository> {

    public HomeGridViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

//    public void onClick(View view){
//        switch (view.getId()){
//            case R.id.iv_home_ear:
//                startActivity(EarListActivity.class);
//                break;
//            case R.id.iv_home_read:
//                startActivity(ReadListActivity.class);
//                break;
//            case R.id.iv_home_speak:
//                startActivity(SpeakListActivity.class);
//                break;
//        }
//    }

//    public BindingCommand  onEarClick  =new BindingCommand(new BindingAction() {
//        @Override
//        public void call() {
//            startActivity(EarListActivity.class);
//        }
//    });

    public void upda(){

    }
}
