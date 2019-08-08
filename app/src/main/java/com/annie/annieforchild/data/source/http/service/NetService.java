package com.annie.annieforchild.data.source.http.service;

import com.annie.annieforchild.entity.DemoEntity;
import com.annie.annieforchild.entity.LoginByCodeBean;
import com.annie.annieforchild.entity.VcodeBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetService {
    @FormUrlEncoded
    @POST("System/getVerificationCode")
    Observable<BaseResponse<VcodeBean>> getVerificationCode(@Field("phone") String phone, @Field("type") int type);

    @FormUrlEncoded
    @POST("System/loginByCode")
    Observable<BaseResponse<LoginByCodeBean>> loginByVcode(@Field("phone") String phone, @Field("code") int code, @Field("serialNumber") int serialNumber);

    @FormUrlEncoded
    @POST("System/login")
    Observable<BaseResponse<LoginByCodeBean>> login(@Field("phone") String phone, @Field("password") String password);
}
