package com.shixi.shixitraining.shixitraining.util;

import android.text.TextUtils;

/**
 * 用户信息管理
 *
 */

public class UserManager {

    private static com.shixi.shixitraining.shixitraining.util.UserManager userManager;

    public static synchronized com.shixi.shixitraining.shixitraining.util.UserManager getInstance() {
        if (userManager == null) {
            userManager = new com.shixi.shixitraining.shixitraining.util.UserManager();
        }
        return userManager;
    }


    /**
     * 获取用户是否登录
     *
     * @return
     */
    public boolean isUserLogged() {
        String userId = (String) com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.get("userid", "");
        return !TextUtils.isEmpty(userId) && !"0".equals(userId);
    }

    /**
     * 获取用户userId
     *
     * @return
     */
    public String getUserId() {
        return (String) com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.get(
                "userid", "");
    }

    /**
     * 保存用户userId
     *
     * @param userId
     */
    public void saveUserId(String userId) {
        com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.put("userid", userId);
    }

    //获取用户头像
    public String getUserIcon() {
        return (String) com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.get(
                "userPhoto", "");
    }

    //保存用户头像
    public void setUserIcon(String photo) {
        com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.put("userPhoto", photo);
    }

    /**
     * 获取用户昵称
     *
     * @return
     */
    public String getUserName() {
        return (String) com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.get(
                "userName", "");
    }



    /**
     * 保存用户昵称
     *
     * @param name
     */
    public void saveUserName(String name) {
        com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.put( "userName", name);
    }

    //保存token
    public void saveToken(String token) {
        com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.put( "userToken", token);
    }

    public String getToken() {
        return (String) com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.get(
                "userToken", "");
    }

    /**
     * 获取用户密码
     * @return
     */
    public String getUserPassWord(){
        return (String) com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.get(
                "userPsw", "");
    }
    /**
     * 保存密码
     * @param passWord
     */
    public void savePassWord(String passWord){
        com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.put( "userPsw", passWord);
    }


    /**
     * 获取邮箱
     * @return
     */
    public String getUserEmail(){
        return (String) com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.get(
                "userEmail","");
    }

    /**
     * 保存邮箱
     * @param userEmail
     */
    public  void  saveUserEmail(String userEmail){
        com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.put("userEmail",userEmail);
    }

    /**
     * 获取手机号
     * @return
     */
    public String getUserPhone(){
        return (String) com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.get(
                "userPhone","");
    }

    /**
     * 保存手机号
     * @param userPhone
     */
    public  void saveUserPhone(String userPhone){
        com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.put("userPhone",userPhone);
    }

    /**
     * 获取微信号
     * @return
     */
    public String getUserweChat(){
        return (String) com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.get(
                "userWechat","");
    }

    /**
     * 保存微信
     * @param userweChat
     */
    public void saveUserweChat(String userweChat){
        com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.put("userWechat",userweChat);
    }

    /**
     * 获取国家
     * @return
     * SharePreferenceUtil.SPFILENAME.FILE_NAME,
     */
    public String getUserAddress(){
        return (String) com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.get(
                "userAddress","");
    }

    /**
     * 保存国家
     * @param userAddress
     */
    public void saveUserAddress(String userAddress){
        com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.put(
                "",userAddress);
}


    public boolean isUserRegister(){
        String signusersIdcard = (String) com.shixi.shixitraining.shixitraining.util.SharePreferenceUtil.get("signusersidcard", "");
        return !TextUtils.isEmpty(signusersIdcard) && !"0".equals(signusersIdcard);
    }


}
