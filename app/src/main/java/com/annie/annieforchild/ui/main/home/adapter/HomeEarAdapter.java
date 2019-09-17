package com.annie.annieforchild.ui.main.home.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.entity.HomeAnimitorBean;
import com.annie.annieforchild.entity.HomeEarBean;
import com.annie.annieforchild.utils.ImageLoaderUtil;
import com.annie.annieforchild.view.recycler.BaseAdapter;
import com.annie.annieforchild.view.recycler.BaseRecycleHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.List;

public class HomeEarAdapter  extends BaseAdapter<HomeEarBean> {
    public  RequestManager  manager;
    public HomeEarAdapter(Context context, List<HomeEarBean> data, RequestManager manager) {
        super(context, data);
        this.manager=manager;
    }

    @Override
    public void convert(BaseRecycleHolder holder, HomeEarBean item, int position) {
         ImageView image = holder.getView(R.id.iv_home_ear);
         holder.setText(R.id.tv_ear_title,item.getTitle());
//        ImageLoaderUtil.displayImage(ImageLoaderUtil.PLAYHOLER_IMAGE_TYPE.BIG_BG,manager,item.getImageUrl(),image);
        Glide.with(mContext).load(item.getImageUrl()).into(image);

    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_home_ear_item ;
    }
}
