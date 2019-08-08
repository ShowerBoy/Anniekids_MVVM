package com.annie.annieforchild.ui;

import android.app.Application;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.ui.login.activity.LoginActivity;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.RxUtils;

public class GuideViewModel extends BaseViewModel<DemoRepository> {

    public GuideViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

    public void guide() {
        addSubscribe(model.guide()
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        startActivity(LoginActivity.class);
                        finish();
                    }
                }));
    }
}
