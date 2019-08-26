package com.annie.annieforchild.view.recycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class InterceptTouchRecycleView extends RecyclerView {
    public InterceptTouchRecycleView(Context context) {
        super(context);
    }

    public InterceptTouchRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InterceptTouchRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


//    int mLastX, mLastY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        requestDisallowInterceptTouchEvent(true);
        return true;

    }

}

