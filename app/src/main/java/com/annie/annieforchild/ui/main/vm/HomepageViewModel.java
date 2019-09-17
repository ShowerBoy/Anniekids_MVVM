package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.entity.HomeBean;
import com.annie.annieforchild.ui.adapter.MultiAnimViewModel;
import com.annie.annieforchild.ui.login.vm.AddStuViewModel;
import com.blankj.utilcode.util.AppUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

public class HomepageViewModel extends BaseViewModel<DemoRepository> {
    private static final String RecyclerType_Content = "content";
    public ObservableList<MultiItemViewModel> observableList = new ObservableArrayList<>();
    public final MutableLiveData<List> listData = new MutableLiveData<>();


    public HomepageViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
        for (int i = 0; i < 10; i++) {
            MultiItemViewModel item = new MultiAnimViewModel(this, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565934997403&di=323e49fea8f5a35730589fb4c4a503dd&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ff603918fa0ec08fa3139e00153ee3d6d55fbda5f.jpg");
            item.multiItemType(RecyclerType_Content);
            observableList.add(item);
        }
    }


    public ItemBinding<MultiItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<MultiItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, MultiItemViewModel item) {
            String itemType = (String) item.getItemType();
            if (RecyclerType_Content.equals(itemType)) {
                itemBinding.set(BR.viewModel, R.layout.item_multi_content);
            }
        }
    });



    public void getData(String url){
        Map map = new HashMap<String ,String>();
        map.put("username" , "100506729");
        map.put("token" , model.getToken());
        map.put("deviceType" , "android");
        map.put("deviceID" , Build.SERIAL);
        map.put("appVersion" , AppUtils.getAppVersionName());

        OkGo.<String>post(url)
                .tag(this)
                .headers("apiKey" , "YW5uaWVraWRzQXBp")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body().toString();
                        Log.i("body" , body);
                        if (!TextUtils.isEmpty(body)){
                            Gson gson = new Gson();
                            HomeBean homeBeanTwo = gson.fromJson(body, HomeBean.class);
                            List homeList = new ArrayList();
                            if (null != homeBeanTwo){
                                HomeBean.DataBean data = homeBeanTwo.getData();
                                if (null != data){
                                    List<HomeBean.DataBean.AnimationBean> animation = data.getAnimation();
                                    List<HomeBean.DataBean.BannerBean> banner = data.getBanner();
                                    List<HomeBean.DataBean.LabelBean> label = data.getLabel();
                                    HomeBean.DataBean.RecommendBean recommend = data.getRecommend();
                                    List<HomeBean.DataBean.ResourceBean> resource = data.getResource();
                                    if (null != banner){
                                        homeList.add(banner);
                                    }
                                    homeList.add(new Object());
                                    if (null != recommend){
                                        homeList.add(recommend);
                                    }
                                    if (null != animation){
                                        homeList.add(animation);
                                    }
                                    if (null != label){
                                        homeList.add(label);
                                    }
                                    for (int i = 0; i < resource.size(); i++) {
                                        homeList.add(resource.get(i));
                                    }
                                    listData.setValue(homeList);
                                }
                            }
                        }

                    }
                });


    }



}
