package com.annie.annieforchild.ui.Base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.annie.annieforchild.ui.main.activity.MainActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by shen
 * on 2019/8/30
 */


public class App  extends Application {

    public  static   App  mApp;

    @Override
    public void onCreate() {
        super.onCreate();
       mApp=this;
    }


    public  synchronized   Application  getInstance(){
        return mApp;
    }

    //获取当前版本号
    public  static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo("cn.testgethandsetinfo", 0);
            versionName = packageInfo.versionName;
            if (TextUtils.isEmpty(versionName)) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }




//获取手机id
//    public static String getDeviceId(Context context) {
//        String deviceId = "";
//        if (deviceId != null && !"".equals(deviceId)) {
//            return deviceId;
//        }
//        if (deviceId == null || "".equals(deviceId)) {
//            try {
//                deviceId = getLocalMac(context).replace(":", "");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        if (deviceId == null || "".equals(deviceId)) {
//            try {
//                deviceId = getAndroidId(context);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        if (deviceId == null || "".equals(deviceId)) {
//
//            if (deviceId == null || "".equals(deviceId)) {
//                UUID uuid = UUID.randomUUID();
//                deviceId = uuid.toString().replace("-", "");
//                writeDeviceID(deviceId);
//            }
//        }
//        return deviceId;
//    }

//     IMEI码
//    private static String getIMIEStatus(Context context) {
//        TelephonyManager tm = (TelephonyManager) context
//                .getSystemService(Context.TELEPHONY_SERVICE);
//        String deviceId = tm.getDeviceId();
//        return deviceId;
//    }

//    // Mac地址
//    private static String getLocalMac(Context context) {
//        WifiManager wifi = (WifiManager) context
//                .getSystemService(Context.WIFI_SERVICE);
//        WifiInfo info = wifi.getConnectionInfo();
//        return info.getMacAddress();
//    }

    // Android Id
    private static String getAndroidId(Context context) {
        String androidId = Settings.Secure.getString(
                context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidId;
    }

//    public static void saveDeviceID(String str) {
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            Writer out = new OutputStreamWriter(fos, "UTF-8");
//            out.write(str);
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


//    public static String readDeviceID() {
//        StringBuffer buffer = new StringBuffer();
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
//            Reader in = new BufferedReader(isr);
//            int i;
//            while ((i = in.read()) > -1) {
//                buffer.append((char) i);
//            }
//            in.close();
//            return buffer.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


}
