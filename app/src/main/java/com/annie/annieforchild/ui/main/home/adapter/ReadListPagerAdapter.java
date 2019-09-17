package com.annie.annieforchild.ui.main.home.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.annie.annieforchild.ui.main.home.fragment.BridgeBookFragment;
import com.annie.annieforchild.ui.main.home.fragment.ChapterBookFragment;
import com.annie.annieforchild.ui.main.home.fragment.GradedReadersFragment;
import com.annie.annieforchild.ui.main.home.fragment.PictureBookFragment;

public class ReadListPagerAdapter  extends FragmentPagerAdapter {
  public  String [] title=new String[]{"绘本","分级读物","桥梁书","章节书"};
    private Fragment fragment=null;

    public ReadListPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (title[position].equals("绘本")){
            fragment = new PictureBookFragment();
        }else  if (title[position].equals("分级读物")){
            fragment=new GradedReadersFragment();
        }else if (title[position].equals("桥梁书")){
            fragment=new BridgeBookFragment();
        }else if (title[position].equals("章节书")){
            fragment=new ChapterBookFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
