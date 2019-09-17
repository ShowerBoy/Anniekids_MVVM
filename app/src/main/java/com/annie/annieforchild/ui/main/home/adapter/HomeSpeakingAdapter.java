package com.annie.annieforchild.ui.main.home.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.entity.HomeReadingBean;
import com.annie.annieforchild.entity.HomeSpeakingBean;
import com.annie.annieforchild.view.recycler.BaseAdapter;
import com.annie.annieforchild.view.recycler.BaseRecycleHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.List;

/**
 * Created by shen
 * on 2019/8/27
 */


public class HomeSpeakingAdapter extends BaseAdapter<HomeSpeakingBean> {
    public  RequestManager  manager;
    public HomeSpeakingAdapter(Context context, List<HomeSpeakingBean> data, RequestManager requestManager) {
        super(context, data);
        this.manager=requestManager;
    }

    @Override
    public void convert(BaseRecycleHolder holder, HomeSpeakingBean item, int position) {
         holder.setText(R.id.tv_read_title,item.getTitle());
         ImageView imageView = holder.getView(R.id.iv_home_read);
         Glide.with(mContext).load(item.getImageUrl()).into(imageView);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_home_read_item;
    }
}
