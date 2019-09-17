package com.annie.annieforchild.ui.main.home.adapter;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.AdapterItemStoryBinding;
import com.annie.annieforchild.entity.StroyBean;
import com.annie.annieforchild.ui.main.vm.StoryViewModel;

import java.util.List;

/**
 * Created by shen
 * on 2019/9/2
 */


public class StroyAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
     public  List<StroyBean> mData;
     public Context context;
     public ViewModelProvider  viewModelProvider;
    private AdapterItemStoryBinding mBingding;

    public StroyAdapter(List<StroyBean> mData, Context context, ViewModelProvider viewModelProvider) {
        this.mData = mData;
        this.context = context;
        this.viewModelProvider = viewModelProvider;
    }

    @NonNull
    @Override
    public StroyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        mBingding = DataBindingUtil.inflate(inflater, R.layout.adapter_item_story, parent, false);
        StroyAdapterViewHolder  stroyAdapterViewHolder=new StroyAdapterViewHolder(mBingding);
        stroyAdapterViewHolder.bingding= mBingding;
        return stroyAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        StroyAdapterViewHolder  holder= (StroyAdapterViewHolder) viewHolder;
        holder.bingding.getViewModel().title.set("Aninikids");
        holder.bingding.getViewModel().collect.set("收藏");
        holder.bingding.getViewModel().addBook.set("添加教材");
        holder.bingding.getViewModel().addTable.set("添加课表");
        holder.bingding.getViewModel().number.set("23");

    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.adapter_item_story;
    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    class  StroyAdapterViewHolder  extends  RecyclerView.ViewHolder{
        AdapterItemStoryBinding  bingding;

        public StroyAdapterViewHolder(AdapterItemStoryBinding mBingding) {
            super(mBingding.getRoot());
            this.bingding=mBingding;
            StoryViewModel storyViewModel = viewModelProvider.get(StoryViewModel.class);
            bingding.setViewModel(storyViewModel);
        }
    }
}
