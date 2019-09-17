package com.annie.annieforchild.data.source.http;

import com.annie.annieforchild.data.source.http.service.NetService;
import com.annie.annieforchild.entity.Banner;
import com.annie.annieforchild.entity.DemoEntity;
import com.annie.annieforchild.entity.ForgetPsdBean;
import com.annie.annieforchild.entity.HomeData;
import com.annie.annieforchild.entity.LoginByCodeBean;
import com.annie.annieforchild.entity.SortSearchBean;
import com.annie.annieforchild.entity.StudentBean;
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
    public Observable<BaseResponse<VcodeBean>> getVerificationCode(String phone, String username, int type) {
        return service.getVerificationCode(phone, username, type);
    }

    @Override
    public Observable<BaseResponse<LoginByCodeBean>> loginByVcode(String phone, int code, int serialNumber) {
        return service.loginByVcode(phone, code, serialNumber);
    }

    @Override
    public Observable<BaseResponse<LoginByCodeBean>> login(String phone, String password) {
        return service.login(phone, password);
    }

    @Override
    public Observable<BaseResponse<ForgetPsdBean>> resetPassword(String phone, int code, String password, int serialNumber) {
        return service.resetPassword(phone, code, password, serialNumber);
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> bindStudent(String username, String phone, int code, int serialNumber) {
        return service.bindStudent(username, phone, code, serialNumber);
    }

    @Override
    public Observable<BaseResponse<HomeData>> getHomeData(String username) {
        return service.getHomeData(username);
    }

    @Override
    public Observable<BaseResponse<StudentBean>> getStudent(int age, String name) {
        return null;
    }



}
