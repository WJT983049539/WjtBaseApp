package com.privatee.wjtbaseapp.A_V.activity;

import android.view.View;

import com.arcsoft.facetracking.AFT_FSDKEngine;
import com.privatee.mylibrary.Base.BaseActivity;

/**
 * 类的作用：java和h5交互
 * 包名 com.privatee.wjtbaseapp.A_V.activity
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018-11-10 10:14.
 * 修改历史:
 */
public class JAVA_H5_riActivity extends BaseActivity{
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
        AFT_FSDKEngine engine = new AFT_FSDKEngine();
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {

    }
}
