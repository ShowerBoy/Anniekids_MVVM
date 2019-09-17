package com.annie.annieforchild.ui.main.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityReadListBinding;
import com.annie.annieforchild.ui.adapter.base.BaseFragmentPagerAdapter;
import com.annie.annieforchild.ui.main.home.adapter.ReadListPagerAdapter;
import com.annie.annieforchild.ui.main.home.fragment.BridgeBookFragment;
import com.annie.annieforchild.ui.main.home.fragment.ChapterBookFragment;
import com.annie.annieforchild.ui.main.home.fragment.GradedReadersFragment;
import com.annie.annieforchild.ui.main.home.fragment.PictureBookFragment;
import com.annie.annieforchild.ui.main.vm.ReadListViewModel;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import retrofit2.http.GET;

public class ReadListActivity extends BaseActivity<ActivityReadListBinding, ReadListViewModel> {
  private  List<Fragment> fragments;
    private List<String> titles;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_read_list;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public ReadListViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this,factory).get(ReadListViewModel.class);
    }


    @Override
    public void initData() {
        super.initData();
        binding.onBack.setVisibility(View.VISIBLE);
        initViewPager();
    }

    private void initViewPager() {

        ReadListPagerAdapter  pagerAdapter=new ReadListPagerAdapter(getSupportFragmentManager());
        binding.viewpager.setAdapter(pagerAdapter);
        binding.tablayout.setupWithViewPager(binding.viewpager);

    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
//        binding.onBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }
}
