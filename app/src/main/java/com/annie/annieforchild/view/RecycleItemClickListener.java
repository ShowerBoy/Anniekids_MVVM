package com.annie.annieforchild.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * @Description: RecycleView item的点击事件
 */
public abstract class RecycleItemClickListener implements RecyclerView.OnItemTouchListener{

    private GestureDetector mGesture;

    public RecycleItemClickListener(Context context){

        mGesture = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            //手势监听一次按下抬起的动作
            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

        });
    }

    public abstract  void itemClickListener(View view, int position);

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mGesture.onTouchEvent(e)){
            itemClickListener(childView,rv.getChildAdapterPosition(childView));
            return  true;
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}

