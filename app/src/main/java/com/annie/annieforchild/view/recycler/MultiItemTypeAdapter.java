package com.annie.annieforchild.view.recycler;


import android.content.Context;

import com.annie.annieforchild.view.recycler.BaseAdapter;
import com.bumptech.glide.RequestManager;

import java.util.List;

/**
 * adapter基类，itemType多个，
 * 一个itemType见BaseAdapter
 */

public abstract class MultiItemTypeAdapter<T> extends BaseAdapter<T> {


    public MultiItemTypeAdapter(Context context, List<T> data) {
        super(context, data);
    }

    @Override
    public int getItemViewType(int position) {
        if(mData!=null&&mData.size()>position){
            return mulitAapterGetItemViewType(position,mData.get(position));
        }else {
            return mulitAapterGetItemViewType(position,null);
        }

    }


    /**返回itemViewType*/
    protected abstract int mulitAapterGetItemViewType(int position,T t);
}
