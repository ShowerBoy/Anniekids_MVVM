package com.shixi.shixitraining.shixitraining.util;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;

import com.shixi.shixitraining.shixitraining.R;

/**
 * Created by jeff on 2018/7/5.
 */

public class LoadingUtil {


    public Dialog mDialog;
    private RotateAnimation rotateAnimation;

    public LoadingUtil() {

    }

    /**
     * 显示加载
     *
     * @param context
     */
    public void showLoadingDialog(Context context) {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }

        if (rotateAnimation != null) {
            rotateAnimation.hasStarted();
            rotateAnimation.cancel();
        }

        rotateAnimation = null;
        rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(context, R.anim.rotate_loading);
        mDialog = new Dialog(context, R.style.Dialog_no_drak);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_loading, null);
        mDialog.setContentView(view);
        mDialog.show();
        mDialog.setCanceledOnTouchOutside(false);

        try {

            mDialog.show();
            View dialog = view.findViewById(R.id.rotate_loading);
            dialog.setAnimation(rotateAnimation);
            dialog.startAnimation(rotateAnimation);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐藏  dismissLoadDialog
     */
    public void dismissLoadingDialog() {
        if (mDialog != null && mDialog.isShowing()==true ) {
            mDialog.dismiss();
            mDialog = null;
        }

        if (rotateAnimation!=null && rotateAnimation.hasStarted()) {
            rotateAnimation.cancel();
        }

    }
}
