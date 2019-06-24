package com.privatee.wjtbaseapp.A_V.activity;

import android.view.View;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * 算法联系类
 * @auther wjt
 * @date 2019/4/8
 */
public class AlgorithmTestActivity extends BaseActivity {
    @Override
    public String setNowActivityName() {
        return "算法练习";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_algorithm;
    }

    @Override
    public void inintView() {
        MaoPaoTest();

    }
    //冒泡练习
    private void MaoPaoTest() {
        //比较相邻的俩个元素，如果第一个比第二个 大，则交换俩个元素
        //从左到右依次比较,知道最大位数与数组尾端,
//        for(int i=0;i<)


    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {

    }
}
