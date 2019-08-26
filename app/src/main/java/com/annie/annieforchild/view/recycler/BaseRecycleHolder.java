package com.annie.annieforchild.view.recycler;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 *
 * RecyclerView的基础ViewHolder
 */

public class BaseRecycleHolder extends RecyclerView.ViewHolder{

    /**存放view*/
    private final SparseArray<View> mViews;

    public BaseRecycleHolder(View itemView) {
        super(itemView);
        this.mViews = new SparseArray<>(10);
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view==null){
            view = itemView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return  (T)view;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public void setText(int viewId, String text) {
        TextView view = getView(viewId);
        if(view!=null&&text!=null){
            view.setText(text);
        }
    }



}
