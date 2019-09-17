package com.annie.annieforchild.ui.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;

import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityMainBinding;
import com.annie.annieforchild.ui.person.fragment.PersonFragment;
import com.annie.annieforchild.ui.discover.fragment.DiscoverFragment;
import com.annie.annieforchild.ui.routemap.fragment.RouteMapFragment;
import com.annie.annieforchild.ui.clockin.fragment.ClockInFragment;
import com.annie.annieforchild.ui.main.home.fragment.HomeFragment;

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
        fragments.add(new HomeFragment());
        fragments.add(new RouteMapFragment());
        fragments.add(new ClockInFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new PersonFragment());
        //默认选中第一个
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, fragments.get(0));
        transaction.commitAllowingStateLoss();
    }

    private void initBottomTab() {
        NavigationController navigationController = binding.pagerBottomTab.material()
                .addItem(R.drawable.home_navig_home, R.drawable.home_navig_home_s, "首页", ContextCompat.getColor(this, R.color.text_orange))
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
