package com.privatee.wjtbaseapp.Activity;

import android.view.View;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：微信登录测试
 * 包名 com.privatee.wjtbaseapp
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/7/20 17:02.
 * 修改历史:
 */
public class WeiXinLoginActivity extends BaseActivity {
    @Override
    public String setNowActivityName() {
        return "微信登录Activity";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_wx;
    }

    @Override
    public void inintView() {
        fvbi(R.id.weixinlogin_button).setOnClickListener(this);
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {
        //点击微信登录
        if(v.getId()==R.id.weixinlogin_button){
            //要成为微信开发者,成为微信开发者

        }
    }
}
