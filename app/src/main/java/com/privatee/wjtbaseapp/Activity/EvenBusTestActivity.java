package com.privatee.wjtbaseapp.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.wjtbaseapp.Bean.ProgressMessage;
import com.privatee.wjtbaseapp.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 类的作用：evenbus
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/26 09:42.
 */
public class  EvenBusTestActivity extends BaseActivity{
    private TextView tv_message;
    private Button bt_message;
    private ProgressBar testprogressBar;
    public int time = 0;
    @Override
    public String setNowActivityName() {
        return "evenbus";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_evenbus;
    }

    @Override
    public void inintView() {
        tv_message=fvbi(R.id.tv_message);
        testprogressBar=fvbi(R.id.testprogressBar);
        fvbi(R.id.bt_message).setOnClickListener(this);


    }

    @Override
    public void inintData() {
        //注册事件
        EventBus.getDefault().register(this);
        /**
         * 可以从线程中传出数据到主线程
         */
    }

    @Override
    public void onClick(View v) {
     switch (v.getId()) {
         case R.id.bt_message:
             //转到跳转到mainactivity

//             Intent intent=new Intent(this,WebViewActivity.class);
//             startActivity(intent);
//             break;
             new Thread(new
                                Runnable() {
                 @Override
                 public void run() {
                     while (time <= 100) {
                         time += 5;
                         EventBus.getDefault().post(new ProgressMessage(time));
                         EventBus.getDefault().post("123456");
                         try {
                             Thread.sleep(1000);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 }
             }).start();
     }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册事件
        EventBus.getDefault().unregister(this);
    }

    //接受消息并且处理事件
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(ProgressMessage messageEvent){
        testprogressBar.setMax(100);
        testprogressBar.setProgress(messageEvent.getProcess());
    }
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void Event(String value){
        TaoTools.i(value);
    }
}
