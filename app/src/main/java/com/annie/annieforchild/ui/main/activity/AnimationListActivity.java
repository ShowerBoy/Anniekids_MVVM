package com.annie.annieforchild.ui.main.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityAnimationBinding;
import com.annie.annieforchild.ui.main.vm.AnimationListViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class AnimationListActivity extends BaseActivity<ActivityAnimationBinding, AnimationListViewModel> {



    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_animation;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public AnimationListViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this,factory).get(AnimationListViewModel.class);
    }
}
