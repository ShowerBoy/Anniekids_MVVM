package com.annie.annieforchild.ui.main.home.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.FragmentFirstBinding;
//import com.annie.annieforchild.ui.main.fragment.RecommendFragment;
import com.annie.annieforchild.ui.main.vm.HomepageViewModel;

import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.ConvertUtils;

public class FirstFragment extends BaseFragment<FragmentFirstBinding, HomepageViewModel> {
    private List<String> commendList;
    private List<Fragment> fragments;
    private MyViewPagerFragmentAdapter fragmentAdapter;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_first;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public HomepageViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(HomepageViewModel.class);
    }

    @Override
    public void initData() {
        commendList = new ArrayList<>();
        fragments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            commendList.add("分类" + i);
//            fragments.add(new RecommendFragment());
        }
        fragmentAdapter = new MyViewPagerFragmentAdapter(getFragmentManager());
        binding.viewpager.setAdapter(fragmentAdapter);
        binding.viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return commendList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(getContext());
                colorTransitionPagerTitleView.setNormalColor(getResources().getColor(R.color.text_color));
                colorTransitionPagerTitleView.setSelectedColor(getResources().getColor(R.color.text_orange));
                colorTransitionPagerTitleView.setText(commendList.get(index));
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.viewpager.setCurrentItem(index);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(getContext());
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineWidth(ConvertUtils.dp2px(20));
                indicator.setColors(new Integer[]{getResources().getColor(R.color.text_orange)});
                return indicator;
            }
        });
        binding.magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(binding.magicIndicator, binding.viewpager);
    }

    @Override
    public void initViewObservable() {

    }

    public class MyViewPagerFragmentAdapter extends FragmentStatePagerAdapter {

        public MyViewPagerFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return commendList.get(position);
        }
    }
}
