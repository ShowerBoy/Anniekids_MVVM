package com.shixi.shixitraining.shixitraining.util;

import android.util.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shenyan on 2018/9/13.
 */
public class Base64Utils {

    /**
     * 用MD5算法进行加密
     *
     * @param str
     *            需要加密的字符串
     * @return MD5加密后的结果
     */
    public static String md5(String str) {
        return encode(str, "MD5");
    }

    /**
     * 用SHA算法进行加密
     *
     * @param str
     *            需要加密的字符串
     * @return SHA加密后的结果
     */
    public static String sha(String str) {
        return encode(str, "SHA");
    }

    public static String md5_sha(String str){
        return md5(sha(str));
    }

    /**
     * 用base64算法进行加密
     *
     * @param str
     *            需要加密的字符串
     * @return base64加密后的结果
     */
    public static String base64(String str) {
        String strBase64 = Base64.encodeToString(str.getBytes(), Base64.NO_WRAP);
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(str.getBytes());
        return strBase64;
    }

    /**
     * 用base64算法进行解密
     *
     * @param str
     *            需要解密的字符串
     * @return base64解密后的结果
     * @throws IOException
     */
    public static String decodeBase64(String str) throws IOException {
        String strBase64 = Base64.encodeToString(str.getBytes(), Base64.NO_WRAP);
//        BASE64Decoder encoder = new BASE64Decoder();
//        return new String(encoder.decodeBuffer(str));

        return strBase64;
    }

    private static String encode(String str, String method) {
        MessageDigest md = null;
        String dstr = null;
        try {
            md = MessageDigest.getInstance(method);
            md.update(str.getBytes());
            dstr = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return dstr;
    }

    //加密
    public static String getBase64(String str) {
        String result = "";
        if( str != null) {
            try {
                result = new String(Base64.encode(str.getBytes("utf-8"), Base64.NO_WRAP),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // 解密
    public static String getFromBase64(String str) {
        String result = "";
        if (str != null) {
            try {
                result = new String(Base64.decode(str, Base64.NO_WRAP), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
