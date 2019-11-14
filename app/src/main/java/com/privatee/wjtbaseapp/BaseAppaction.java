package com.privatee.wjtbaseapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.github.moduth.blockcanary.BlockCanary;
import com.liulishuo.filedownloader.FileDownloader;
import com.ping.greendao.gen.DaoMaster;
import com.ping.greendao.gen.DaoSession;
import com.privatee.mylibrary.Base.BaseAndroid;
import com.privatee.mylibrary.Base.BaseConfig;
import com.privatee.mylibrary.utils.AppBlockCanaryContext;
import com.privatee.mylibrary.utils.CommonData;
import com.privatee.mylibrary.utils.TdialogUtils;
import com.privatee.wjtbaseapp.A_tools.CrashHandler;
import com.privatee.wjtbaseapp.A_tools.GlobalToast;
import com.qw.soul.permission.SoulPermission;

/**
 * 类的作用：
 * 继承 Application.ActivityLifecycleCallbacks 实现保存Activity的唯一性
 * Created by WJT on  2017/12/19 09:52.
 */

public class BaseAppaction extends Application implements Application.ActivityLifecycleCallbacks{
    private static DaoSession daoSession;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(this);//全局收集异常类，并且log储存在本地
        context = getApplicationContext();
        GlobalToast.init(this);//全局Toast初始化
        SoulPermission.init(this);//权限框架初始化
        CommonData.applicationContext = this;
        this.registerActivityLifecycleCallbacks(this);//注册
        DisplayMetrics metric = new DisplayMetrics();
        WindowManager mWindowManager  = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.getDefaultDisplay().getMetrics(metric);
        CommonData.ScreenWidth = metric.widthPixels; // 屏幕宽度（像素）
//        Intent dialogservice = new Intent(this, CommonDialogService.class);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            startForegroundService(dialogservice);
//        } else {
//            startService(dialogservice);
//        }


        BaseConfig baseConfig=new BaseConfig();
        baseConfig.setIsTitle(false);
        BaseAndroid.init(baseConfig);
        //初始化下载器A
        FileDownloader.init(getApplicationContext());
        //初始化oomlog配置信息
        BlockCanary.install(this, new AppBlockCanaryContext());
//            ArcSdkEngine.getInstance().init();
        //配置数据库
        setupDatabase();

}
    public static Context globalContext() {
        return context;
    }

    private void setupDatabase() {
        //创建数据库shop.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取dao对象管理者
        daoSession = daoMaster.newSession();
    }
    public static DaoSession getDaoSessionInstance(){
        return daoSession;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if(activity.getParent()!=null){
            CommonData.mNowContext = activity.getParent();
        }else {
            CommonData.mNowContext = activity;
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        if(activity.getParent()!=null){
            CommonData.mNowContext = activity.getParent();
        }else {
            CommonData.mNowContext = activity;
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
        if(activity.getParent()!=null){
            CommonData.mNowContext = activity.getParent();
        }else {
            CommonData.mNowContext = activity;
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        TdialogUtils.getInstances().cancel();
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
