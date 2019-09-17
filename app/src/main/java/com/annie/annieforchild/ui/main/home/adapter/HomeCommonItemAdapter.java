package com.annie.annieforchild.ui.main.home.adapter;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ItemHomeEarItemBinding;
import com.annie.annieforchild.entity.HomeBean;
import com.bumptech.glide.Glide;

import java.util.List;

public class HomeCommonItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public Context  context;
    public List mData;
    public ViewModelProvider viewModelProvider;


    public void setmData(List mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public HomeCommonItemAdapter(Context context, List mData, ViewModelProvider viewModelProvider) {
        this.context = context;
        this.mData = mData;
        this.viewModelProvider = viewModelProvider;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
         ItemHomeEarItemBinding bingding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_home_ear_item, parent, false);
         ItemEarViewHoler viewHoler = new ItemEarViewHoler(bingding);
         viewHoler.mBinding= bingding;
         return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ItemEarViewHoler holer= (ItemEarViewHoler) viewHolder;
        Object data = mData.get(position);
        if (data instanceof HomeBean.DataBean.ResourceBean.ResourceListBeanX){
            HomeBean.DataBean.ResourceBean.ResourceListBeanX listBeanX = (HomeBean.DataBean.ResourceBean.ResourceListBeanX) data;
            ItemHomeEarItemBinding mBinding = holer.mBinding;
            mBinding.tvEarTitle.setText(listBeanX.getBookName());
            Glide.with(context).load(listBeanX.getBookImageUrl()).into(mBinding.ivHomeEar);
        }else if (data instanceof HomeBean.DataBean.RecommendBean.DataListBean.ResourceListBean){
            HomeBean.DataBean.RecommendBean.DataListBean.ResourceListBean resourceListBean = (HomeBean.DataBean.RecommendBean.DataListBean.ResourceListBean) data;
            ItemHomeEarItemBinding mBinding = holer.mBinding;
            mBinding.tvEarTitle.setText(resourceListBean.getBookName());
            Glide.with(context).load(resourceListBean.getBookImageUrl()).into(mBinding.ivHomeEar);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class  ItemEarViewHoler  extends  RecyclerView.ViewHolder{
        ItemHomeEarItemBinding mBinding;
        public ItemEarViewHoler(ItemHomeEarItemBinding bingding) {
            super(bingding.getRoot());
            this.mBinding=bingding;
        }
    }


}
