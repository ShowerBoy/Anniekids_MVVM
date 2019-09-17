package com.annie.annieforchild.ui.main.home.adapter;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ItemHomeEarItemBinding;
import com.annie.annieforchild.entity.HomeAnimitorBean;
import com.annie.annieforchild.entity.HomeEarBean;
import com.annie.annieforchild.ui.main.vm.HoemItemEarViewModel;

import java.util.List;

public class HomeItemEarAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
public Context  context;
public List<HomeEarBean> mData;
public ViewModelProvider viewModelProvider;
    public ItemHomeEarItemBinding bingding;

    public HomeItemEarAdapter(Context context, List<HomeEarBean> mData, ViewModelProvider viewModelProvider) {
        this.context = context;
        this.mData = mData;
        this.viewModelProvider = viewModelProvider;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
         bingding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_home_ear_item, parent, false);
         ItemEarViewHoler viewHoler = new ItemEarViewHoler(bingding);
         viewHoler.mBinding= bingding;
         return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ItemEarViewHoler holer= (ItemEarViewHoler) viewHolder;
        holer.mBinding.getViewModel().title.set(mData.get(position).title);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class  ItemEarViewHoler  extends  RecyclerView.ViewHolder{
        ItemHomeEarItemBinding  mBinding;
        public ItemEarViewHoler(ItemHomeEarItemBinding bingding) {
            super(bingding.getRoot());
            this.mBinding=bingding;
            HoemItemEarViewModel hoemItemEarViewModel = viewModelProvider.get(HoemItemEarViewModel.class);
            mBinding.setViewModel(hoemItemEarViewModel);
        }
    }


}
