package com.annie.annieforchild.ui.main.home.adapter;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ItemHomeAnimitionItemBinding;
import com.annie.annieforchild.entity.HomeAnimitorBean;
import com.annie.annieforchild.entity.HomeBean;
import com.annie.annieforchild.utils.ImageLoader;
import com.annie.annieforchild.utils.ImageLoaderUtil;
import com.annie.annieforchild.view.recycler.BaseAdapter;
import com.annie.annieforchild.view.recycler.BaseRecycleHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.ArrayList;
import java.util.List;

public class HomeLookAnimationAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<HomeBean.DataBean.AnimationBean> data = new ArrayList<>();
    public  Context  context;
    private ViewModelProvider viewModelProvider;

    public HomeLookAnimationAdapter(List<HomeBean.DataBean.AnimationBean> data, Context context, ViewModelProvider viewModelProvider) {
        this.data = data;
        this.context = context;
        this.viewModelProvider = viewModelProvider;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemHomeAnimitionItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_home_animition_item, viewGroup, false);
        ItemViewHoler viewHoler = new ItemViewHoler(binding);
        viewHoler.mBinding= binding;
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ItemViewHoler holer= (ItemViewHoler) viewHolder;
        ItemHomeAnimitionItemBinding mBinding = holer.mBinding;
        HomeBean.DataBean.AnimationBean animationBean = data.get(i);
        Glide.with(context).load(animationBean.getBookImageUrl()).into(mBinding.ivHomeRecommend);
        mBinding.tvRecommendTitle.setText(animationBean.getBookName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class  ItemViewHoler  extends  RecyclerView.ViewHolder{
        ItemHomeAnimitionItemBinding mBinding;
        public ItemViewHoler(ItemHomeAnimitionItemBinding bingding) {
            super(bingding.getRoot());
            this.mBinding=bingding;
        }
    }
}
