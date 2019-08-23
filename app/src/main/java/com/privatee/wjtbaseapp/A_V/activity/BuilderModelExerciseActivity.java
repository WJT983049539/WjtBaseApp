package com.privatee.wjtbaseapp.A_V.activity;

import android.view.View;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.Bean.User;
import com.privatee.wjtbaseapp.Bean.UserTest;
import com.privatee.wjtbaseapp.R;

/**
 * 构建者模式练习
 * @author wjt
 * @date 2019/8/23 18:33
 * @contact 983049539@qq.com
 */
public class BuilderModelExerciseActivity extends BaseActivity {
    @Override
    public String setNowActivityName() {
        return "构建者模式练习";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_builder;
    }

    @Override
    public void inintView() {

    }

    @Override
    public void inintData() {
      UserTest userTest=new UserTest.UserBuilder("zhangsan","zhaowu").age(20).phone("353").address("335").builder();
    }

    @Override
    public void onClick(View v) {

    }
}
