package com.privatee.wjtbaseapp.A_V.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * xposed框架练习
 * @auther wjt
 * @date 2019/6/19
 */
    public class XposedTestActivity extends BaseActivity {
    TextView tv_sposed;
    Button addgg;
    @Override
    public String setNowActivityName() {
        return "xposed框架练习";
    }

    @Override
    public int setLayout() {
        return R.layout.activity_xposed;
    }

    @Override
    public void inintView() {
        tv_sposed=fvbi(R.id.tv_sposed);
        addgg=fvbi(R.id.addgg);
        addgg.setOnClickListener(this);
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.addgg){
            tv_sposed.setText(getGG());
        }
    }

    public  String getGG() {
        return "广告加载成功";
    }
}
