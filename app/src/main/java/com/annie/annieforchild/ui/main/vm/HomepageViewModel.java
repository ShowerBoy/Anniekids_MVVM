package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.ui.adapter.MultiAnimViewModel;
import com.annie.annieforchild.ui.login.vm.AddStuViewModel;

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


}
