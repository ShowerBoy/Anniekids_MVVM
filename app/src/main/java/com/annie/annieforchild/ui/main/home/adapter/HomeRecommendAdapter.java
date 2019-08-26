package com.annie.annieforchild.ui.main.home.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.entity.HomeRecommendListBean;
import com.annie.annieforchild.view.recycler.BaseAdapter;
import com.annie.annieforchild.view.recycler.BaseRecycleHolder;
import com.bumptech.glide.RequestManager;

import java.util.List;

public class HomeRecommendAdapter  extends BaseAdapter<HomeRecommendListBean> {

public  RequestManager manager;
    public HomeRecommendAdapter(Context context, List<HomeRecommendListBean> data, RequestManager manager) {
        super(context, data);
        this.manager=manager;
    }


    @Override
    public void convert(BaseRecycleHolder holder, HomeRecommendListBean item, int position) {
        ImageView image = holder.getView(R.id.iv_home_recommend);
//        ImageLoaderUtil.displayImage(ImageLoaderUtil.PLAYHOLER_IMAGE_TYPE.BIG_BG,manager,item.imageUrl,image);
//        Glide.with(mContext).load(item.imageUrl).into(image);

    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_home_recommend_item;
    }
}
