package com.annie.annieforchild.ui.main.home.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.entity.HomeAnimitorBean;
import com.annie.annieforchild.utils.ImageLoader;
import com.annie.annieforchild.utils.ImageLoaderUtil;
import com.annie.annieforchild.view.recycler.BaseAdapter;
import com.annie.annieforchild.view.recycler.BaseRecycleHolder;
import com.bumptech.glide.RequestManager;

import java.util.List;

public class HomeLookAnimationAdapter  extends BaseAdapter<HomeAnimitorBean> {

public  RequestManager  manager;
    public HomeLookAnimationAdapter(Context context, List<HomeAnimitorBean> data, RequestManager manager) {
        super(context, data);
        this.manager=manager;
    }

    @Override
    public void convert(BaseRecycleHolder holder, HomeAnimitorBean item, int position) {
        ImageView imageView = holder.getView(R.id.iv_home_recommend);
//        ImageLoaderUtil.displayImage(ImageLoaderUtil.PLAYHOLER_IMAGE_TYPE.BIG_BG,manager,item.imageUrl,imageView);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_home_recommend_item;
    }
}
