package com.annie.annieforchild;

import android.os.Build;

import com.annie.annieforchild.data.DemoRepository;
import com.annie.annieforchild.data.source.http.HttpDataSource;
import com.annie.annieforchild.data.source.http.HttpDataSourceImpl;
import com.annie.annieforchild.data.source.http.service.NetService;
import com.annie.annieforchild.data.source.local.LocalDataSource;
import com.annie.annieforchild.data.source.local.LocalDataSourceImpl;
import com.annie.annieforchild.utils.RetrofitClient;
import com.blankj.utilcode.util.AppUtils;

/**
 * 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构而架构）
 * Created by goldze on 2019/3/26.
 */
public class Injection {
    public static DemoRepository provideDemoRepository() {
        //网络API服务
        RetrofitClient client = RetrofitClient.getInstance();
        client.setDeviceID(Build.SERIAL);
        client.setAppVersion(AppUtils.getAppVersionName());
        NetService apiService = client.initRetrofit().create(NetService.class);
        //网络数据源
        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance(apiService);
        //本地数据源
        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return DemoRepository.getInstance(httpDataSource, localDataSource);
    }
}
