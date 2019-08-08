package com.annie.annieforchild.ui.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;

import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityMainBinding;
import com.annie.annieforchild.ui.main.fragment.FifthFragment;
import com.annie.annieforchild.ui.main.fragment.FirstFragment;
import com.annie.annieforchild.ui.main.fragment.FourthFragment;
import com.annie.annieforchild.ui.main.fragment.SecondFragment;
import com.annie.annieforchild.ui.main.fragment.ThirdFragment;
import com.annie.annieforchild.ui.main.vm.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

/**
 * com.taobao.taobao
 */
public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> {
    private List<Fragment> fragments;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        initFragment();
        initBottomTab();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());
        fragments.add(new FourthFragment());
        fragments.add(new FifthFragment());
        //默认选中第一个
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, fragments.get(0));
        transaction.commitAllowingStateLoss();
    }

    private void initBottomTab() {
        NavigationController navigationController = binding.pagerBottomTab.material()
                .addItem(R.drawable.icon_main_f, R.drawable.icon_main_t, "首页", ContextCompat.getColor(this, R.color.text_orange))
                .addItem(R.drawable.icon_lesson_f, R.drawable.icon_lesson_t, "课程", ContextCompat.getColor(this, R.color.text_orange))
                .addItem(R.drawable.icon_daka_f, R.drawable.icon_daka_t, "打卡", ContextCompat.getColor(this, R.color.text_orange))
                .addItem(R.drawable.icon_discover_f, R.drawable.icon_discover_t, "发现", ContextCompat.getColor(this, R.color.text_orange))
                .addItem(R.drawable.icon_my_f, R.drawable.icon_my_t, "我的", ContextCompat.getColor(this, R.color.text_orange))
                .setDefaultColor(ContextCompat.getColor(this, R.color.navigation_bar_color))
                .dontTintIcon()
                .build();
        //底部按钮的点击事件监听
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, fragments.get(index));
                transaction.commitAllowingStateLoss();
            }

            @Override
            public void onRepeat(int index) {
            }
        });
    }
}
