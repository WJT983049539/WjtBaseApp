package com.privatee.wjtbaseapp.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;

import com.privatee.mylibrary.Base.CompatibilityBaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：专用测试类
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/7/3 11:12.
 */
public class WjtTestActivity extends CompatibilityBaseActivity {
    @Override
    public String setNowActivityName() {
        return "WJT测试类";
    }

    @Override
    public int setLayout() {
        return R.layout.test;
    }

    @Override
    public void inintView() {
//        ListViewOverScroll fragment1 = new ListViewOverScroll();
//        addFragment(fragment1, "fragmentOne");


    }

    @Override
    public void inintData() {
    }

    @Override
    public void onClick(View v) {
    }
    //添加fragment
    private void addFragment(Fragment fragment, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.test_lin, fragment, tag);
        transaction.addToBackStack(tag);//添加到回退窄
        transaction.commit();
    }
}
