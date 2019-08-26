package com.annie.annieforchild.ui.main.home.adapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.constant.Constant;
import com.annie.annieforchild.entity.Banner;
import com.annie.annieforchild.entity.HomeAnimitorBean;

import com.annie.annieforchild.entity.HomeEarBean;
import com.annie.annieforchild.entity.HomeGrideBean;
import com.annie.annieforchild.entity.HomeHotCategroyBean;
import com.annie.annieforchild.entity.HomeHriBean;
import com.annie.annieforchild.entity.HomeRecommendListBean;
import com.annie.annieforchild.view.loopPager.LoopViewPagerAdapter;
import com.annie.annieforchild.view.recycler.BaseRecycleHolder;
import com.annie.annieforchild.view.recycler.MultiItemTypeAdapter;
import com.bumptech.glide.Glide;


import java.util.List;
import me.goldze.mvvmhabit.utils.ToastUtils;


public class HomeAdapter  extends MultiItemTypeAdapter<Object>{


    public  static final  int TYPE_BANNER=0;
    public  static  final  int TYPE_GRIDE=1;
    public  static  final int TYPE_HRI_GRIDE=2;
    public static final int TYPE_SAMLL_BANNER=3;
    public  static  final  int TYPE_RECOMMEND=4;
    public  static  final  int TYPE_ANMITOR=5;
    public  static  final  int TYPE_HOT_CATEGORY=6;
    public  static  final  int TYPE_EAR=7;
    public  static  final  int TYPE_READ=8;
    public  static  final  int TYPE_SPEAKING=9;
    private LoopViewPagerAdapter mPagerAdapter;
    private String[] data11;
    private  String [] title=new String []{"0-3岁"," 3-6岁","6-8岁","8-12岁"," 12岁以上"};

    public HomeAdapter(Context context, List<Object> data) {
        super(context, data);
    }

    @Override
    protected int mulitAapterGetItemViewType(int position, Object object) {


        if (object instanceof List) {
            List list = (List) object;

            if (list.size() > 0 & list != null) {
                if (list.get(0) instanceof Banner) {
                    return TYPE_BANNER;
                } else if (list.get(0) instanceof HomeGrideBean) {
                    return TYPE_GRIDE;
                } else if (list.get(0) instanceof HomeHriBean) {
                    return TYPE_HRI_GRIDE;
                } else if (list.get(0) instanceof Banner) {
                    return TYPE_SAMLL_BANNER;
                } else if (list.get(0) instanceof HomeRecommendListBean) {
                    return TYPE_RECOMMEND;
                }else if (list.get(0) instanceof HomeAnimitorBean){
                    return  TYPE_ANMITOR;
                }else if (list.get(0)  instanceof HomeHotCategroyBean){
                    return  TYPE_HOT_CATEGORY;
                }else  if (list.get(0) instanceof HomeEarBean){
                    return  TYPE_EAR;
                }else if (list.get(0)  instanceof HomeEarBean){
                    return  TYPE_READ;
                }else if (list.get(0) instanceof HomeEarBean){
                    return  TYPE_SPEAKING;
                }


            }
        }
//        if (object instanceof List) {
//            List list = (List) object;
//            Object o = list.get(0);
//            if (o != null) {
//                if (o instanceof Banner) {
//                    return TYPE_BANNER;
//                } else if (o instanceof HomeGrideBean) {
//                    return TYPE_GRIDE;
//                }
//            }
//        }else if (object instanceof HomeHriBean){
//            HomeHriBean homeHriBean= (HomeHriBean) object;
//            if (homeHriBean.type==0){
//                return  TYPE_HRI_GRIDE;
//            }
//        } else if (object instanceof HomeRecommendListBean) {
//            HomeRecommendListBean recommendList = (HomeRecommendListBean) object;
//            if (recommendList.type == 1) {
//                return TYPE_RECOMMEND;
//            }
//        } else if (object instanceof HomeAnimitorBean) {
//            HomeAnimitorBean animation = (HomeAnimitorBean) object;
//            if (animation.type == 2) {
//                return TYPE_ANMITOR;
//            }
//        } else if (object instanceof HomeCategroyListBean) {
//            HomeCategroyListBean category = (HomeCategroyListBean) object;
//            if (category.type == 3) {
//                return TYPE_HOT_CATEGORY;
//            }
//        }
        return 0;
    }

