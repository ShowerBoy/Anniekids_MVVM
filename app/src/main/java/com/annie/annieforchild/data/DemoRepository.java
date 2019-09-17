package com.annie.annieforchild.data;

import android.support.annotation.NonNull;

import com.annie.annieforchild.data.source.http.HttpDataSource;
import com.annie.annieforchild.data.source.local.LocalDataSource;
import com.annie.annieforchild.entity.Banner;
import com.annie.annieforchild.entity.DemoEntity;
import com.annie.annieforchild.entity.ForgetPsdBean;
import com.annie.annieforchild.entity.HomeData;
import com.annie.annieforchild.entity.LoginByCodeBean;
import com.annie.annieforchild.entity.PictureBookBean;
import com.annie.annieforchild.entity.SortSearchBean;
import com.annie.annieforchild.entity.StudentBean;
import com.annie.annieforchild.entity.VcodeBean;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
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
    public void savePhone(String phone) {
        localDataSource.savePhone(phone);
    }

    @Override
    public void savePassword(String password) {
        localDataSource.savePassword(password);
    }
    @Override
    public void saveToken(String token) {
        localDataSource.saveToken(token);
    }

    @Override
    public String getToken() {
        return localDataSource.getToken();
    }


    @Override
    public String getPhone() {
        return localDataSource.getPhone();
    }

    @Override
    public String getPassword() {
        return localDataSource.getPassword();
    }

    @Override
    public Observable<Object> guide() {
        return httpDataSource.guide();
    }


    @Override
    public Observable<BaseResponse<VcodeBean>> getVerificationCode(String phone, String username, int type) {
        return httpDataSource.getVerificationCode(phone, username, type);
    }

    @Override
    public Observable<BaseResponse<LoginByCodeBean>> loginByVcode(String phone, int code, int serialNumber) {
        return httpDataSource.loginByVcode(phone, code, serialNumber);
    }

    @Override
    public Observable<BaseResponse<LoginByCodeBean>> login(String phone, String password) {
        return httpDataSource.login(phone, password);
    }

    @Override
    public Observable<BaseResponse<ForgetPsdBean>> resetPassword(String phone, int code, String password, int serialNumber) {
        return httpDataSource.resetPassword(phone, code, password, serialNumber);
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> bindStudent(String username, String phone, int code, int serialNumber) {
        return httpDataSource.bindStudent(username, phone, code, serialNumber);
    }


    @Override
    public Observable<BaseResponse<HomeData>> getHomeData(String username) {
        return httpDataSource.getHomeData(username);
    }

    @Override
    public Observable<BaseResponse<StudentBean>> getStudent(int age, String name) {
        return httpDataSource.getStudent(age,name);
    }

//    @Override
//    public Observable<BaseResponse<SortSearchBean>> getSortTypeList(String keyword, int page, int type) {
//        return httpDataSource.getSortTypeList(keyword,page,type);
//    }


}
