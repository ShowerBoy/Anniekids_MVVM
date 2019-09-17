package com.annie.annieforchild.ui.main.home.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.annie.annieforchild.ui.main.home.fragment.AllSearchFragment;
import com.annie.annieforchild.ui.main.home.fragment.SearchEarFragment;
import com.annie.annieforchild.ui.main.home.fragment.SearchReadFragment;
import com.annie.annieforchild.ui.main.home.fragment.SearchSpeakFragment;

public class HomeSearchPagerAdapter  extends FragmentPagerAdapter {
    public  String [] titles={"全部","磨耳朵","流利读","地道说"};
    private Fragment fragment=null;

    public HomeSearchPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if (titles[position].equals("全部")){
            fragment = new AllSearchFragment();
        }else if (titles[position].equals("磨耳朵")){
            fragment=new SearchEarFragment();
        }else if (titles[position].equals("流利读")){
            fragment=new SearchReadFragment();
        }else if (titles[position].equals("地道说")){
            fragment=new SearchSpeakFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
