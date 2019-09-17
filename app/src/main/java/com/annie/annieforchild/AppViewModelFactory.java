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
import com.annie.annieforchild.ui.main.vm.AllSearchViewModel;
import com.annie.annieforchild.ui.main.vm.AnimationListViewModel;
import com.annie.annieforchild.ui.main.vm.BankBookViewModel;
import com.annie.annieforchild.ui.main.vm.BridgeBookVieModel;
import com.annie.annieforchild.ui.main.vm.ChapterBookViewModel;
import com.annie.annieforchild.ui.main.vm.ClassTypeViewModel;
import com.annie.annieforchild.ui.main.vm.EarListViewModel;
import com.annie.annieforchild.ui.main.vm.GradedReaderViewModel;
import com.annie.annieforchild.ui.main.vm.GuideViewModel;
import com.annie.annieforchild.ui.login.vm.LoginViewModel;
import com.annie.annieforchild.ui.login.vm.VcodeViewModel;
import com.annie.annieforchild.ui.main.vm.HomeEarViewModel;
import com.annie.annieforchild.ui.main.vm.HomeGridViewModel;
import com.annie.annieforchild.ui.main.vm.HomeLoopViewModel;
import com.annie.annieforchild.ui.main.vm.HomeReadViewModel;
import com.annie.annieforchild.ui.main.vm.HomeSpeakViewModel;
import com.annie.annieforchild.ui.main.vm.HomepageViewModel;
import com.annie.annieforchild.ui.main.vm.LabelListViewModel;
import com.annie.annieforchild.ui.main.vm.PictureBookViewModel;
import com.annie.annieforchild.ui.main.vm.SearchEarViewModel;
import com.annie.annieforchild.ui.main.vm.SearchReadViewModel;
import com.annie.annieforchild.ui.main.vm.SearchSpeakViewModel;
import com.annie.annieforchild.ui.main.vm.SearchViewModel;
import com.annie.annieforchild.ui.main.vm.SortSearchViewModel;
import com.annie.annieforchild.ui.main.vm.SquareViewModel;
import com.annie.annieforchild.ui.main.vm.NotificationViewModel;
import com.annie.annieforchild.ui.main.vm.ReadListViewModel;
import com.annie.annieforchild.ui.main.vm.RecommendViewModel;
import com.annie.annieforchild.ui.main.vm.SpeakListViewModel;

import net.lucode.hackware.magicindicator.MagicIndicator;

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
    public static AppViewModelFactory destroyInstance(Application application) {
        INSTANCE = null;
        return null;
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
        }else if (modelClass.isAssignableFrom(ClassTypeViewModel.class)){
            return (T) new ClassTypeViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(NotificationViewModel.class)){
            return (T) new NotificationViewModel(mApplication,mRepository);
        }else  if (modelClass.isAssignableFrom(BankBookViewModel.class)){
            return (T) new BankBookViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(SquareViewModel.class)){
            return  (T) new SquareViewModel(mApplication,mRepository);
        }else  if (modelClass.isAssignableFrom(HomeEarViewModel.class)){
            return (T) new HomeEarViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(HomeReadViewModel.class)){
            return (T) new HomeReadViewModel(mApplication,mRepository);
        }else  if (modelClass.isAssignableFrom(HomeSpeakViewModel.class)){
            return (T) new HomeSpeakViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(EarListViewModel.class)){
            return (T) new EarListViewModel(mApplication,mRepository);
        }else  if (modelClass.isAssignableFrom(ReadListViewModel.class)){
            return (T) new ReadListViewModel(mApplication,mRepository);
        }else  if (modelClass.isAssignableFrom(SpeakListViewModel.class)){
            return (T) new SpeakListViewModel(mApplication,mRepository);
        }else  if (modelClass.isAssignableFrom(AnimationListViewModel.class)){
            return (T) new AnimationListViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(PictureBookViewModel.class)){
            return (T) new PictureBookViewModel(mApplication,mRepository);
        }else  if (modelClass.isAssignableFrom(GradedReaderViewModel.class)){
            return (T) new GradedReaderViewModel(mApplication,mRepository);
        }else  if (modelClass.isAssignableFrom(ChapterBookViewModel.class)){
            return  (T) new ChapterBookViewModel(mApplication,mRepository);
        }else  if (modelClass.isAssignableFrom(BridgeBookVieModel.class)){
            return  (T) new BridgeBookVieModel(mApplication,mRepository);
        } else if (modelClass.isAssignableFrom(SearchViewModel.class)){
            return  (T) new SearchViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(SortSearchViewModel.class)){
            return (T) new SortSearchViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(AllSearchViewModel.class)){
            return (T) new AllSearchViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(SearchEarViewModel.class)){
            return (T) new SearchEarViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(SearchReadViewModel.class)){
            return (T) new SearchReadViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(SearchSpeakViewModel.class)){
            return (T) new SearchSpeakViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(HomeLoopViewModel.class)){
            return (T)  new HomeLoopViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(HomeGridViewModel.class)){
            return (T) new HomeGridViewModel(mApplication,mRepository);
        }else if (modelClass.isAssignableFrom(LabelListViewModel.class)){
            return  (T)  new LabelListViewModel(mApplication,mRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
