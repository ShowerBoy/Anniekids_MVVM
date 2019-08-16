package com.annie.annieforchild.ui.adapter;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.annie.annieforchild.ui.main.vm.HomepageViewModel;
import com.bumptech.glide.Glide;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class MultiAnimViewModel extends MultiItemViewModel<HomepageViewModel> {
    public ObservableField<String> image = new ObservableField<>("");

    public MultiAnimViewModel(@NonNull HomepageViewModel viewModel, String url) {
        super(viewModel);
        this.image.set(url);
    }

    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            int position = viewModel.observableList.indexOf(MultiAnimViewModel.this);

            ToastUtils.showShort("position：" + position);
        }
    });
}
