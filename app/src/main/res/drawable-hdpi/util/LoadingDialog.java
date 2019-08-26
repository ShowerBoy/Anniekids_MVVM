package com.shixi.shixitraining.shixitraining.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.shixi.shixitraining.shixitraining.R;

/**
 * Created by jeff on 2017/2/6.
 */

public class LoadingDialog extends ProgressDialog {

    private ImageView mLoading;
    private AnimationDrawable mAnimation;

    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public LoadingDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_dialog);
        mLoading = (ImageView) findViewById(R.id.iv_loading);
        mAnimation = (AnimationDrawable) mLoading.getBackground();
        mAnimation.start();
    }

}
