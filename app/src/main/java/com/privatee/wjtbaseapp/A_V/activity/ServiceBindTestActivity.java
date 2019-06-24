package com.privatee.wjtbaseapp.A_V.activity;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.Base.CompatibilityBaseActivity;
import com.privatee.wjtbaseapp.R;
import com.privatee.wjtbaseapp.service.MyTestService;

import service_aldl.AIDL_Service1;

/**
 * Service练习
 * @auther wjt
 * @date 2019/4/23
 */
public class ServiceBindTestActivity extends BaseActivity {
    Button bindservice_button;
    Button unbindservice_button;
    //定义aidl接口变量
    private AIDL_Service1 mAIDL_Service;

    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.layout_service_bind_test;
    }

    @Override
    public void inintView() {
        bindservice_button=fvbi(R.id.bindservice_button);
        unbindservice_button=fvbi(R.id.unbindservice_button);
        bindservice_button.setOnClickListener(this);
        unbindservice_button.setOnClickListener(this);
    }

    @Override
    public void inintData() {
        //创建ServiceConnect连接类

    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){

        case R.id.bindservice_button:
            //构建绑定服务的Intent对象
//            Intent bindIntent = new Intent(this, MyTestService.class);
//            //调用bindService()方法,以此停止服务
//
//            bindService(bindIntent,connection,BIND_AUTO_CREATE);
            //参数说明
            //第一个参数:Intent对象
            //第二个参数:上面创建的Serviceconnection实例
            //第三个参数:标志位
            //这里传入BIND_AUTO_CREATE表示在Activity和Service建立关联后自动创建Service
            //这会使得MyService中的onCreate()方法得到执行，但onStartCommand()方法不会执行

            //绑定远程服务
            //通过Intent指定服务端的服务名称和所在包，与远程Service进行绑定
            //参数与服务器端的action要一致,即"服务器包名.aidl接口文件名"
            Intent intent=new Intent("service_aldl.AIDL_Service1");
            //Android5.0后无法只通过隐式Intent绑定远程Service
            //需要通过setPackage()方法指定包名
            intent.setPackage("service_aldl");
            //绑定服务,传入intent和ServiceConnection对象
            bindService(intent, connection, Context.BIND_AUTO_CREATE);

            break;
        case R.id.unbindservice_button:
            unbindService(connection);

            break;

    }
    }
    //创建ServiceConnection的匿名类
    private ServiceConnection connection=new ServiceConnection() {
        //在与Activity和Service解绑的时候调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //使用AIDLService1.Stub.asInterface()方法获取服务器端返回的IBinder对象
            //将IBinder对象传换成了mAIDL_Service接口对象
            mAIDL_Service= AIDL_Service1.Stub.asInterface(service);

            //通过该对象调用在MyAIDLService.aidl文件中定义的接口方法,从而实现跨进程通信
            try {
                mAIDL_Service.AIDL_Service("往服务端发送测试一哈");
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }
        //在与Activity和service解绑的时候调用
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
