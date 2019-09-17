package com.annie.annieforchild.ui.main.home.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.FragmentAllSearchBinding;
import com.annie.annieforchild.ui.main.vm.AllSearchViewModel;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;

public class AllSearchFragment extends BaseFragment<FragmentAllSearchBinding, AllSearchViewModel> {


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_all_search;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public AllSearchViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this,factory).get(AllSearchViewModel.class);
    }
}
