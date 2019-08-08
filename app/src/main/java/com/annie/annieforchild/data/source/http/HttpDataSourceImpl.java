package com.annie.annieforchild.data.source.http;

import com.annie.annieforchild.data.source.http.service.NetService;
import com.annie.annieforchild.entity.LoginByCodeBean;
import com.annie.annieforchild.entity.VcodeBean;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.utils.RxUtils;
import okhttp3.Interceptor;

public class HttpDataSourceImpl implements HttpDataSource {
    private NetService service;
    private volatile static HttpDataSourceImpl INSTANCE = null;

    public static HttpDataSourceImpl getInstance(NetService service) {
        if (INSTANCE == null) {
            synchronized (HttpDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataSourceImpl(service);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public HttpDataSourceImpl(NetService service) {
        this.service = service;
    }

    @Override
    public Observable<Object> guide() {
        return Observable.just(new Object())
                .delay(3, TimeUnit.SECONDS);
    }

    @Override
    public Observable<BaseResponse<VcodeBean>> getVerificationCode(String phone, int type) {
        return service.getVerificationCode(phone, type);
    }

    @Override
    public Observable<BaseResponse<LoginByCodeBean>> loginByVcode(String phone, int code, int serialNumber) {
        return service.loginByVcode(phone, code, serialNumber);
    }

    @Override
    public Observable<BaseResponse<LoginByCodeBean>> login(String phone, String password) {
        return service.login(phone, password);
    }
}
