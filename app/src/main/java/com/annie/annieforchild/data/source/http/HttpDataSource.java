package com.annie.annieforchild.data.source.http;

import android.databinding.ObservableField;

import com.annie.annieforchild.entity.DemoEntity;
import com.annie.annieforchild.entity.ForgetPsdBean;
import com.annie.annieforchild.entity.HomeData;
import com.annie.annieforchild.entity.LoginByCodeBean;
import com.annie.annieforchild.entity.VcodeBean;

import io.reactivex.Observable;
import io.reactivex.internal.operators.observable.ObservableError;
import me.goldze.mvvmhabit.http.BaseResponse;

public interface HttpDataSource {
    Observable<Object> guide();

    Observable<BaseResponse<VcodeBean>> getVerificationCode(String phone, String username, int type);

    Observable<BaseResponse<LoginByCodeBean>> loginByVcode(String phone, int code, int serialNumber);

    Observable<BaseResponse<LoginByCodeBean>> login(String phone, String password);

    Observable<BaseResponse<ForgetPsdBean>> resetPassword(String phone, int code, String password, int serialNumber);

    Observable<BaseResponse<DemoEntity>> bindStudent(String username, String phone, int code, int serialNumber);

    Observable<BaseResponse<HomeData>> getHomeData(String username);
}