    @Override
    public void convert(BaseRecycleHolder holder, Object item, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==TYPE_BANNER){
            bindBannerViewHolder(holder,(List<Banner>) item,position);
        }else if (itemViewType==TYPE_GRIDE){
            bindGrideViewHolder(holder,(List<HomeGrideBean>) item);
        }else if (itemViewType==TYPE_HRI_GRIDE){
             bindHriGrideViewHolder(holder,(List<HomeHriBean>) item);
        } else if (itemViewType==TYPE_SAMLL_BANNER){
            bindSmallBannerViewHolder(holder,(List<Banner>) item);
        } else if (itemViewType==TYPE_RECOMMEND){
            bindRecommendViewHolder(holder,(List<HomeRecommendListBean>) item,position);
        }else  if (itemViewType==TYPE_ANMITOR){
            bindAnimationViewHolder(holder,(List<HomeAnimitorBean>) item,position);
        }else  if (itemViewType==TYPE_HOT_CATEGORY){
            bindCategoryViewHolder(holder,(List<HomeHotCategroyBean>) item,position);
        }else   if (itemViewType==TYPE_EAR){
            bindEarViewHolder(holder,(List<HomeAnimitorBean>) item,position);
        }else if (itemViewType==TYPE_READ){
            bindReadViewHolder(holder,(List<HomeAnimitorBean>) item,position);
        }else  if (itemViewType==TYPE_SPEAKING){
            bindSpeakViewHolder(holder,(List<HomeAnimitorBean>) item,position);
        }
    }




    @Override
    protected int getLayoutId(int viewType) {
        if (viewType == TYPE_BANNER) {
            return R.layout.item_home_banner;
        } else if (viewType == TYPE_GRIDE) {
            return R.layout.item_home_gride;
        } else if (viewType==TYPE_HRI_GRIDE){
            return R.layout.item_home_hri_gride;
        }else  if (viewType==TYPE_SAMLL_BANNER){
           return R.layout.item_home_banner;
        } else if (viewType == TYPE_RECOMMEND) {
            return R.layout.item_home_recommend;
        } else if (viewType == TYPE_HOT_CATEGORY) {
            return R.layout.item_home_read;
        }else if (viewType==TYPE_ANMITOR){
            return R.layout.item_home_look_animation;
        } else if (viewType == TYPE_EAR) {
            return R.layout.item_home_read;
        }else if (viewType==TYPE_READ){
            return R.layout.item_home_speaking;
        }else if (viewType==TYPE_SPEAKING){
            return R.layout.item_home_speaking;
        }

        return 0;
    }

    /**
     * 绑定banner 布局
     * @param holder
     * @param homeBanner
     * @param position
     */
    private void bindBannerViewHolder(BaseRecycleHolder holder, List<Banner> homeBanner, int position) {
        ViewPager viewPager = holder.getView(R.id.loop_viewPager);
        final ViewGroup indicators = holder.getView(R.id.loop_indicators);
        if (viewPager.getAdapter() == null) {
            mPagerAdapter = new LoopViewPagerAdapter(viewPager, indicators);
            viewPager.setAdapter(mPagerAdapter);
            viewPager.addOnPageChangeListener(mPagerAdapter);
            mPagerAdapter.setList(homeBanner);
            mPagerAdapter.setLoopViewClickListener(new LoopViewPagerAdapter.LoopViewClickListener() {
                @Override
                public void callback(int position) {
                    ToastUtils.showShort("点击了第:" + (position + 1) + "张图片");
                }
            });
        } else {
            mPagerAdapter.setList(homeBanner);
        }
    }

    /**
     *网格绑定布局
     * @param holder
     * @param item
     */
    private void bindGrideViewHolder(BaseRecycleHolder holder, List<HomeGrideBean> item) {
        RecyclerView rcView = holder.getView(R.id.home_Gride);
        initRecycleView(rcView, 1, 0);
        HomeGrideAdapter adapter = new HomeGrideAdapter(mContext,item,Glide.with(mContext));
        rcView.setAdapter(adapter);
        adapter.setOnCustomItemClickListener(new OnCustomItemClickListener<HomeGrideBean>() {
            @Override
            public void onCustomItemClick(HomeGrideBean item, int position) {
                ToastUtils.showShort("点击了"+item.title);
            }
        });
    }

    /**
     * 绑定水平GrideView布局
     * @param holder
     * @param item
     */
    private void bindHriGrideViewHolder(BaseRecycleHolder holder, List<HomeHriBean> item) {
        RecyclerView rcview = holder.getView(R.id.home_hri_Gride);
        GridLayoutManager manager=new GridLayoutManager(mContext,1);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcview.setLayoutManager(manager);
        HomeHriBannerAdapter adapter = new HomeHriBannerAdapter(mContext,item,Glide.with(mContext));
        rcview.setAdapter(adapter);
        adapter.setOnCustomItemClickListener(new OnCustomItemClickListener<HomeHriBean>() {
            @Override
            public void onCustomItemClick(HomeHriBean item, int position) {
                ToastUtils.showShort("你点击了我");
            }
        });
    }

    /**
     * 绑定banner
     * @param holder
     * @param item
     */
    private void bindSmallBannerViewHolder(BaseRecycleHolder holder, List<Banner> item) {
        ViewPager viewPager = holder.getView(R.id.loop_viewPager);
        final ViewGroup indicators = holder.getView(R.id.loop_indicators);
        if (viewPager.getAdapter() == null) {
            mPagerAdapter = new LoopViewPagerAdapter(viewPager, indicators);
            viewPager.setAdapter(mPagerAdapter);
            viewPager.addOnPageChangeListener(mPagerAdapter);
            mPagerAdapter.setList(item);
            mPagerAdapter.setLoopViewClickListener(new LoopViewPagerAdapter.LoopViewClickListener() {
                @Override
                public void callback(int position) {
                    ToastUtils.showShort("点击了第:" + (position + 1) + "张图片");
                }
            });
        } else {
            mPagerAdapter.setList(item);
        }
    }


    /**
     * 推荐绑定布局
     * @param holder
     * @param item
     * @param position
     */
      private TabLayout mTab=null;
    private void bindRecommendViewHolder(BaseRecycleHolder holder, List<HomeRecommendListBean> item, int position) {
        mTab = holder.getView(R.id.tab_layout);
        initTab();
        RecyclerView rcView = holder.getView(R.id.home_recommend_rcv);

        final GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcView.setLayoutManager(manager);
        rcView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                mTab.setScrollPosition(manager.findFirstVisibleItemPosition(),0,true);
            }
        });
        //切换tab
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                manager.scrollToPositionWithOffset(tab.getPosition(),0);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        HomeRecommendAdapter adapter = new HomeRecommendAdapter(mContext,item, Glide.with(mContext));
        rcView.setAdapter(adapter);
        adapter.setOnCustomItemClickListener(new OnCustomItemClickListener<HomeRecommendListBean>() {
            @Override
            public void onCustomItemClick(HomeRecommendListBean item, int position) {
               ToastUtils.showShort("你点击了我");
            }
        });

    }

    /**
     * 初始化tab
     */
    private void initTab() {
        mTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTab.addTab(mTab.newTab().setText(title[0]).setTag(Constant.TYPE_ZERO));
        mTab.addTab(mTab.newTab().setText(title[1]).setTag(Constant.TYPE_ONE));
        mTab.addTab(mTab.newTab().setText(title[2]).setTag(Constant.TYPE_TWO));
        mTab.addTab(mTab.newTab().setText(title[3]).setTag(Constant.TYPE_THREE));
        mTab.addTab(mTab.newTab().setText(title[4]).setTag(Constant.TYPE_FOUR));

    }

    /**
     * 绑定看动画布局
     * @param holder
     * @param item
     * @param position
     */
    private void bindAnimationViewHolder(BaseRecycleHolder holder, List<HomeAnimitorBean> item, int position) {
        RecyclerView rcView = holder.getView(R.id.home_animation_rcv);
         GridLayoutManager  manager=new GridLayoutManager(mContext,2);
         rcView.setLayoutManager(manager);
         HomeLookAnimationAdapter  adapter=new HomeLookAnimationAdapter(mContext,item,Glide.with(mContext));
         rcView.setAdapter(adapter);
        adapter.setOnCustomItemClickListener(new OnCustomItemClickListener<HomeAnimitorBean>() {
            @Override
            public void onCustomItemClick(HomeAnimitorBean item, int position) {
                ToastUtils.showShort("你点击了我");
            }
        });

    }

    /**
     * 绑定热门类别布局
     * @param holder
     * @param item
     * @param position
     */

    private void bindCategoryViewHolder(BaseRecycleHolder holder, List<HomeHotCategroyBean> item, int position) {
//    FlexboxLayout mFlowLayout = holder.getView(R.id.home_flowlayout);
//        data11 = new String[]{"Java", "Android", "Ios", "前端", "C++", "软件工程师","高级工程师","数据库开发","项目经理","美工","PHP","数据分析","网络工程师","网站编辑","Go"};
//
//        for (int i = 0; i < data11.length; i++) {
//            TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.item_home_flow_item, mFlowLayout, false);
//            tv.setText(data11[i]);
//            mFlowLayout.addView(tv);
//            final int finalI = i;
//            tv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    ToastUtils.showShort("你点击了" + data11[finalI]);
//                }
//            });
//        }
        RecyclerView rcview = holder.getView(R.id.flexbox_rcview);
        LinearLayoutManager manager=new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rcview.setLayoutManager(manager);
        HomeHotCategroyAdapter  adapter=new HomeHotCategroyAdapter(mContext,item,Glide.with(mContext));
        rcview.setAdapter(adapter);
        adapter.setOnCustomItemClickListener(new OnCustomItemClickListener<HomeHotCategroyBean>() {
            @Override
            public void onCustomItemClick(HomeHotCategroyBean item, int position) {
                ToastUtils.showShort("你点击了我");
            }
        });


    }


    /**
     * 绑定磨耳朵
     * @param holder
     * @param item
     * @param position
     */
    private void bindEarViewHolder(BaseRecycleHolder holder, List<HomeAnimitorBean> item, int position) {
//        RecyclerView rcView = holder.getView(R.id.ear_rcView);
//        GridLayoutManager  manager=new GridLayoutManager(mContext,1);
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        rcView.setLayoutManager(manager);
//        HomeEarAdapter  adapter=new HomeEarAdapter(mContext,item,Glide.with(mContext));
//        rcView.setAdapter(adapter);
//        adapter.setOnCustomItemClickListener(new OnCustomItemClickListener<HomeEarBean>() {
//            @Override
//            public void onCustomItemClick(HomeEarBean item, int position) {
//                ToastUtils.showShort("你点击了我");
//            }
//        });

        RecyclerView rcView = holder.getView(R.id.home_animation_rcv);
        GridLayoutManager  manager=new GridLayoutManager(mContext,2);
        rcView.setLayoutManager(manager);
        HomeLookAnimationAdapter  adapter=new HomeLookAnimationAdapter(mContext,item,Glide.with(mContext));
        rcView.setAdapter(adapter);
        adapter.setOnCustomItemClickListener(new OnCustomItemClickListener<HomeAnimitorBean>() {
            @Override
            public void onCustomItemClick(HomeAnimitorBean item, int position) {
                ToastUtils.showShort("你点击了我");
            }
        });

    }

    /**
     * 绑定流利读的布局
     * @param holder
     * @param item
     * @param position
     */
    private void bindReadViewHolder(BaseRecycleHolder holder, List<HomeAnimitorBean> item, int position) {
//        RecyclerView rcView = holder.getView(R.id.read_rcView);
//        GridLayoutManager  manager=new GridLayoutManager(mContext,1);
//        rcView.setLayoutManager(manager);
//        HomeEarAdapter  adapter=new HomeEarAdapter(mContext,item,Glide.with(mContext));
//        rcView.setAdapter(adapter);
//        adapter.setOnCustomItemClickListener(new OnCustomItemClickListener<HomeEarBean>() {
//            @Override
//            public void onCustomItemClick(HomeEarBean item, int position) {
//                ToastUtils.showShort("你点击了我");
//            }
//        });

        RecyclerView rcView = holder.getView(R.id.home_animation_rcv);
        GridLayoutManager  manager=new GridLayoutManager(mContext,2);
        rcView.setLayoutManager(manager);
        HomeLookAnimationAdapter  adapter=new HomeLookAnimationAdapter(mContext,item,Glide.with(mContext));
        rcView.setAdapter(adapter);
        adapter.setOnCustomItemClickListener(new OnCustomItemClickListener<HomeAnimitorBean>() {
            @Override
            public void onCustomItemClick(HomeAnimitorBean item, int position) {
                ToastUtils.showShort("你点击了我");
            }
        });

    }

    /**
     * 绑定地道说布局
     * @param holder
     * @param item
     * @param position
     */
    private void bindSpeakViewHolder(BaseRecycleHolder holder, List<HomeAnimitorBean> item, int position) {
//        RecyclerView rcView = holder.getView(R.id.ear_rcView);
//        GridLayoutManager  manager=new GridLayoutManager(mContext,1);
//        rcView.setLayoutManager(manager);
//        HomeEarAdapter  adapter=new HomeEarAdapter(mContext,item,Glide.with(mContext));
//        rcView.setAdapter(adapter);
//        adapter.setOnCustomItemClickListener(new OnCustomItemClickListener<HomeEarBean>() {
//            @Override
//            public void onCustomItemClick(HomeEarBean item, int position) {
//                ToastUtils.showShort("你点击了我");
//            }
//        });

        RecyclerView rcView = holder.getView(R.id.home_animation_rcv);
        GridLayoutManager  manager=new GridLayoutManager(mContext,2);
        rcView.setLayoutManager(manager);
        HomeLookAnimationAdapter  adapter=new HomeLookAnimationAdapter(mContext,item,Glide.with(mContext));
        rcView.setAdapter(adapter);
        adapter.setOnCustomItemClickListener(new OnCustomItemClickListener<HomeAnimitorBean>() {
            @Override
            public void onCustomItemClick(HomeAnimitorBean item, int position) {
                ToastUtils.showShort("你点击了我");
            }
        });

    }



    /**
     * @param rcView
     * @param managerType 0 LineagManager 1GirdeManager
     * @param orientation
     */
    private void initRecycleView(RecyclerView rcView, int managerType, int orientation) {
        RecyclerView.LayoutManager manager = null;
        if (managerType == 1) {
            manager = new GridLayoutManager(mContext, 4);
        } else {
            manager = new LinearLayoutManager(mContext, orientation, false);
        }
        rcView.setLayoutManager(manager);
    }
}




