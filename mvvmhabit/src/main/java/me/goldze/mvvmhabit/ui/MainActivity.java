package me.goldze.mvvmhabit.ui;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.goldze.mvvmhabit.R;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.ui.home.HomeFragment;
import me.goldze.mvvmhabit.ui.route.RouteFragment;

public class MainActivity extends AppCompatActivity {

        private FragmentTabHost mTabHost;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            initTab();
    }

//    @Override
//    public int initContentView(Bundle savedInstanceState) {
//        initTab();
//        return R.layout.activity_main;
//
//    }
//
//        @Override
//    public int initVariableId() {
//        return 0;
//    }


   //初始化tab
    private void initTab() {
        mTabHost = findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
    //首页
        View homeIndicator = getIndicatorView(R.string.tabhost_home, R.drawable.selector_home);
         mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.tabhost_home))
                .setIndicator(homeIndicator), HomeFragment.class, null);

    //线路
        View routeIndicator = getIndicatorView(R.string.tabhost_route, R.drawable.selector_home);
          mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.tabhost_route))
                  .setIndicator(routeIndicator), RouteFragment.class,null);

     //打卡
        View clockinIndicator = getIndicatorView(R.string.tabhost_clockin, R.drawable.selector_home);
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.tabhost_clockin))
                .setIndicator(routeIndicator), RouteFragment.class,null);

     //收藏
        View collectIndicator = getIndicatorView(R.string.tabhost_collect, R.drawable.selector_home);
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.tabhost_collect))
                .setIndicator(routeIndicator), RouteFragment.class,null);

    //我的
        View mineIndicator = getIndicatorView(R.string.tabhost_mine, R.drawable.selector_home);
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.tabhost_mine))
                .setIndicator(routeIndicator), RouteFragment.class,null);
    }

    private View getIndicatorView(int resId, int drawableId) {
        View v = getLayoutInflater().inflate(R.layout.indicator_view, null);
        ImageView imageView = (ImageView) v.findViewById(R.id.main_indicator_img);
        imageView.setImageResource(drawableId);
        TextView textView = (TextView) v.findViewById(R.id.main_indicator_name);
        textView.setText(getResources().getString(resId));
        return v;

     }


    }
