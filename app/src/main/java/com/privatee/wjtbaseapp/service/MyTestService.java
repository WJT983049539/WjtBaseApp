package com.privatee.wjtbaseapp.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;

import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.wjtbaseapp.Activity.MainActivity;
import com.privatee.wjtbaseapp.R;

/**
 * @auther wjt
 * @date 2019/4/23
 */
public class MyTestService extends Service {
    private MyBinder myBinder=new MyBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        TaoTools.i("执行了MyTestService的onBind方法");
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
       TaoTools.i("执行了MyTestService的OnCreate()方法");
        //添加下列代码将后台Service变成前台Service
        //构建"点击通知后打开MainActivity"的Intent对象
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);

        //新建Builer对象
        Notification.Builder builer = new Notification.Builder(this);
        builer.setContentTitle("前台服务通知的标题");//设置通知的标题
        builer.setContentText("前台服务通知的内容");//设置通知的内容
        builer.setSmallIcon(R.mipmap.ic_launcher);//设置通知的图标
        builer.setContentIntent(pendingIntent);//设置点击通知后的操作

        Notification notification = builer.getNotification();//将Builder对象转变成普通的notification
        startForeground(1, notification);//让Service变成前台Service,并在系统的状态栏显示出来
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        TaoTools.i("执行了MyTestService的onStartCommand方法");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TaoTools.i("执行了MyTestService的onDestroy方法");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        TaoTools.i("执行了MyTestService的onUnbind方法");
        return super.onUnbind(intent);

    }

    /**
     * 新建一个类继承Binder
     */
    private class MyBinder extends Binder {
        public void Service_connect_Activity(){
            TaoTools.i("Service关联了Activity,并在Activity执行了Service的方法");
        }
    }
}
