package com.annie.annieforchild.data;

import android.support.annotation.NonNull;

import com.annie.annieforchild.data.source.http.HttpDataSource;
import com.annie.annieforchild.data.source.local.LocalDataSource;
import com.annie.annieforchild.entity.LoginByCodeBean;
import com.annie.annieforchild.entity.VcodeBean;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.http.BaseResponse;

public class DemoRepository extends BaseModel implements HttpDataSource, LocalDataSource {
    private volatile static DemoRepository INSTANCE = null;
    private HttpDataSource httpDataSource;
    private LocalDataSource localDataSource;

    public DemoRepository(@NonNull HttpDataSource httpDataSource, @NonNull LocalDataSource localDataSource) {
        this.httpDataSource = httpDataSource;
        this.localDataSource = localDataSource;
    }

    public static DemoRepository getInstance(HttpDataSource httpDataSource, LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (DemoRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DemoRepository(httpDataSource, localDataSource);
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public void toTaobao(String url) {
        localDataSource.toTaobao(url);
    }

    @Override
    public Observable<Object> guide() {
        return httpDataSource.guide();
    }

    @Override
    public Observable<BaseResponse<VcodeBean>> getVerificationCode(String phone, int type) {
        return httpDataSource.getVerificationCode(phone, type);
    }

    @Override
    public Observable<BaseResponse<LoginByCodeBean>> loginByVcode(String phone, int code, int serialNumber) {
        return httpDataSource.loginByVcode(phone, code, serialNumber);
    }

    @Override
    public Observable<BaseResponse<LoginByCodeBean>> login(String phone, String password) {
        return httpDataSource.login(phone, password);
    }
}
