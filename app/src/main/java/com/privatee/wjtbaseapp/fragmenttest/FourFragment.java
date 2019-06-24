package com.privatee.wjtbaseapp.fragmenttest;

import com.privatee.mylibrary.Base.CompatibleBaseFragment;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/7/2 11:51.
 */
public class FourFragment extends CompatibleBaseFragment{
    @Override
    public String setNowfragmentName() {
        return "第四个fragment";
    }

    @Override
    public void initView() {

    }

    @Override
    public void inintData() {

    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_four;
    }
}
