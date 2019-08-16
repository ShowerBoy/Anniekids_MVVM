package com.annie.annieforchild.data.source.http.service;

import com.annie.annieforchild.entity.DemoEntity;
import com.annie.annieforchild.entity.ForgetPsdBean;
import com.annie.annieforchild.entity.HomeData;
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
    Observable<BaseResponse<VcodeBean>> getVerificationCode(@Field("phone") String phone, @Field("username") String username, @Field("type") int type);

    @FormUrlEncoded
    @POST("System/loginByCode")
    Observable<BaseResponse<LoginByCodeBean>> loginByVcode(@Field("phone") String phone, @Field("code") int code, @Field("serialNumber") int serialNumber);

    @FormUrlEncoded
    @POST("System/login")
    Observable<BaseResponse<LoginByCodeBean>> login(@Field("phone") String phone, @Field("password") String password);

    @FormUrlEncoded
    @POST("System/resetPassword")
    Observable<BaseResponse<ForgetPsdBean>> resetPassword(@Field("phone") String phone, @Field("code") int code, @Field("password") String password, @Field("serialNumber") int serialNumber);

    @FormUrlEncoded
    @POST("System/bindStudent")
    Observable<BaseResponse<DemoEntity>> bindStudent(@Field("username") String username, @Field("phone") String phone, @Field("code") int code, @Field("serialNumber") int serialNumber);

    @FormUrlEncoded
    @POST("System/getHomeData")
    Observable<BaseResponse<HomeData>> getHomeData(@Field("username") String username);
}
