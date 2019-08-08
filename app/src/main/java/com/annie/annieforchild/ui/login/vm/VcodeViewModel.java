package com.annie.annieforchild.ui.login.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.entity.LoginByCodeBean;
import com.annie.annieforchild.entity.VcodeBean;
import com.annie.annieforchild.ui.main.activity.MainActivity;
import com.blankj.utilcode.util.RegexUtils;

import java.util.Observable;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class VcodeViewModel extends BaseViewModel<DemoRepository> {
    public ObservableField<String> phone = new ObservableField<>();
    public ObservableField<String> vcode = new ObservableField<>();
    public ObservableField<String> getVcode = new ObservableField<>();
    private int serialNumber;
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        //验证码点击
        public SingleLiveEvent<Boolean> pVcodeEvent = new SingleLiveEvent<>();
    }

    public VcodeViewModel(@NonNull Application application) {
        super(application);
    }

    public VcodeViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
        getVcode.set("获取验证码");
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
            model.getVerificationCode(phone.get(), 1)
                    .compose(RxUtils.<BaseResponse<VcodeBean>>bindToLifecycle(getLifecycleProvider()))
                    .compose(RxUtils.schedulersTransformer())
                    .compose(RxUtils.exceptionTransformer())
                    .subscribe(new Consumer<BaseResponse<VcodeBean>>() {
                        @Override
                        public void accept(BaseResponse<VcodeBean> baseResponse) throws Exception {
                            if (baseResponse.getData() != null) {
                                serialNumber = baseResponse.getData().getSerialNumber();
                            }
                            ToastUtils.showShort(baseResponse.getMsg());
                        }
                    });
        }
    });

    /**
     * 登录（验证码）
     */
    public BindingCommand onLoginByVcodeClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            model.loginByVcode(phone.get(), Integer.parseInt(vcode.get().trim()), serialNumber)
                    .compose(RxUtils.<BaseResponse<LoginByCodeBean>>bindToLifecycle(getLifecycleProvider()))
                    .compose(RxUtils.schedulersTransformer())
                    .compose(RxUtils.exceptionTransformer())
                    .subscribe(new Consumer<BaseResponse<LoginByCodeBean>>() {
                        @Override
                        public void accept(BaseResponse<LoginByCodeBean> baseResponse) throws Exception {
                            ToastUtils.showShort(baseResponse.getMsg());
                            if (baseResponse.getStatus() == 0) {
                                startActivity(MainActivity.class);
                                finish();
                            } else {

                            }
                        }
                    });
        }
    });
}
