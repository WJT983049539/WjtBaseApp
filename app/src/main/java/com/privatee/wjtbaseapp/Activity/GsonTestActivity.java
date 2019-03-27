package com.privatee.wjtbaseapp.Activity;

import android.view.View;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/4 17:38.
 */
public class GsonTestActivity extends BaseActivity{
    @Override
    public String setNowActivityName() {
        return "测试gson";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_gson;
    }

    @Override
            public void inintView() {
        //        //通构造函数获取
        //        Gson gson=new Gson();
        //        //通过gsonBuilder来获取  ，可以进行多项特殊配置
        //        Gson gson1=  new GsonBuilder().create();
        //        JsonObject jsonObject=new JsonObject();
        //        jsonObject.addProperty("String","json");
        //        jsonObject.addProperty("qwe","asd a");
        //        Log.i("XSY2",jsonObject.toString());



            }

    @Override
    public void inintData() {
//        TdialogUtils.getInstances().showDialog();
    }

    @Override
    public void onClick(View v) {

    }
}
