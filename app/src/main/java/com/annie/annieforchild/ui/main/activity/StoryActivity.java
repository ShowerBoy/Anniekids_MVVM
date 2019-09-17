package com.annie.annieforchild.ui.main.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.annie.annieforchild.R;
import com.annie.annieforchild.constant.Constant;
import com.annie.annieforchild.databinding.ActivityStoryBinding;
import com.annie.annieforchild.entity.StroyBean;
import com.annie.annieforchild.ui.main.home.adapter.StroyAdapter;
import com.annie.annieforchild.ui.main.vm.StoryViewModel;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

public class StoryActivity extends BaseActivity<ActivityStoryBinding, StoryViewModel> {
  public ViewModelProvider viewModelProvider;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_story;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        GridLayoutManager manager =new GridLayoutManager(this,3);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.storyRcview.setLayoutManager(manager);
        List<StroyBean> mData=new ArrayList<>();
        mData.add(new StroyBean(Constant.TEST_IMG1,"Aninkids","收藏","添加书本","添加教材","123"));
        mData.add(new StroyBean(Constant.TEST_IMG1,"Aninkids","收藏","添加书本","添加教材","123"));
        mData.add(new StroyBean(Constant.TEST_IMG1,"Aninkids","收藏","添加书本","添加教材","123"));
        mData.add(new StroyBean(Constant.TEST_IMG1,"Aninkids","收藏","添加书本","添加教材","123"));
        mData.add(new StroyBean(Constant.TEST_IMG1,"Aninkids","收藏","添加书本","添加教材","123"));

        StroyAdapter adapter=new StroyAdapter(mData,this,viewModelProvider);
        binding.storyRcview.setAdapter(adapter);

    }


}
