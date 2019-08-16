package com.annie.annieforchild.ui.login.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.entity.ForgetPsdBean;
import com.annie.annieforchild.entity.VcodeBean;
import com.annie.annieforchild.utils.http.ApiException;
import com.blankj.utilcode.util.RegexUtils;

import io.reactivex.observers.ResourceObserver;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class ForgetPsdViewModel extends BaseViewModel<DemoRepository> {
    public ObservableField<String> phone = new ObservableField<>();
    public ObservableField<String> vcode = new ObservableField<>();
    public ObservableField<String> getVcode = new ObservableField<>();
    public ObservableField<String> psd = new ObservableField<>();
    public ObservableField<String> confirmPsd = new ObservableField<>();

    private int serialNumber;
    public ForgetPsdViewModel.UIChangeObservable uc = new ForgetPsdViewModel.UIChangeObservable();

    public ForgetPsdViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
        getVcode.set("获取验证码");
    }

    public class UIChangeObservable {
        //验证码点击
        public SingleLiveEvent<Boolean> pVcodeEvent = new SingleLiveEvent<>();
    }

    /**
     * 获取验证码
     */
    public BindingCommand onGetVcodeClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (TextUtils.isEmpty(phone.get())) {
                ToastUtils.showShort("请输入手机号！");
                return;
            }
            if (!RegexUtils.isMobileSimple(phone.get())) {
                ToastUtils.showShort("输入手机号有误！");
                return;
            }
            uc.pVcodeEvent.setValue(uc.pVcodeEvent.getValue() == null || !uc.pVcodeEvent.getValue());
            model.getVerificationCode(phone.get(), "", 2)
                    .compose(RxUtils.<BaseResponse<VcodeBean>>bindToLifecycle(getLifecycleProvider()))
                    .compose(RxUtils.schedulersTransformer())
                    .compose(RxUtils.exceptionTransformer())
                    .subscribe(new ResourceObserver<BaseResponse<VcodeBean>>() {
                        @Override
                        public void onNext(BaseResponse<VcodeBean> baseResponse) {
                            serialNumber = baseResponse.getData().getSerialNumber();
                            ToastUtils.showShort(baseResponse.getMsg());
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

    /**
     * 忘记密码提交
     */
    public BindingCommand onForgetPsdClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (!psd.get().equals(confirmPsd.get())) {
                ToastUtils.showShort("两次输入密码不一致！");
                return;
            }
            model.resetPassword(phone.get(), Integer.parseInt(vcode.get()), psd.get(), serialNumber)
                    .compose(RxUtils.<BaseResponse<ForgetPsdBean>>bindToLifecycle(getLifecycleProvider()))
                    .compose(RxUtils.schedulersTransformer())
                    .compose(RxUtils.exceptionTransformer())
                    .subscribe(new ResourceObserver<BaseResponse<ForgetPsdBean>>() {
                        @Override
                        public void onNext(BaseResponse<ForgetPsdBean> baseResponse) {
                            ToastUtils.showShort(baseResponse.getMsg());
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
}
