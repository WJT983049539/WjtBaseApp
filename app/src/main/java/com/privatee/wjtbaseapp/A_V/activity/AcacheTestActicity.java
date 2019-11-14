package com.privatee.wjtbaseapp.A_V.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.DiskLruTools.ACache;
import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.wjtbaseapp.Bean.MyTestBean;
import com.privatee.wjtbaseapp.Bean.TestBean;
import com.privatee.wjtbaseapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther wjt
 * @date 2019/6/4
 */
public class AcacheTestActicity extends BaseActivity {
    private Button bt_baocuntext;
    private Button bt_showtext;
    private TextView tv_show;
    private String value="";
    ACache aCache;
    @Override
    public String setNowActivityName() {
        return "缓存测试";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_acache;
    }

    @Override
    public void inintView() {
        aCache=ACache.get(this);
        bt_baocuntext=fvbi(R.id.bt_baocuntext);
        bt_baocuntext.setOnClickListener(this);
        bt_showtext=fvbi(R.id.bt_showtext);
        bt_showtext.setOnClickListener(this);

        tv_show=fvbi(R.id.tv_show);

    }
    @Override
    public void inintData() {
        ArrayList<MyTestBean> list=new ArrayList<MyTestBean>();
        MyTestBean myTestBean=new MyTestBean();
        myTestBean.setName("1");
        myTestBean.setAge(2);
        MyTestBean myTestBean2=new MyTestBean();
        myTestBean2.setName("1");
        myTestBean2.setAge(2);
        list.add(myTestBean);
        list.add(myTestBean2);
        aCache.put("list",list);
    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.bt_baocuntext:
                 aCache.put("test","测试这个可以保存序列化bean");
                 break;
             case R.id.bt_showtext:
//                 value=aCache.getAsString("test");
                 ArrayList<MyTestBean> arrayList= (ArrayList<MyTestBean>) aCache.getAsObject("list");
                 TaoTools.d(arrayList.size()+"");
                 tv_show.setText(value);
                 break;
             case R.id.tv_show:

                 break;
         }
    }
}
