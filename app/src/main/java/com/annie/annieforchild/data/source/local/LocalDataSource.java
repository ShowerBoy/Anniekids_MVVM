package com.annie.annieforchild.data.source.local;

public interface LocalDataSource {

    void toTaobao(String url);

    /**
     * 保存手机号
     */
    void savePhone(String phone);

    /**
     * 保存用户密码
     */

    void savePassword(String password);

    /**
     * 获取手机号
     */
    String getPhone();

    /**
     * 获取用户密码
     */
    String getPassword();

    /**
     * 保存用户token
     */

    void saveToken(String token);

    /**
     * 获取用户的token
     */
    String  getToken();




}
