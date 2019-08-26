package com.annie.annieforchild.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import me.goldze.mvvmhabit.utils.DensityUtil;


/**
 *
 * @Description:   Recycleview 分割线
 * 显示纯色divider、显示图片divider、divider的上下左右的间距、宽高设置
 * 分割线LinearLayoutManager
 */
public class RecycleDivider extends RecyclerView.ItemDecoration{
    private Drawable mDivider;

    private int leftMargin, rightMargin, topMargin, bottomMargin;

    private int width, height;

    private int mOrientation;

    public RecycleDivider(Drawable divider, int orientation) {
        setDivider(divider);
        setOrientation(orientation);
    }

    private void setDivider(Drawable divider) {
        this.mDivider = divider;
        if (mDivider == null) {
            mDivider = new ColorDrawable(Color.parseColor("#c0c0c0"));
        }
        width = mDivider.getIntrinsicWidth();
        height = mDivider.getIntrinsicHeight();
    }

    private void setOrientation(int orientation) {
        if (orientation != LinearLayoutManager.HORIZONTAL && orientation != LinearLayoutManager.VERTICAL) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    public void setMargin(Context context, int left, int top, int right, int bottom) {
        this.leftMargin = DensityUtil.sp2px(context,left);
        this.topMargin = DensityUtil.sp2px(context,top);
        this.rightMargin = DensityUtil.sp2px(context,right);
        this.bottomMargin = DensityUtil.sp2px(context,bottom);
    }

    public void setHeight(Context context, float height) {

        this.height = DensityUtil.sp2px(context,height);
    }

    public void setWidth(Context context, float width) {
        this.width = DensityUtil.sp2px(context,width);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == LinearLayoutManager.HORIZONTAL) {
            drawHorizontal(c, parent);
        } else {
            drawVertical(c, parent);
        }
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop() + topMargin;
        final int bottom = parent.getHeight() - parent.getPaddingBottom() - bottomMargin;

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount-1; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin + leftMargin;
            final int right = left + width;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft() + leftMargin;
        final int right = parent.getWidth() - parent.getPaddingRight() - rightMargin;

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount -1 ; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin + topMargin;
            final int bottom = top + height;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (mOrientation == LinearLayoutManager.HORIZONTAL) {
            outRect.set(0, 0, leftMargin + width + rightMargin, 0);
        } else {
            outRect.set(0, 0, 0, topMargin + height + bottomMargin);
        }
    }
}

