package com.annie.annieforchild.ui.main.home.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.FragmentSpeakSearchBinding;
import com.annie.annieforchild.ui.main.vm.SearchReadViewModel;
import com.annie.annieforchild.ui.main.vm.SearchSpeakViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;

public class SearchSpeakFragment  extends BaseFragment<FragmentSpeakSearchBinding, SearchSpeakViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_speak_search;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public SearchSpeakViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this,factory).get(SearchSpeakViewModel.class);
    }

}
