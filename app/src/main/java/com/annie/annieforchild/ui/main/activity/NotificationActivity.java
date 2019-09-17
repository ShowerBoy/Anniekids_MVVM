package com.annie.annieforchild.ui.main.activity;

import android.app.Application;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityNotificationBinding;
import com.annie.annieforchild.ui.main.vm.NotificationViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.ViewModelFactory;

public class NotificationActivity extends BaseActivity<ActivityNotificationBinding, NotificationViewModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_notification;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public NotificationViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this,factory).get(NotificationViewModel.class);
    }
}
