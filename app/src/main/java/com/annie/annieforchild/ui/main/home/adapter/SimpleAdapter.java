package com.annie.annieforchild.ui.main.home.adapter;

import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ClipData;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.annie.annieforchild.AppViewModelFactory;
import com.annie.annieforchild.MyApplication;
import com.annie.annieforchild.R;
import com.annie.annieforchild.constant.Constant;
import com.annie.annieforchild.databinding.ActivityAnimationBinding;
import com.annie.annieforchild.databinding.ActivityBankBookBinding;
import com.annie.annieforchild.databinding.ActivityClassTypeBinding;
import com.annie.annieforchild.databinding.ActivityHomeEarBinding;
import com.annie.annieforchild.databinding.ActivityHomeReadBinding;
import com.annie.annieforchild.databinding.ActivityHomeSpeakBinding;
import com.annie.annieforchild.databinding.ActivityNotificationBinding;
import com.annie.annieforchild.databinding.AdapterHomeGridBinding;
import com.annie.annieforchild.databinding.AdapterHomeLooperBinding;
import com.annie.annieforchild.databinding.ItemHomeCategroyBinding;
import com.annie.annieforchild.databinding.ItemHomeEarBinding;
import com.annie.annieforchild.databinding.ItemHomeLookAnimationBinding;
import com.annie.annieforchild.databinding.ItemHomeReadBinding;
import com.annie.annieforchild.databinding.ItemHomeRecommendBinding;
import com.annie.annieforchild.databinding.ItemHomeSpeakingBinding;
import com.annie.annieforchild.entity.HomeAnimitorBean;
import com.annie.annieforchild.entity.HomeBean;
import com.annie.annieforchild.entity.HomeEarBean;
import com.annie.annieforchild.ui.adapter.HomeAnimAdapter;
import com.annie.annieforchild.ui.main.activity.ClassTypeActivity;
import com.annie.annieforchild.ui.main.activity.EarListActivity;
import com.annie.annieforchild.ui.main.activity.ReadListActivity;
import com.annie.annieforchild.ui.main.activity.SpeakListActivity;
import com.annie.annieforchild.ui.main.vm.AnimationListViewModel;

import com.annie.annieforchild.ui.main.vm.HomeEarViewModel;
import com.annie.annieforchild.ui.main.vm.HomeGridViewModel;
import com.annie.annieforchild.ui.main.vm.HomeLoopViewModel;
import com.annie.annieforchild.ui.main.vm.HomeReadViewModel;
import com.annie.annieforchild.ui.main.vm.HomeSpeakViewModel;
import com.annie.annieforchild.ui.main.vm.LabelListViewModel;
import com.annie.annieforchild.view.loopPager.LoopViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * Created by shen
 * on 2019/8/30
 */


