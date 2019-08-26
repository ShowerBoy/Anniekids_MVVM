package com.annie.annieforchild.utils;


import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.ImageView;

import com.annie.annieforchild.utils.glide.GlideRequestType;
import com.annie.annieforchild.utils.glide.GlideTransform;
import com.annie.annieforchild.utils.glide.HolderType;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;


import org.greenrobot.essentials.collections.Multimap;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;

import me.goldze.mvvmhabit.base.AppManager;
import me.goldze.mvvmhabit.base.BaseApplication;

/**
 * 图片缓存工具类
 */
public class ImageLoader {
    private Object mActivityOrFragment;
    private Object mImageViewOrTarget;
    private Object mModel;
    private int mRequestManagerGenericType = GlideRequestType.DRAWABLE;
    private String mHolderType = HolderType.RECTANGEL_IMAGE;
    private int mGlideTransform = -1;
    private Object errorModel;
    private ImageSizeCallBack imageSizeCallBack;
    private int[] customHolders;
    private Transformation<Bitmap> transformation;
    private int mOverrideWidth;
    private int mOverrideHeight;
    private boolean isOverrideSize = false;

    public ImageLoader(Object activityOrFragment, Object imageViewOrTarget, Object model) {
        this.mActivityOrFragment = activityOrFragment;
        this.mImageViewOrTarget = imageViewOrTarget;
        this.mModel = model;
    }

    public ImageLoader retryOnce(Object... errorModel) {
        if (errorModel != null && errorModel.length > 0) {
            this.errorModel = errorModel[0];
        } else {
            this.errorModel = mModel;
        }
        return this;
    }

    public ImageLoader imageSizeCallBack(ImageSizeCallBack imageSizeCallBack) {
        this.imageSizeCallBack = imageSizeCallBack;
        return this;
    }

    public ImageLoader requestType(int requestManagerGenericType) {
        this.mRequestManagerGenericType = requestManagerGenericType;
        return this;
    }

    public ImageLoader customShape(Transformation<Bitmap> transformation) {
        this.mGlideTransform = GlideTransform.custom;
        this.transformation = transformation;
        return this;
    }

    public ImageLoader customSize(int width, int height) {
        this.mOverrideHeight = height;
        this.mOverrideWidth = width;
        this.isOverrideSize = true;
        return this;
    }

    public ImageLoader circle() {
        this.mGlideTransform = GlideTransform.circleCrop;
        return this;
    }

    public ImageLoader fitCenter() {
        this.mGlideTransform = GlideTransform.fitCenter;
        return this;
    }

    public ImageLoader centerCrop() {
        this.mGlideTransform = GlideTransform.centerCrop;
        return this;
    }

    public ImageLoader holderType(String holderType) {
        this.mHolderType = holderType;
        return this;
    }

    public ImageLoader customHolders(int[] customHolders) {
        this.customHolders = customHolders;
        return this;
    }

    public interface ImageSizeCallBack {
        void getImageSize(int width, int height);
    }

    private static final Multimap<String, Integer> DefPlaceHolder = Multimap.create();

    static {
//        DefPlaceHolder.putElement(HolderType.HEAD_IMAGE, R.drawable.default_user_headimg);
//        DefPlaceHolder.putElement(HolderType.HEAD_IMAGE, R.drawable.default_user_headimg);
//        DefPlaceHolder.putElement(HolderType.RECTANGEL_IMAGE, R.drawable.default_placeholder_01);
//        DefPlaceHolder.putElement(HolderType.RECTANGEL_IMAGE, R.drawable.default_placeholder_01);

    }

    private RequestOptions setPlaceHolder(RequestOptions requestOptions, Object loadingPlaceHolder, Object errorPlaceHolder) {
        if (loadingPlaceHolder instanceof Integer) {
            requestOptions.placeholder((Integer) loadingPlaceHolder);
        } else if (loadingPlaceHolder instanceof Drawable) {
            requestOptions.placeholder((Drawable) loadingPlaceHolder);
        } else {
            throw new IllegalArgumentException("loadingPlaceHolder can only be intResource or Drawable");
        }
        if (errorPlaceHolder instanceof Integer) {
            requestOptions.error((Integer) errorPlaceHolder);
        } else if (errorPlaceHolder instanceof Drawable) {
            requestOptions.error((Drawable) errorPlaceHolder);
        } else {
            throw new IllegalArgumentException("errorPlaceHolder can only be intResource or Drawable");
        }
        return requestOptions;
    }

