package com.privatee.wjtbaseapp.Activity;

import android.view.View;
import android.widget.Button;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：
 * Created by WJT on  2018/4/23 11:21.
 */

public class BARRActivity extends BaseActivity{
    Button bar_button;
    @Override
    public String setNowActivityName() {
        return "";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_bar;
    }

    @Override
    public void inintView() {
        fvbi(R.id.bar_button).setOnClickListener(this);
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {
         if(v.getId()==R.id.bar_button){
             try {
                 Thread.sleep(5000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
}
