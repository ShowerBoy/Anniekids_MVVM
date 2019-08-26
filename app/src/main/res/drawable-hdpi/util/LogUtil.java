package com.shixi.shixitraining.shixitraining.util;

import android.text.TextUtils;
import android.util.Log;

import static com.shixi.shixitraining.shixitraining.constant.Constants.isDebug;

/**
 * Created by shenyan on 2018/7/6.
 */

public class LogUtil {

    private static final String TAG = "testlog";

    public static void i(String msg){
        if(isDebug&&!TextUtils.isEmpty(msg))
            Log.i(TAG,msg);
    }

    public static void e(String msg){
        if(isDebug&&!TextUtils.isEmpty(msg))
            Log.e(TAG,msg);
    }

    public static void d(String msg){
        if(isDebug&&!TextUtils.isEmpty(msg))
            Log.d(TAG,msg);
    }

    public static void i(String tag, String msg){
        if(isDebug&&!TextUtils.isEmpty(msg))
            Log.i(tag,msg);
    }

}
