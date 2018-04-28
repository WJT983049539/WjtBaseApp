package com.privatee.wjtbaseapp;

import android.app.Application;

import com.github.moduth.blockcanary.BlockCanary;
import com.liulishuo.filedownloader.FileDownloader;
import com.privatee.mylibrary.Base.BaseAndroid;
import com.privatee.mylibrary.Base.BaseConfig;
import com.privatee.mylibrary.utils.AppBlockCanaryContext;


/**
 * 类的作用：
 * Created by WJT on  2017/12/19 09:52.
 */

public class BaseAppaction extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        BaseConfig baseConfig=new BaseConfig();
        baseConfig.setIsTitle(false);
        BaseAndroid.init(baseConfig);
        //初始化下载器
        FileDownloader.init(getApplicationContext());

        //初始化oomlog配置信息
        BlockCanary.install(this, new AppBlockCanaryContext());
}
}
