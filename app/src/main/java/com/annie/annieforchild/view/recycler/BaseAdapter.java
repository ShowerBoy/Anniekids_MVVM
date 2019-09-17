package com.annie.annieforchild.view.recycler;
/**
 *
 * adapter基类，itemType只有一个，
 * 多个itemType见MultiItemTypeAdapter
 */

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;

import java.util.List;

/**T为adapter绑定数据bean*/
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseRecycleHolder>{
    /**绑定数据源*/
    protected List<T> mData;
    /**上下文*/
    protected Context mContext;
    /**每个itemview的点击事件*/
    protected OnCustomItemClickListener<T> mOnCustomItemClickListener;
    protected RequestManager mRequestManager;


    private long DELAY_TIME = 1000;
    private static long lastClickTime;

    private boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < DELAY_TIME) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public BaseAdapter(Context context, List<T> data) {
        this(context,data,null);
    }

    public BaseAdapter(Context context, List<T> data, RequestManager requestManager) {
        this.mData = data;
        this.mContext = context;
        this.mRequestManager = requestManager;
    }


    @Override
    public BaseRecycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(getLayoutId(viewType),parent,false);

//        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), viewType, parent, false);
        return new BaseRecycleHolder(view);
    }

    /**
     * Recycler适配器填充方法
     *
     * @param holder      holder
     * @param item        javabean
     */
    public abstract void convert(BaseRecycleHolder holder, T item, int position);

    @Override
    public void onBindViewHolder(BaseRecycleHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnCustomItemClickListener!=null&&position<mData.size()){
                    mOnCustomItemClickListener.onCustomItemClick(mData.get(position),position);
                }
            }
        });

        //增加长按事件
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mCustomLongClick!= null && position<mData.size()){
                    mCustomLongClick.onLongClick(mData.get(position),position);
                }
                return true;
            }
        });
        convert(holder, mData.get(position), position);


    }

    /**绑定的布局文件*/
    protected abstract int getLayoutId(int viewType);


    @Override
    public int getItemCount() {
        if(mData==null){
            return 0;
        }
        return mData.size();
    }

    /**
     * 设置每个itemview的点击事件
     */
    public void setOnCustomItemClickListener(OnCustomItemClickListener<T> onCustomItemClickListener){
        mOnCustomItemClickListener = onCustomItemClickListener;
    }


    public interface OnCustomItemClickListener<T>{
        void onCustomItemClick(T item, int position);
    }

    //长按事件
    protected onCustomLongClickListener<T> mCustomLongClick;

    public interface onCustomLongClickListener<T>{
        void onLongClick(T item, int position);
    }

    public void setOnCustomLongClickListener(onCustomLongClickListener<T> l){
        this.mCustomLongClick = l;
    }




}
