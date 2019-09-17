package com.annie.annieforchild.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import static android.support.constraint.Constraints.TAG;

public class SystemPhoneCodeUtitls {


    private String getMEID(){

        try {

            Class clazz = Class.forName("android.os.SystemProperties");

            Method method = clazz.getMethod("get", String.class, String.class);



            String meid = (String) method.invoke(null, "ril.cdma.meid", "");

            if(!TextUtils.isEmpty(meid)){

                Log.d(TAG,"getMEID meid: "+ meid);

                return meid;

            }

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {

            e.printStackTrace();

            Log.w(TAG,"getMEID error : "+ e.getMessage());

        }

        return "";

    }

}
