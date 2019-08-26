package com.annie.annieforchild.ui.main.home.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.constant.Constant;
import com.annie.annieforchild.entity.Banner;
import com.annie.annieforchild.entity.HomeAnimitorBean;

import com.annie.annieforchild.entity.HomeEarBean;
import com.annie.annieforchild.entity.HomeGrideBean;
import com.annie.annieforchild.entity.HomeHotCategroyBean;
import com.annie.annieforchild.entity.HomeHriBean;
import com.annie.annieforchild.entity.HomeRecommendListBean;
import com.annie.annieforchild.ui.Base.TabHostBaseFragment;
import com.annie.annieforchild.ui.main.home.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends TabHostBaseFragment {
    private RecyclerView mHomeRCView;
    private List<Object> mData;
    private HomeAdapter homeAdapter;
    //    @Override
//    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return R.layout.fragment_home;
//    }
//
//    @Override
//    public int initVariableId() {
//        return BR.viewModel;
//    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initPage() {
        mHomeRCView = (RecyclerView) mContentView.findViewById(R.id.home_Rcv);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mHomeRCView.setLayoutManager(manager);
        initHomeData();
    }

    private void initHomeData() {
        //banner
        List<Banner> bannerList = new ArrayList<>();
        bannerList.add(new Banner( Constant.TEST_IMG9, 1));
        bannerList.add(new Banner(Constant.TEST_IMG4, 2));
        bannerList.add(new Banner(Constant.TEST_IMG5, 3));
        bannerList.add(new Banner( Constant.TEST_IMG6, 4));
        bannerList.add(new Banner(Constant.TEST_IMG7, 5));
        //gride
        List<HomeGrideBean> homeGrideBeans = new ArrayList<>();
        homeGrideBeans.add(new HomeGrideBean(R.drawable.icon_timetable,"班型"));
        homeGrideBeans.add(new HomeGrideBean(R.drawable.icon_netclass,"通知"));
        homeGrideBeans.add(new HomeGrideBean(R.drawable.icon_bankbook,"互动"));
        homeGrideBeans.add(new HomeGrideBean(R.drawable.icon_square,"资讯"));

//       hriGride
        List<HomeHriBean> homeHriBeans=new ArrayList<>();
        homeHriBeans.add(new HomeHriBean(1,Constant.TEST_IMG9));
        homeHriBeans.add(new HomeHriBean(2,Constant.TEST_IMG9));
        homeHriBeans.add(new HomeHriBean(3,Constant.TEST_IMG9));

        //smallBanner
        List<Banner> smallBanner = new ArrayList<>();
        smallBanner.add(new Banner( Constant.TEST_IMG9, 1));
        smallBanner.add(new Banner(Constant.TEST_IMG4, 2));
        smallBanner.add(new Banner(Constant.TEST_IMG5, 3));

        //tuijian
        List<HomeRecommendListBean>  homeRecommendListBeans=new ArrayList<>();
        homeRecommendListBeans.add(new HomeRecommendListBean(0,Constant.TEST_IMG3));
        homeRecommendListBeans.add(new HomeRecommendListBean(1,Constant.TEST_IMG3));
        homeRecommendListBeans.add(new HomeRecommendListBean(2,Constant.TEST_IMG3));
        homeRecommendListBeans.add(new HomeRecommendListBean(2,Constant.TEST_IMG3));
        homeRecommendListBeans.add(new HomeRecommendListBean(2,Constant.TEST_IMG3));
        homeRecommendListBeans.add(new HomeRecommendListBean(2,Constant.TEST_IMG3));
        //lookAnimition
        List<HomeAnimitorBean>  homeAnimitorBeans=new ArrayList<>();
        homeAnimitorBeans.add(new HomeAnimitorBean(0,Constant.TEST_IMG3));
        homeAnimitorBeans.add(new HomeAnimitorBean(1,Constant.TEST_IMG3));
        homeAnimitorBeans.add(new HomeAnimitorBean(2,Constant.TEST_IMG3));
        homeAnimitorBeans.add(new HomeAnimitorBean(3,Constant.TEST_IMG3));
        homeAnimitorBeans.add(new HomeAnimitorBean(4,Constant.TEST_IMG3));
        homeAnimitorBeans.add(new HomeAnimitorBean(5,Constant.TEST_IMG3));
        //hotCategroy
        List<HomeHotCategroyBean>  hotCategroy=new ArrayList<>();
        hotCategroy.add(new HomeHotCategroyBean("#动物"));
        hotCategroy.add(new HomeHotCategroyBean("#数学类"));
        hotCategroy.add(new HomeHotCategroyBean("#分级读物"));
        hotCategroy.add(new HomeHotCategroyBean("#动物"));
        hotCategroy.add(new HomeHotCategroyBean("#动物"));
        hotCategroy.add(new HomeHotCategroyBean("#数学类"));
        hotCategroy.add(new HomeHotCategroyBean("#分级读物"));
        hotCategroy.add(new HomeHotCategroyBean("#动物"));
        //moEar
        List<HomeEarBean> homeEarBeans=new ArrayList<>();
        homeEarBeans.add(new HomeEarBean(0,"diyiemoerduo",Constant.TEST_IMG1));
        homeEarBeans.add(new HomeEarBean(1,"diyiemoerduo",Constant.TEST_IMG2));
        homeEarBeans.add(new HomeEarBean(2,"diyiemoerduo",Constant.TEST_IMG3));


        mData = new ArrayList<>();
        mData.add(bannerList);
        mData.add(homeGrideBeans);
        mData.add(homeHriBeans);
        mData.add(smallBanner);
        mData.add(homeRecommendListBeans);
        mData.add(homeAnimitorBeans);
//        mData.add(hotCategroy);
        mData.add(homeAnimitorBeans);
        mData.add(homeAnimitorBeans);
        mData.add(homeAnimitorBeans);

        homeAdapter = new HomeAdapter(getContext(),mData);
        mHomeRCView.setAdapter(homeAdapter);
    }
}
