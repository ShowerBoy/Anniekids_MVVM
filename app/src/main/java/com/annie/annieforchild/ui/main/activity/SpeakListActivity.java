package com.annie.annieforchild.ui.main.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityHomeSpeakBinding;
import com.annie.annieforchild.ui.main.vm.SpeakListViewModel;
import me.goldze.mvvmhabit.base.BaseActivity;

public class SpeakListActivity extends BaseActivity<ActivityHomeSpeakBinding, SpeakListViewModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_speak_list;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public SpeakListViewModel initViewModel() {

        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this,factory).get(SpeakListViewModel.class);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();

    }
}
