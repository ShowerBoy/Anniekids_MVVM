package com.annie.annieforchild.data.source.http;

import android.databinding.ObservableField;

import com.annie.annieforchild.entity.LoginByCodeBean;
import com.annie.annieforchild.entity.VcodeBean;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

public interface HttpDataSource {
    Observable<Object> guide();

    Observable<BaseResponse<VcodeBean>> getVerificationCode(String phone, int type);

    Observable<BaseResponse<LoginByCodeBean>> loginByVcode(String phone, int code, int serialNumber);

    Observable<BaseResponse<LoginByCodeBean>> login( String phone,  String password);
}
