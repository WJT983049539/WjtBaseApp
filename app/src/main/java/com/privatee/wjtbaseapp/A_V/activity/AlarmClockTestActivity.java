package com.privatee.wjtbaseapp.A_V.activity;

import android.app.AlarmManager;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

import java.util.Calendar;

/**
 * 闹钟测试
 */
public class AlarmClockTestActivity extends BaseActivity {
    private Button button_alarm;
    private Calendar calendar;

    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.activity_alert;
    }

    @Override
    public void inintView() {
        button_alarm=fvbi(R.id.button_alarm);
        button_alarm.setOnClickListener(this);
        AlarmManager alarmManager= (AlarmManager) getSystemService(Service.ALARM_SERVICE);
        //得到日历类
        calendar=Calendar.getInstance();

    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View view) {
    if(view.getId()==R.id.button_alarm){
        new TimePickerDialog(this, 0, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            //指定启动AlarmActivity组件
                    Intent intent=new Intent(AlarmClockTestActivity.this, AlarmClockActivity.class);
            }
        }, calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
    }
    }
}
