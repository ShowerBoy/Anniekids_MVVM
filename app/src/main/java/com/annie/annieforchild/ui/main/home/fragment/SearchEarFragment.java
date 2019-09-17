package com.annie.annieforchild.ui.main.home.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.FragmentSearchEarBinding;
import com.annie.annieforchild.ui.main.vm.SearchEarViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;

public class SearchEarFragment  extends BaseFragment<FragmentSearchEarBinding, SearchEarViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_search_ear;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public SearchEarViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this,factory).get(SearchEarViewModel.class);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
    }


}
