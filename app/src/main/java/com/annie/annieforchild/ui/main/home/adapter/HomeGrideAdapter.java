package com.annie.annieforchild.ui.main.home.adapter;

import android.content.Context;
import android.widget.ImageView;


import com.annie.annieforchild.R;
import com.annie.annieforchild.entity.HomeGrideBean;
import com.annie.annieforchild.view.recycler.BaseAdapter;
import com.annie.annieforchild.view.recycler.BaseRecycleHolder;
import com.bumptech.glide.RequestManager;

import java.util.List;

public class HomeGrideAdapter extends BaseAdapter<HomeGrideBean> {


    public HomeGrideAdapter(Context context, List<HomeGrideBean> data, RequestManager requestManager) {
        super(context, data, requestManager);
    }

    @Override
    public void convert(BaseRecycleHolder holder, HomeGrideBean item, int position) {
        ImageView imageView = holder.getView(R.id.gride_img);
        imageView.setImageResource(item.resId);
        holder.setText(R.id.gride_title, item.title);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_home_gride_item;
    }
}