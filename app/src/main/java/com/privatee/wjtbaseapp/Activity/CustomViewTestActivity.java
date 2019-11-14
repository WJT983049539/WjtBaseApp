package com.privatee.wjtbaseapp.Activity;

import android.view.View;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.CustomView.MyView;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：自定义控件测试
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/23 09:51.
 */
public class CustomViewTestActivity extends BaseActivity {
    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.layout_testcustomview;
    }

    @Override
    public void inintView() {
//        final MyView myView = fvbi(R.id.myview);
//        myView.startAnim();
//        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myView.reset();
//            }
//        });

}

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {

    }
}
