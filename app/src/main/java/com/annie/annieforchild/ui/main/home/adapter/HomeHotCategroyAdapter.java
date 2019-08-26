package com.annie.annieforchild.ui.main.home.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.entity.HomeHotCategroyBean;
import com.annie.annieforchild.entity.HomeRecommendListBean;
import com.annie.annieforchild.view.recycler.BaseAdapter;
import com.annie.annieforchild.view.recycler.BaseRecycleHolder;
import com.bumptech.glide.RequestManager;

import java.util.List;

public class HomeHotCategroyAdapter extends BaseAdapter<HomeHotCategroyBean> {

public  RequestManager manager;
    public HomeHotCategroyAdapter(Context context, List<HomeHotCategroyBean> data, RequestManager manager) {
        super(context, data);
        this.manager=manager;
    }

    @Override
    public void convert(BaseRecycleHolder holder, HomeHotCategroyBean item, int position) {
        holder.setText(R.id.tv_name,item.getTitle());
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_home_flow_item;
    }


}
