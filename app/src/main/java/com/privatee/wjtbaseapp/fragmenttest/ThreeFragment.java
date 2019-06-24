package com.privatee.wjtbaseapp.fragmenttest;

import com.privatee.mylibrary.Base.CompatibleBaseFragment;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/7/2 11:49.
 */
public class ThreeFragment extends CompatibleBaseFragment{
    @Override
    public String setNowfragmentName() {
        return "第三个fragment";
    }

    @Override
    public void initView() {

    }

    @Override
    public void inintData() {

    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_three;
    }
}
