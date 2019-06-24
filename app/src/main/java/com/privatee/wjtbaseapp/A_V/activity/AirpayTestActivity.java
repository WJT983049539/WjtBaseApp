package com.privatee.wjtbaseapp.A_V.activity;

import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * 支付宝支付测试
 * @auther wjt
 * @date 2019/6/18
 */
public class AirpayTestActivity extends BaseActivity {
    @Override
    public String setNowActivityName() {
        return "支付";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_airplay;
    }

    @Override
    public void inintView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
        //线程中显示Toast
                // Looper.myLooper()：获取当前进程的looper对象
               //Looper().quit() loop循环中止
                Looper.prepare();//启用当前线程的Looper
                Toast.makeText(AirpayTestActivity.this, "线程中显示Toast", Toast.LENGTH_SHORT).show();
                Looper.loop();//让Looper开始工作，从消息队列中取消息，处理消息
            }
        }).start();
    }

    @Override
    public void inintData() {
    /**
    Looper.prepare() 初始化消息队列、
     之后调用Looper.myLooper()获取此Looper对象的引用
     在run()方法中添加Handler来处理消息
     添加Looper.loop()调用，这是让线程的消息队列开始运行，可以接收消息了。
     在想要退出消息循环时，调用Looper.quit()注意，这个方法是要在对象上面调用，很明显，用对象的意思就是要退出具体哪个Looper。如果run()中无其他操作，线程也将终止运行。
     */
    }

    @Override
    public void onClick(View v) {

    }
}
