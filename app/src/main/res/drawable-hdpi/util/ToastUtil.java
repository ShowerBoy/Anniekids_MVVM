package com.shixi.shixitraining.shixitraining.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jeff on 2018/7/5.
 * 土司工具
 */

public class ToastUtil {

    public static void shortToast(String msg) {
//        show(msg, Toast.LENGTH_SHORT);
//        ToastCustomUtil.show(msg);
    }

    public  static void showLongToast(Context context, String msg){
        if (!msg.isEmpty()&&context!=null){
            Toast.makeText(context,msg, Toast.LENGTH_LONG).show();
        }
    }


    public static void showShortToast(Context context, String msg){
        if (!msg.isEmpty()&&context!=null){

            Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
        }
    }
}
