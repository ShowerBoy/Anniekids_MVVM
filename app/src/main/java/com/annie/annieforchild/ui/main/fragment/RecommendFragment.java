package com.annie.annieforchild.ui.main.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.FragmentRecommendBinding;
import com.annie.annieforchild.ui.main.vm.RecommendViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.base.ViewModelFactory;

public class RecommendFragment extends BaseFragment<FragmentRecommendBinding, RecommendViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_recommend;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public RecommendViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(RecommendViewModel.class);
    }
}
