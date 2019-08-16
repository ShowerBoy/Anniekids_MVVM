package com.annie.annieforchild.data.source.local;

import me.goldze.mvvmhabit.utils.SPUtils;
import okhttp3.Interceptor;

public class LocalDataSourceImpl implements LocalDataSource {
    private volatile static LocalDataSourceImpl INSTANCE = null;

    public static LocalDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public LocalDataSourceImpl() {
    }

    @Override
    public void toTaobao(String url) {

    }

    @Override
    public void savePhone(String phone) {
        SPUtils.getInstance().put("phone", phone);
    }

    @Override
    public void savePassword(String password) {
        SPUtils.getInstance().put("password", password);
    }

    @Override
    public String getPhone() {
        return SPUtils.getInstance().getString("phone");
    }

    @Override
    public String getPassword() {
        return SPUtils.getInstance().getString("password");
    }
}
