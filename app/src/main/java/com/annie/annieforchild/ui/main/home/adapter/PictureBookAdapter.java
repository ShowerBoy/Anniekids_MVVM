package com.annie.annieforchild.ui.main.home.adapter;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.FragmentPictureBookBinding;
import com.annie.annieforchild.databinding.ItemPictureBookBinding;
import com.annie.annieforchild.entity.PictureBookBean;
import com.annie.annieforchild.ui.main.vm.ItemPictureBookViewModel;
import com.annie.annieforchild.ui.main.vm.PictureBookViewModel;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by shen
 * on 2019/8/31
 */


public  class PictureBookAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public Context context;
    public  List<PictureBookBean> mData;
    public ViewModelProvider  viewModelProvider;
    private ItemPictureBookBinding mBinding;

    public PictureBookAdapter(Context context, List<PictureBookBean> mData, ViewModelProvider viewModelProvider) {
        this.context = context;
        this.mData = mData;
        this.viewModelProvider = viewModelProvider;
    }


    @NonNull
    @Override
    public PictureBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_picture_book, parent, false);
        PictureBookViewHolder viewHolder=new PictureBookViewHolder(mBinding);
        viewHolder.bookBinding= mBinding;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        PictureBookViewHolder holder= (PictureBookViewHolder) viewHolder;
//          holder.bookBinding.getViewModel().title.set(mData.get(position).getTitle());
//          holder.bookBinding.getViewModel().bookNumber.set(mData.get(position).getNumber());
//            holder.bookBinding.getViewModel().image.set(mData.get(position).getImage());

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }



    class  PictureBookViewHolder extends  RecyclerView.ViewHolder{
        ItemPictureBookBinding bookBinding;

        public PictureBookViewHolder(ItemPictureBookBinding mBinding) {
            super(mBinding.getRoot());
            this.bookBinding=mBinding;
//            PictureBookViewModel pictureBookViewModel = viewModelProvider.get(PictureBookViewModel.class);
//            bookBinding.setViewModel(pictureBookViewModel);
        }

    }

}
