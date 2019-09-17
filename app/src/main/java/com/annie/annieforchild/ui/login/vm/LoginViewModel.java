package com.annie.annieforchild.ui.login.vm;

import android.app.Application;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.entity.LoginByCodeBean;
import com.annie.annieforchild.ui.login.activity.AddStudentActivity;
import com.annie.annieforchild.ui.login.activity.ForgetPsdActivity;
import com.annie.annieforchild.ui.main.activity.MainActivity;
import com.annie.annieforchild.utils.http.ApiException;
import com.blankj.utilcode.util.RegexUtils;

import io.reactivex.observers.ResourceObserver;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class LoginViewModel extends BaseViewModel<DemoRepository> {
    public ObservableField<String> phone = new ObservableField<>();
    public ObservableField<String> psd = new ObservableField<>();

    public LoginViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
        phone.set(model.getPhone());
        psd.set(model.getPassword());
    }

    /**
     * 登陆
     */
    public BindingCommand onLoginClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

            if (!RegexUtils.isMobileSimple(phone.get())) {
                ToastUtils.showShort("输入手机号有误！");
                return;
            }
            model.login(phone.get(), psd.get())
                    .compose(RxUtils.<BaseResponse<LoginByCodeBean>>bindToLifecycle(getLifecycleProvider()))
                    .compose(RxUtils.schedulersTransformer())
                    .compose(RxUtils.exceptionTransformer())
                    .subscribe(new ResourceObserver<BaseResponse<LoginByCodeBean>>() {
                        @Override
                        public void onNext(BaseResponse<LoginByCodeBean> baseResponse) {
                            model.savePhone(phone.get());
                            model.savePassword(psd.get());
                            ToastUtils.showShort(baseResponse.getMsg());
//                            startActivity(AddStudentActivity.class);
                            LoginByCodeBean data = baseResponse.getData();
                            String defaultUsername = data.getDefaultUsername();
                            String token = data.getToken();

//                            model.saveToken(token);
                            startActivity(MainActivity.class);
                            finish();
                        }

                        @Override
                        public void onError(Throwable e) {
                            ApiException apiException = (ApiException) e.getCause();
                            ToastUtils.showShort(apiException.getMessage() + apiException.getErrorCode());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    });

    public BindingCommand onForgetPsdClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(ForgetPsdActivity.class);
        }
    });

}
