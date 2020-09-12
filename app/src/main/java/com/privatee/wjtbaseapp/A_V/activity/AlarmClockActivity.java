package com.privatee.wjtbaseapp.A_V.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

import com.privatee.mylibrary.Base.BaseActivity;

public class AlarmClockActivity extends BaseActivity {
    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return 0;
    }

    @Override
    public void inintView() {
        //创建一个对话框
        new AlertDialog.Builder(AlarmClockActivity.this).setTitle("闹钟")
                .setMessage("闹钟响了，快起床啦！")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //停止音乐

                        AlarmClockActivity.this.finish();
                    }
                }).show();
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View view) {

    }
}
