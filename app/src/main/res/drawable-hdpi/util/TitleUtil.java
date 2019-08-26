package com.shixi.shixitraining.shixitraining.util;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shixi.shixitraining.shixitraining.R;


/**
 *Created by shenyan on 2018/7/6.
 */

public class TitleUtil {

    private View mContentView;

    public final int TYPE_CENTER = 0;
    public final int TYPE_LEFT_TEXT = 1;
    public final int TYPE_RIGHT_TEXT = 2;
    public final int TYPE_LEFT_RIGHT_TEXT = 3;
    public final int TYPE_LEFT_IMG = 4;
    public final int TYPE_RIGHT_IMG = 5;
    public final int TYPE_LEFT_RIGHT_IMG = 6;

    public TitleUtil(View contentView) {
        this.mContentView = contentView;
    }

    /**
     * 显示标题方法 所在位置没有显示内容情况下
     * 1、不传view的id 或者为0
     * 2、文字内容传"" 图片资源内容传0
     *
     * @param type          显示类型
     * @param centerId      中间View id (TextView 、ImageView)
     * @param leftId        左边View id
     * @param rightId       右边View id
     * @param imgresLeftId  左边图片资源id
     * @param imgresRightId 右边图片资源id
     * @param center        中间文字内容
     * @param left          左边文字内容
     * @param right         右边文字内容
     */
    public void initTitle(int type, int centerId, int leftId, int rightId, int imgresLeftId, int imgresRightId, String center, String left, String right) {
        switch (type) {
            case 0://只有标题
                setText(centerId, center, 0);
                break;
            case 1://有左边TEXT
                setText(centerId, center, 0);
                setText(leftId, left, 1);
                break;
            case 2://有右边边TEXT
                setText(centerId, center, 0);
                setText(rightId, right, 2);
                break;
            case 3://左边右边都有TEXT
                setText(centerId, center, 0);
                setText(leftId, left, 1);
                setText(rightId, right, 2);
                break;
            case 4://有左边图片
                setClick();
                setText(centerId, center, 0);
                setImage(leftId, imgresLeftId, 1);
                break;
            case 5://有右边图片
                setText(centerId, center, 0);
                setImage(rightId, imgresRightId, 2);
                break;
            case 6://左右两边都有图片
                setClick();
                setText(centerId, center, 0);
                setImage(leftId, imgresLeftId, 1);
                setText(rightId, right, 2);
                break;
        }

    }


    /**
     * 设置文本内容
     *
     * @param viewId
     * @param text
     */
    private void setText(int viewId, final String text, final int type) {
        if (!TextUtils.isEmpty(text)) {
            TextView textView = (TextView) mContentView.findViewById(viewId);
            if (textView != null) {
                textView.setVisibility(View.VISIBLE);
                textView.setText(text);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (type == 1 && leftListener != null) {
                            leftListener.onLeftClick(v);
                        }
                        if (type == 2 && rightListener != null) {
                            rightListener.onRightClick(v);
                        }
                    }
                });

            }
        }
    }

    /**
     * 设置图片内容
     *
     * @param viewId
     * @param imgRes
     */
    private void setImage(int viewId, int imgRes, final int type) {
        ImageView imageView = (ImageView) mContentView.findViewById(viewId);
        if (imageView != null) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(imgRes);
        }
    }

    private  void setClick(){
        mContentView.findViewById(R.id.top_bar_left_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftListener!=null){
                    leftListener.onLeftClick(v);
                }
            }
        });
    }

    private LeftListener leftListener;

    public void setLeftListener(LeftListener l) {
        leftListener = l;
    }

    public interface LeftListener {
        void onLeftClick(View view);
    }

    private RightListener rightListener;

    public void setRightListener(RightListener l) {
        rightListener = l;
    }

    public interface RightListener {
        void onRightClick(View view);
    }


}
