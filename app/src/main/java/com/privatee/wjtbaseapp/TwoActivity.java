package com.privatee.wjtbaseapp;

import android.view.View;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.utils.TaoTools;

import java.util.HashMap;
import java.util.Map;

/**
 * 类的作用：
 * Created by WJT on  2018/1/9 18:08.
 */

public class TwoActivity extends BaseActivity{
    Map<String,String>map=new HashMap<String,String>();
    String Url="http://117.50.12.198:1883/eshow/heartbeat";
    @Override
    public String setNowActivityName() {
        return "第二测试类";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_two;
    }

    @Override
    public void inintView() {
        map.clear();
        map.put("username","天佳科技");
        map.put("number","1001000001");
        map.put("1000000001","天佳科技");
        map.put("mac","720006f3f590");
        map.put("network","0");
        map.put("signal","100");
        map.put("rotate","90");
        map.put("play","1");

        OkGo.<String>post(Url).params(map).execute(new StringCallback() {
            @Override
            public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                TaoTools.i(response.body().toString());
            }

            @Override
            public void onError(com.lzy.okgo.model.Response<String> response) {
                super.onError(response);
            }

        });




    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

        }
    }

}
