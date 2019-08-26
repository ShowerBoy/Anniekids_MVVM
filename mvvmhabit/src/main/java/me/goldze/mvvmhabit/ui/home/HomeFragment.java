package me.goldze.mvvmhabit.ui.home;

import android.os.Bundle;

import me.goldze.mvvmhabit.R;
import me.goldze.mvvmhabit.base.BaseActivity;

public class HomeFragment  extends BaseActivity {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.frangment_home;
    }

    @Override
    public int initVariableId() {
        return 0;
    }
}
