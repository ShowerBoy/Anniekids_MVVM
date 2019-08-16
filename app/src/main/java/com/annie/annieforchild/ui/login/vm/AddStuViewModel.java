package com.annie.annieforchild.ui.login.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.entity.DemoEntity;
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
import me.goldze.mvvmhabit.utils.SPUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class AddStuViewModel extends BaseViewModel<DemoRepository> {
    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> vcode = new ObservableField<>();
    public ObservableField<String> getVcode = new ObservableField<>();

    private int serialNumber;

    public AddStuViewModel.UIChangeObservable uc = new AddStuViewModel.UIChangeObservable();

    public class UIChangeObservable {
        //验证码点击
        public SingleLiveEvent<Boolean> pVcodeEvent = new SingleLiveEvent<>();
    }

    public AddStuViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
        getVcode.set("获取验证码");
    }

    /**
     * 获取验证码
     */
    public BindingCommand onGetVcodeClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (TextUtils.isEmpty(username.get())) {
                ToastUtils.showShort("请输入学员号！");
                return;
            }
            uc.pVcodeEvent.setValue(uc.pVcodeEvent.getValue() == null || !uc.pVcodeEvent.getValue());
            model.getVerificationCode(model.getPhone(), username.get(), 4)
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

    public BindingCommand onBindStuClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            model.bindStudent(username.get(), model.getPhone(), Integer.parseInt(vcode.get()), serialNumber)
                    .compose(RxUtils.<BaseResponse<DemoEntity>>bindToLifecycle(getLifecycleProvider()))
                    .compose(RxUtils.schedulersTransformer())
                    .compose(RxUtils.exceptionTransformer())
                    .subscribe(new ResourceObserver<BaseResponse<DemoEntity>>() {
                        @Override
                        public void onNext(BaseResponse<DemoEntity> baseResponse) {
                            ToastUtils.showShort(baseResponse.getMsg());
                            if (baseResponse.getData().getResult() == 1) {
                                finish();
                            } else {

                            }
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

    public BindingCommand onAddStuClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });

}
