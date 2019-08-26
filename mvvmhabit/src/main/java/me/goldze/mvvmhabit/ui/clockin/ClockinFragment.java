package me.goldze.mvvmhabit.ui.clockin;

import android.os.Bundle;

import me.goldze.mvvmhabit.R;
import me.goldze.mvvmhabit.base.BaseActivity;

public class ClockinFragment  extends BaseActivity {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.frangment_clockin;
    }

    @Override
    public int initVariableId() {
        return 0;
    }
}