    private RequestManager getRequestManager(Object activityOrFragment) {
        RequestManager requestManager = null;
//        BaseApplication app= (BaseApplication) BaseApplication.getApp();
        AppManager  appManager=AppManager.getAppManager();
        if (activityOrFragment instanceof Activity) {
            Activity activity = (Activity) activityOrFragment;
            if (activity != null && !activity.isFinishing() && appManager.contains(activity)) {
                requestManager = Glide.with(activity);
            }
        } else if (activityOrFragment instanceof Fragment) {
            Fragment fragment = (Fragment) activityOrFragment;
            if (fragment != null && !fragment.isDetached() && !fragment.isRemoving()) {
                requestManager = Glide.with(fragment);
            }
        } else if (activityOrFragment instanceof android.support.v4.app.Fragment) {
            android.support.v4.app.Fragment fragment = (android.support.v4.app.Fragment) activityOrFragment;
            if (fragment != null && !fragment.isDetached() && !fragment.isRemoving()) {
                requestManager = Glide.with(fragment);
            }
        } else if (activityOrFragment instanceof FragmentActivity) {
            FragmentActivity activity = (FragmentActivity) activityOrFragment;
            if (activity != null && !activity.isFinishing() && appManager.contains(activity)) {
                requestManager = Glide.with(activity);
            }
        } else {
            requestManager = Glide.with(BaseApplication.sAndroidApp);
        }
        return requestManager;
    }

    public void show() {
        RequestOptions requestOptions = new RequestOptions();
        try {
            if (mGlideTransform > 0) {
                switch (mGlideTransform) {
                    case GlideTransform.fitCenter:
                        requestOptions.fitCenter();
                        break;
                    case GlideTransform.circleCrop:
                        requestOptions.circleCrop();
                        break;
                    case GlideTransform.centerCrop:
                        requestOptions.centerCrop();
                        break;
                    case GlideTransform.custom:
                        requestOptions = RequestOptions.bitmapTransform(transformation);
                        break;
                }
            }
            if (TextUtils.equals(mHolderType, HolderType.CUSTOM_TYPE)) {
                setPlaceHolder(requestOptions, customHolders[0], customHolders[1]);
            } else if (TextUtils.equals(mHolderType, HolderType.NO_HOLDER)) {
            } else {
                List<Integer> list = DefPlaceHolder.get(mHolderType);
                setPlaceHolder(requestOptions, list.get(0), list.get(1));
                if (TextUtils.equals(mHolderType, HolderType.HEAD_IMAGE)) {
                    requestOptions.circleCrop();
                }
            }
        } catch (Exception e) {
//            LogUtil.e("customHolders is null or is less than 2");
        }
        RequestManager requestManager = getRequestManager(mActivityOrFragment);
        if (requestManager == null) {
            return;
        }
        RequestBuilder requestBuilder;
        if (mModel instanceof String) {
            String url = (String) mModel;
            if (UrlUtil.isPathIgnoreCaseEndsWith(url, ".gif")) {
                mRequestManagerGenericType = GlideRequestType.GIF;
            }
        }
        switch (mRequestManagerGenericType) {
            case GlideRequestType.BITMAP:
                requestBuilder = requestManager.asBitmap();
                break;
            case GlideRequestType.GIF:
                requestBuilder = requestManager.asGif();
                break;
            case GlideRequestType.FILE:
                requestBuilder = requestManager.asFile();
                break;
            default:
                requestBuilder = requestManager.asDrawable();
                break;
        }
        requestBuilder.load(mModel);
        if (errorModel != null) {
            requestBuilder.error(requestBuilder.load(errorModel));
        }
        if(isOverrideSize){
            requestOptions.override(mOverrideWidth, mOverrideHeight);
        }
        requestBuilder.apply(requestOptions);
        try {
            Target target = null;
            if (mImageViewOrTarget instanceof ImageView) {
                target = requestBuilder.into((ImageView) mImageViewOrTarget);
            } else if (mImageViewOrTarget instanceof Target) {
                target = requestBuilder.into((Target<Drawable>) mImageViewOrTarget);
            }
            if (target != null && imageSizeCallBack != null) {
                target.getSize(new SizeReadyCallback() {
                    @Override
                    public void onSizeReady(int width, int height) {
                        imageSizeCallBack.getImageSize(width, height);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
//            LogUtil.e(e.getMessage());
        }
    }

    public static void displayFirstImage(Object activityOrFragment, Object imageViewOrTarget, String urls) {
        String dest = "http://fsdfsd324.jpg";
        if (!TextUtils.isEmpty(urls)) {
            String[] list = urls.split(",");
            dest = list[0];
        }
        new ImageLoader(activityOrFragment, imageViewOrTarget, dest).show();
    }

    public static File downloadAndCacheFile(String url) {
        File file = null;
        try {
            file = Glide.with(BaseApplication.sAndroidApp).download(url).submit().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void showRoundHomeImage(ImageView img, Object imageViewOrTarget, String holderType) {
        roundImage(img, imageViewOrTarget, holderType, 10);
    }

    private static void roundImage(ImageView img, Object imageViewOrTarget, String holderType, int radiusPx) {
        new ImageLoader(img.getContext(), img, imageViewOrTarget)
                // .customShape(new RoundedCornersTransformation(radiusPx, 0, RoundedCornersTransformation.CornerType.ALL))
                .holderType(holderType).show();
    }

}
