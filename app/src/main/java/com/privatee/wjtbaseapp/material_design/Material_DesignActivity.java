package com.privatee.wjtbaseapp.material_design;

import android.view.View;


import androidx.appcompat.app.ActionBar;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * Material_Design 谷歌设计材料风格
 * @author:create by
 * 邮箱 983049539@qq.com
 */
public class Material_DesignActivity extends BaseActivity {
    @Override
    public String setNowActivityName() {
        return "Material_Design风格";
    }

    @Override
    public int setLayout() {
        return R.layout.activity_material_design;
    }

    @Override
    public void inintView() {
        //获取ActionBar对象
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            //设置按钮
            actionBar.setDisplayHomeAsUpEnabled(true);
            //更换按钮图标
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {

    }
}
