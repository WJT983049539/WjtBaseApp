package com.privatee.wjtbaseapp;

import android.view.View;
import android.widget.Button;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.utils.CustomProgressDialog;

/**
 * 类的作用：
 * Created by WJT on  2018/4/13 10:21.
 */

    public class ProgressDialogActivity extends BaseActivity{
    private Button opendialog_progress;
    @Override
    public String setNowActivityName() {
        return "progressdialogac";
    }

    @Override
    public int setLayout() {
        return R.layout.activity_progressdialog;
    }

    @Override
    public void inintView() {
        opendialog_progress=fvbi(R.id.opendialog_progress);
        opendialog_progress.setOnClickListener(this);
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.opendialog_progress){
            CustomProgressDialog dialog=new CustomProgressDialog(this);
            dialog.setMax(100);
            dialog.show();
        }
    }
}
