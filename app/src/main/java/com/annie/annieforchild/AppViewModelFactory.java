package com.annie.annieforchild;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.ui.login.vm.AddStuViewModel;
import com.annie.annieforchild.ui.login.vm.AddStudentViewModel;
import com.annie.annieforchild.ui.login.vm.ForgetPsdViewModel;
import com.annie.annieforchild.ui.main.vm.GuideViewModel;
import com.annie.annieforchild.ui.login.vm.LoginViewModel;
import com.annie.annieforchild.ui.login.vm.VcodeViewModel;
import com.annie.annieforchild.ui.main.vm.HomepageViewModel;
import com.annie.annieforchild.ui.main.vm.RecommendViewModel;

/**
 * Created by goldze on 2019/3/26.
 */
public class AppViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile AppViewModelFactory INSTANCE;
    private final Application mApplication;
    private final DemoRepository mRepository;

    public static AppViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (AppViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppViewModelFactory(application, Injection.provideDemoRepository());
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    private AppViewModelFactory(Application application, DemoRepository repository) {
        this.mApplication = application;
        this.mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(GuideViewModel.class)) {
            return (T) new GuideViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(VcodeViewModel.class)) {
            return (T) new VcodeViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(ForgetPsdViewModel.class)) {
            return (T) new ForgetPsdViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(AddStudentViewModel.class)) {
            return (T) new AddStudentViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(AddStuViewModel.class)) {
            return (T) new AddStuViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(HomepageViewModel.class)) {
            return (T) new HomepageViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(RecommendViewModel.class)) {
            return (T) new RecommendViewModel(mApplication, mRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
