package com.privatee.wjtbaseapp.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：测试板子开关机的
 * Created by WJT on  2018/3/7 09:17.
 */

public class SytemSetActivity extends BaseActivity{
    private TextView text_showtime;
    private Button set_button;
    @Override
    public String setNowActivityName() {
        return "测试板子开关机的";
    }

    @Override
    public int setLayout() {
        return R.layout.system_layout;
    }

    @Override
    public void inintView() {
        text_showtime=fvbi(R.id.text_showtime);
        set_button=fvbi(R.id.set_button);
        set_button.setOnClickListener(this);
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.set_button:
                Intent intent = new Intent("zysd.alarm.poweroff.time");
                intent.putExtra("poweroffday", "2018-03-07");
                intent.putExtra("powerofftime", "16:22");
                sendBroadcast(intent);

                Intent intent2 = new Intent("zysd.alarm.poweron.time");
                intent2.putExtra("poweronday", "2018-03-07");
                intent2.putExtra("powerontime","16:28");
                sendBroadcast(intent2);
//                text_showtime.setText("关机时间:2018-03-07 09:30    开机时间：2018-03-07 09:36");
//
//                Intent intent = new Intent("reboot.zysd.now");
//                sendBroadcast(intent);
                break;
        }

    }
}