public  class SimpleAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  public Context context;
  public  List<Object> mData;
  public Fragment fragment;
  public  ViewModelProvider viewModelProvider;
  private ItemHomeEarBinding mEarBingding;
  private HomeRecommendViewHolder recommendViewHolderr;
    AppViewModelFactory factory = AppViewModelFactory.getInstance(MyApplication.getInstance());
    private LoopViewPagerAdapter mPagerAdapter;
    private HomeCommonItemAdapter adapter;

    public SimpleAdapter(Context context, List<Object> mData, Fragment fragment, ViewModelProvider viewModelProvider) {
        this.context = context;
        this.mData = mData;
        this.fragment = fragment;
        this.viewModelProvider = viewModelProvider;
    }

    public void setmData(List<Object> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    /**
     * 绑定不同类型的布局
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==R.layout.adapter_home_looper){
            AdapterHomeLooperBinding looperBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, null, false);
            HomeLooperViewHolder recommendViewHolder=new HomeLooperViewHolder(looperBinding);
            recommendViewHolder.binding=looperBinding;
            return recommendViewHolder;
        }else if (viewType==R.layout.adapter_home_grid){
            AdapterHomeGridBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
            AdapterHomeGridBinding homeGridBinding = binding;
            HomeGridBannerViewHolder gridBannerViewHolder=new HomeGridBannerViewHolder(homeGridBinding);
            gridBannerViewHolder.binding=homeGridBinding;
            return gridBannerViewHolder;
        } else if (viewType==R.layout.item_home_recommend){
            ItemHomeRecommendBinding speakBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
            HomeRecommendViewHolder recommendViewHolder=new HomeRecommendViewHolder(speakBinding);
            recommendViewHolder.binding=speakBinding;
            return recommendViewHolder;
        }else if (viewType==R.layout.item_home_look_animation){
            ItemHomeLookAnimationBinding lookAnimationBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
             HomeLookAnimationViewHolder  lookAnimationViewHolder = new HomeLookAnimationViewHolder(lookAnimationBinding);
             lookAnimationViewHolder.binding=lookAnimationBinding;
             return lookAnimationViewHolder;
        }else if (viewType==R.layout.item_home_categroy){
            ItemHomeCategroyBinding categroyBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
            HomeCatefroyViewHolder  homeCatefroyViewHolder = new HomeCatefroyViewHolder(categroyBinding);
            homeCatefroyViewHolder.binding=categroyBinding;
            return homeCatefroyViewHolder;
        } else if (viewType==R.layout.item_home_ear){
            mEarBingding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
            HomeEarViewHolder  viewHolder=new HomeEarViewHolder(mEarBingding);
            viewHolder.bingding=mEarBingding;
            return viewHolder;
        }else if (viewType==R.layout.item_home_read){
            ItemHomeReadBinding mReadBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
            HomeReadViewHolder  readViewHolder=new HomeReadViewHolder(mReadBinding);
            readViewHolder.bingding=mReadBinding;
            return readViewHolder;
        }else if (viewType==R.layout.item_home_speaking){
            ItemHomeSpeakingBinding speakBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
            HomeSpeakViewHolder speakViewHolder=new HomeSpeakViewHolder(speakBinding);
            speakViewHolder.bingding=speakBinding;
            return speakViewHolder;
        }

        //空不局
        View view = LayoutInflater.from(context).inflate(R.layout.layout_no_data, parent, false);
        return new EmptyViewHolder(view);
    }

    /**
     * 不同类型的数据绑定
     * @param viewHolder
     * @param position
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof HomeLooperViewHolder){
            HomeLooperViewHolder looperViewHolder = (HomeLooperViewHolder) viewHolder;
            List<HomeBean.DataBean.BannerBean> banners = (List<HomeBean.DataBean.BannerBean>) mData.get(0);

            if (looperViewHolder.binding.loopViewPager.getAdapter() == null) {
                mPagerAdapter = new LoopViewPagerAdapter(looperViewHolder.binding.loopViewPager, looperViewHolder.binding.loopIndicators);
                looperViewHolder.binding.loopViewPager.setAdapter(mPagerAdapter);
                looperViewHolder.binding.loopViewPager.addOnPageChangeListener(mPagerAdapter);
                mPagerAdapter.setList(banners);
                mPagerAdapter.setLoopViewClickListener(new LoopViewPagerAdapter.LoopViewClickListener() {
                    @Override
                    public void callback(int positionLooper) {
                        //TODO 设置点击
                    }
                });
            } else {
                mPagerAdapter.setList(banners);
            }

        }else if (viewHolder  instanceof HomeGridBannerViewHolder){

            AdapterHomeGridBinding bind = ((HomeGridBannerViewHolder)viewHolder).binding;
            HomeGridViewModel gridViewModel = bind.getViewModel();
            gridViewModel.upda();
            bind.ivHomeEar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(EarListActivity.class);
                }
            });

            bind.ivHomeRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(ReadListActivity.class);
                }
            });
            bind.ivHomeSpeak.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(SpeakListActivity.class);
                }
            });


        } else if (viewHolder instanceof  HomeRecommendViewHolder){  //推荐
            recommendViewHolderr = (HomeRecommendViewHolder) viewHolder;
            HomeBean.DataBean.RecommendBean recommendBean = (HomeBean.DataBean.RecommendBean) mData.get(2);
            String title = recommendBean.getTitle();
            if (!TextUtils.isEmpty(title)){
                recommendViewHolderr.binding.sectionTitle.setText(title);
            }
            final GridLayoutManager  manager =new GridLayoutManager(context,3);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recommendViewHolderr.binding.homeRecommendRcv.setLayoutManager(manager);
            final List<HomeBean.DataBean.RecommendBean.DataListBean> dataList = recommendBean.getDataList();
            initTable(dataList);

            if (null != dataList && dataList.size() > 0){
                HomeBean.DataBean.RecommendBean.DataListBean dataListBean = dataList.get(0);
                List<HomeBean.DataBean.RecommendBean.DataListBean.ResourceListBean> resourceList = dataListBean.getResourceList();
                adapter=new HomeCommonItemAdapter(context,resourceList,viewModelProvider);
                recommendViewHolderr.binding.homeRecommendRcv.setAdapter(adapter);
            }
            recommendViewHolderr.binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    int position1 = tab.getPosition();
                    if (dataList.size() > position1){
                        HomeBean.DataBean.RecommendBean.DataListBean dataListBean = dataList.get(position1);
                        List<HomeBean.DataBean.RecommendBean.DataListBean.ResourceListBean> resourceList = dataListBean.getResourceList();
                        adapter.setmData(resourceList);
                    }
                    manager.scrollToPositionWithOffset(position1,0);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

        }else  if (viewHolder instanceof HomeLookAnimationViewHolder){//看动画
            HomeLookAnimationViewHolder  animationViewHolder= (HomeLookAnimationViewHolder) viewHolder;
            final List<HomeBean.DataBean.AnimationBean> animationBean = (List<HomeBean.DataBean.AnimationBean>) mData.get(3);
            ItemHomeLookAnimationBinding binding = animationViewHolder.binding;
            GridLayoutManager manager=new GridLayoutManager(context,3);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            binding.homeAnimationRcv.setLayoutManager(manager);
            binding.swipeTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.notifyDataSetChanged();
                }
            });
            final HomeLookAnimationAdapter adapter = new HomeLookAnimationAdapter( animationBean ,context , viewModelProvider);
            animationViewHolder.binding.homeAnimationRcv.setAdapter(adapter);



        }else  if (viewHolder instanceof HomeCatefroyViewHolder){//热门属性
            HomeCatefroyViewHolder  catefroyViewHolder= (HomeCatefroyViewHolder) viewHolder;
            ItemHomeCategroyBinding binding = catefroyViewHolder.binding;
            LabelListViewModel viewModel = binding.getViewModel();
            List<HomeBean.DataBean.LabelBean> labelBeans = (List<HomeBean.DataBean.LabelBean>) mData.get(4);
            binding.flowRoot.removeAllViews();
            for (int i = 0; i < labelBeans.size(); i++) {
                HomeBean.DataBean.LabelBean labelBean = labelBeans.get(i);
                TextView labelVeiw = new TextView(context);
                labelVeiw.setText("# " + labelBean.getTitle());
                labelVeiw.setPadding(40,25,40,25);
                labelVeiw.setTextSize(16);
                labelVeiw.setTextColor(Color.parseColor("#ffffff"));
                labelVeiw.setBackgroundResource(R.drawable.shape_label_hot_kinds);
                labelVeiw.setTag(labelBean.getID());
                binding.flowRoot.addView(labelVeiw);
            }

        } else if (viewHolder instanceof HomeEarViewHolder){//磨耳朵
            HomeEarViewHolder holder= (HomeEarViewHolder) viewHolder;
            GridLayoutManager  manager =new GridLayoutManager(context,3);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            holder.bingding.earRcView.setLayoutManager(manager);

            HomeBean.DataBean.ResourceBean resourceBean = (HomeBean.DataBean.ResourceBean) mData.get(5);
            holder.bingding.sectionTitle.setText(resourceBean.getTitle());
            holder.bingding.sectionDesc.setText(resourceBean.getSubtitle());
            List<HomeBean.DataBean.ResourceBean.ResourceListBeanX> resourceList = resourceBean.getResourceList();
            HomeCommonItemAdapter  adapter=new HomeCommonItemAdapter(context,resourceList,viewModelProvider);
            holder.bingding.earRcView.setAdapter(adapter);
            holder.bingding.tvEarMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(EarListActivity.class);
                }
            });


        }else if (viewHolder instanceof HomeReadViewHolder){//流利读
            HomeReadViewHolder  readViewHolder= (HomeReadViewHolder) viewHolder;
//            readViewHolder.bingding.getViewModel().name.set("流利读");
            GridLayoutManager  manager =new GridLayoutManager(context,3);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            readViewHolder.bingding.readRcView.setLayoutManager(manager);
            HomeBean.DataBean.ResourceBean resourceBean = (HomeBean.DataBean.ResourceBean) mData.get(6);
            readViewHolder.bingding.sectionTitle.setText(resourceBean.getTitle());
            readViewHolder.bingding.sectionDesc.setText(resourceBean.getSubtitle());
            List<HomeBean.DataBean.ResourceBean.ResourceListBeanX> resourceList = resourceBean.getResourceList();
            HomeCommonItemAdapter  adapter=new HomeCommonItemAdapter(context,resourceList,viewModelProvider);
            readViewHolder.bingding.readRcView.setAdapter(adapter);

            readViewHolder.bingding.tvReadMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(ReadListActivity.class);
                }
            });


        }else if (viewHolder  instanceof HomeSpeakViewHolder){//地道说
            HomeSpeakViewHolder  speakViewHolder= (HomeSpeakViewHolder) viewHolder;
//            speakViewHolder.bingding.getViewModel().name.set("地道说");
            GridLayoutManager  manager =new GridLayoutManager(context,3);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            speakViewHolder.bingding.speakRcView.setLayoutManager(manager);

            HomeBean.DataBean.ResourceBean resourceBean = (HomeBean.DataBean.ResourceBean) mData.get(7);
            speakViewHolder.bingding.sectionTitle.setText(resourceBean.getTitle());
            speakViewHolder.bingding.sectionDesc.setText(resourceBean.getSubtitle());
            List<HomeBean.DataBean.ResourceBean.ResourceListBeanX> resourceList = resourceBean.getResourceList();
            HomeCommonItemAdapter  adapter=new HomeCommonItemAdapter(context,resourceList,viewModelProvider);
            speakViewHolder.bingding.speakRcView.setAdapter(adapter);

            speakViewHolder.bingding.tvSpeakMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(SpeakListActivity.class);
                }
            });

        }

    }

    private void initTable(List<HomeBean.DataBean.RecommendBean.DataListBean> dataListBeans) {
        recommendViewHolderr.binding.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < dataListBeans.size(); i++) {
            HomeBean.DataBean.RecommendBean.DataListBean dataListBean = dataListBeans.get(i);
            recommendViewHolderr.binding.tabLayout.addTab(recommendViewHolderr.binding.tabLayout.newTab().setText(dataListBean.getTagName()).setTag(i));
        }
    }


    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    /**
     * 根布局
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {

        if (position == 0){
            return R.layout.adapter_home_looper;
        }else if (position == 1){
            return R.layout.adapter_home_grid;
        }else if (position==2){
            return R.layout.item_home_recommend;
        }else if (position==3){
            return R.layout.item_home_look_animation;
        }else if (position==4){
            return R.layout.item_home_categroy;
        }else if (position==5){
            return R.layout.item_home_ear;
        }else if (position==6){
            return R.layout.item_home_read;
        }else if (position==7){
            return R.layout.item_home_speaking;
        }
        return R.layout.layout_no_data;
    }


    //banner
    class  HomeLooperViewHolder  extends  RecyclerView.ViewHolder{
        AdapterHomeLooperBinding  binding;
        public HomeLooperViewHolder(AdapterHomeLooperBinding speakBinding) {
            super(speakBinding.getRoot());
            this.binding=speakBinding;
            HomeLoopViewModel homeEarViewModel = ViewModelProviders.of(fragment, factory).get(HomeLoopViewModel.class);
            binding.setViewModel(homeEarViewModel);
        }

    }
  //gride
    class  HomeGridBannerViewHolder  extends  RecyclerView.ViewHolder{
        AdapterHomeGridBinding binding;
        public HomeGridBannerViewHolder(AdapterHomeGridBinding speakBinding) {
            super(speakBinding.getRoot());
            this.binding=speakBinding;
            HomeGridViewModel homeEarViewModel = ViewModelProviders.of(fragment, factory).get(HomeGridViewModel.class);
            binding.setViewModel(homeEarViewModel);
        }
    }

    //推荐
    class  HomeRecommendViewHolder  extends  RecyclerView.ViewHolder{
        ItemHomeRecommendBinding  binding;
        public HomeRecommendViewHolder(ItemHomeRecommendBinding speakBinding) {
            super(speakBinding.getRoot());
            this.binding=speakBinding;
        }
    }

    class  HomeLookAnimationViewHolder  extends  RecyclerView.ViewHolder{
        ItemHomeLookAnimationBinding  binding;

        public HomeLookAnimationViewHolder(ItemHomeLookAnimationBinding lookAnimationBinding) {
            super(lookAnimationBinding.getRoot());
            this.binding=lookAnimationBinding;
            AnimationListViewModel animationListViewModel = ViewModelProviders.of(fragment, factory).get(AnimationListViewModel.class);
            binding.setViewModel(animationListViewModel);

        }
    }

    class  HomeCatefroyViewHolder  extends  RecyclerView.ViewHolder{
        ItemHomeCategroyBinding  binding;

        public HomeCatefroyViewHolder(ItemHomeCategroyBinding categroyBinding) {
            super(categroyBinding.getRoot());
            this.binding=categroyBinding;
            LabelListViewModel labelListViewModel = ViewModelProviders.of(fragment, factory).get(LabelListViewModel.class);
            binding.setViewModel(labelListViewModel);
        }
    }

    //流利读
    class  HomeReadViewHolder  extends  RecyclerView.ViewHolder{
        ItemHomeReadBinding bingding;
        public HomeReadViewHolder(ItemHomeReadBinding mReadBinding) {
            super(mReadBinding.getRoot());
            this.bingding=mReadBinding;
            HomeReadViewModel homeReadViewModel = viewModelProvider.get(HomeReadViewModel.class);
            bingding.setViewModel(homeReadViewModel);
        }
    }

    //磨耳朵
    class  HomeEarViewHolder  extends  RecyclerView.ViewHolder{
    ItemHomeEarBinding  bingding;
        public HomeEarViewHolder(ItemHomeEarBinding mEarBingding) {
            super(mEarBingding.getRoot());
            this.bingding=mEarBingding;
            HomeEarViewModel homeEarViewModel = viewModelProvider.get(HomeEarViewModel.class);
            bingding.setViewModel(homeEarViewModel);
        }
    }

    //地道说
    class HomeSpeakViewHolder  extends  RecyclerView.ViewHolder{
        ItemHomeSpeakingBinding  bingding;
        public HomeSpeakViewHolder(ItemHomeSpeakingBinding speakBinding) {
            super(speakBinding.getRoot());
            this.bingding=speakBinding;
            HomeSpeakViewModel homeSpeakViewModel = viewModelProvider.get(HomeSpeakViewModel.class);
            bingding.setViewModel(homeSpeakViewModel);
        }
    }

    private class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}





