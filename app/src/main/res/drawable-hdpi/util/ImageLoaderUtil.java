package com.shixi.shixitraining.shixitraining.util;

import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.shixi.shixitraining.shixitraining.R;

/**
 * Created by shenyan on 2018/7/9.
 */

public class ImageLoaderUtil {

    public enum PLAYHOLER_IMAGE_TYPE {
        /**
         * 不同的图片尺寸对应不同的垫底图
         */
        SMALL_HEAD_ICON,//圆形头像
        MIDDLE_WIDTH_SMALLER,//中等占位图 宽小于高
        MIDDLE_WIDTH_BIGGER,//中等占位图  宽大于高
        MIDDLE_WIDTH_BIGGER_ROUND,//中等占位图  宽小于高 圆角
        MIDDLE_SQUARE,//正方形占位图
        BIG_BG,//大的占位图（包含轮播图等）
        SMALL_ICON,//小图标的垫底图，社群的分类图标等
        CCTV_CHANNEL//图标垫底图
    }

    /***
     * 默认中等占位图PLAYHOLDER_MIDDLE_WIDTH_BIGGER
     */
    public static void displayImage(RequestManager requestManager, String url, ImageView
            imageView) {
        displayImage(PLAYHOLER_IMAGE_TYPE.MIDDLE_WIDTH_BIGGER, requestManager, url, imageView);
    }


    /**
     * @param type
     * @param requestManager
     * @param url
     * @param imageView
     */
    public static void displayImage(PLAYHOLER_IMAGE_TYPE type,
                                    RequestManager requestManager,
                                    String url,
                                    ImageView imageView) {
        displayImage(type, requestManager, url, imageView, null);
    }
    /**
     * @param type
     * @param requestManager
     * @param url
     * @param imageView
     * @param bitmapTransformation 设置圆角、圆形图片等需要传bitmapTransformation参数
     */
    public static void displayImage(PLAYHOLER_IMAGE_TYPE type,
                                    RequestManager requestManager,
                                    String url,
                                    ImageView imageView,
                                    BitmapTransformation bitmapTransformation) {
        displayImage(type, requestManager, url, imageView, bitmapTransformation,null);
    }
    /**
     * @param type
     * @param requestManager
     * @param url
     * @param imageView
     * @param bitmapTransformation 设置圆角、圆形图片等需要传bitmapTransformation参数
     */
    public static void displayImage(PLAYHOLER_IMAGE_TYPE type,
                                    RequestManager requestManager,
                                    String url,
                                    ImageView imageView,
                                    BitmapTransformation bitmapTransformation,
                                    final ImageLoaderCallBack callBack) {
        if (imageView == null) {
            return;
        }

        /**加载中占位图*/
        int loadingSourceId = R.drawable.default_placeholder_02;
        /**加载失败后占位图*/
        int erroSourceId = R.drawable.playholer_width_bigger_erro;


        if(requestManager==null){
            return;
        }
        DrawableRequestBuilder<String> drawableRequestBuilder = requestManager
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.RESULT);
        switch (type) {
            case SMALL_ICON:
                /**
                 * FIXME 占位图图片未修改
                 * 社群分类*/
                loadingSourceId = R.drawable.default_placeholder_02;
                erroSourceId = R.drawable.playholder_small_icon_loading;
                break;
            case MIDDLE_WIDTH_BIGGER:
                /**
                 * FIXME 占位图图片未修改
                 * 中等占位图 宽大于高*/
                loadingSourceId = R.drawable.default_placeholder_02;
                erroSourceId = R.drawable.playholer_width_bigger_erro;
                break;
            case MIDDLE_WIDTH_SMALLER:
                /**R.drawable.playholer_width_bigger_loading
                 * FIXME 占位图图片未修改
                 * 中等占位图 宽小于高*/
                loadingSourceId = R.drawable.default_placeholder_02;
                erroSourceId = R.drawable.playholer_width_bigger_erro;
                break;
            case MIDDLE_WIDTH_BIGGER_ROUND:
                /**
                 * FIXME 占位图图片未修改
                 * 中等占位图  宽小于高 圆角
                 * R.drawable.playholer_width_bigger_loading
                 */
                loadingSourceId = R.drawable.default_placeholder_02;
                erroSourceId = R.drawable.playholer_width_bigger_erro;
//                if(bitmapTransformation==null){
//                    bitmapTransformation = new GlideRoundTransform(App.getInstance(),10);
//                }
                if (bitmapTransformation != null) {
                    drawableRequestBuilder.transform(bitmapTransformation);
                }
                break;
            case MIDDLE_SQUARE:
                /**
                 * FIXME 占位图图片未修改
                 *  正方形 中等占位图
                 */
                loadingSourceId = R.drawable.default_placeholder_02;
                erroSourceId = R.drawable.playholder_square_erro;
                break;
            case SMALL_HEAD_ICON:
                /**
                 * FIXME 占位图图片未修改
                 * 小的占位图（包含圆形头像）*/
                loadingSourceId = R.drawable.placeholder_circle_head_icon;
                erroSourceId = R.drawable.placeholder_circle_head_icon;
//                if(bitmapTransformation==null){
//                    bitmapTransformation = new GlideCircleTransform(App.getInstance());
//                }
                if (bitmapTransformation != null) {
                    drawableRequestBuilder.transform(bitmapTransformation);
                }
                break;
            case BIG_BG:
                /**
                 * FIXME 占位图图片未修改
                 * 大的占位图（包含轮播图）*/
                loadingSourceId = R.drawable.banner_default;
                erroSourceId = R.drawable.playholer_big_erro;
                break;
//            case CCTV_CHANNEL:
//                loadingSourceId = R.drawable.playholder_cctv_channel_icon_loading;
//                erroSourceId = R.drawable.playholder_cctv_channel_icon_loading;
//                break;


        }
        drawableRequestBuilder.placeholder(loadingSourceId)
                .error(erroSourceId)
                .into(imageView)
                .getSize(new SizeReadyCallback(){
                    @Override
                    public void onSizeReady(int width, int height) {
                        if(callBack != null){
                            callBack.getImageSize(width,height);
                        }
                    }
                });
    }

    public interface ImageLoaderCallBack{
        void getImageSize(int width, int height);
    }

}
