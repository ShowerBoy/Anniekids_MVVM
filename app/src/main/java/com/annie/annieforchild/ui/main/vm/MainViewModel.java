package com.annie.annieforchild.ui.main.vm;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.annie.annieforchild.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class MainViewModel extends BaseViewModel<DemoRepository> {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean checkPackage(String packageName) {
        if (packageName == null || "".equals(packageName)) {
            return false;
        } else {
            this.getApplication().getApplicationInfo();
//            this.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        }
    }

    public void totianmao(String tbPath) {
        Intent intent = new Intent();
        intent.setAction("Android.intent.action.VIEW");
        Uri uri = Uri.parse(tbPath); // 商品地址
        intent.setData(uri);
        intent.setClassName("com.taobao.taobao", "com.taobao.tao.detail.activity.DetailActivity");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().getApplicationContext().startActivity(intent);
    }

    public BindingCommand onClickCommend = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (checkPackage("com.taobao.taobao")) {
//                mainInterface.toTaobao("https://item.taobao.com/item.htm?spm=a211er.10412184.883541.2.4c182426P3enK3&id=591366421826&scm=1007.12144.81309.69673_0_0&pvid=61ce276d-546d-4153-87eb-3e22a9e7abb7&utparam=%7B%22x_hestia_source%22%3A%2269673%22%2C%22x_object_type%22%3A%22item%22%2C%22x_mt%22%3A8%2C%22x_src%22%3A%2269673%22%2C%22x_pos%22%3A2%2C%22x_pvid%22%3A%2261ce276d-546d-4153-87eb-3e22a9e7abb7%22%2C%22x_object_id%22%3A591366421826%7D");
                totianmao("https://item.taobao.com/item.htm?spm=a211er.10412184.883541.2.4c182426P3enK3&id=591366421826&scm=1007.12144.81309.69673_0_0&pvid=61ce276d-546d-4153-87eb-3e22a9e7abb7&utparam=%7B%22x_hestia_source%22%3A%2269673%22%2C%22x_object_type%22%3A%22item%22%2C%22x_mt%22%3A8%2C%22x_src%22%3A%2269673%22%2C%22x_pos%22%3A2%2C%22x_pvid%22%3A%2261ce276d-546d-4153-87eb-3e22a9e7abb7%22%2C%22x_object_id%22%3A591366421826%7D");
            } else {
                ToastUtils.showShort("没有找到淘宝app");
            }
        }
    });
}
