package com.privatee.wjtbaseapp.A_V.activity;

import android.view.View;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.wjtbaseapp.Bean.MMKVTestBean;
import com.privatee.wjtbaseapp.R;
import com.tencent.mmkv.MMKV;

/**
 * MMKV储存使用
 * @author:create by
 * 邮箱 983049539@qq.com
 */
public class MMKVTest_Activity extends BaseActivity {
    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.mmlvtest;
    }

    @Override
    public void inintView() {

    }

    @Override
    public void inintData() {
        MMKV kv = MMKV.defaultMMKV();

        MMKV mmkv = MMKV.mmkvWithID("MyID");//不同业务的
        mmkv.encode("int", 1);


        MMKV mmkv2 = MMKV.mmkvWithID("MyID",MMKV.MULTI_PROCESS_MODE);//不同业务多线程
        mmkv2.encode("int", 2);

        int iValue2 = mmkv2.decodeInt("int");
        kv.encode("int", Integer.MIN_VALUE);
        kv.encode("bool", true);

        boolean bValue = kv.decodeBool("bool");
        kv.encode("int", Integer.MIN_VALUE);
        int iValue = kv.decodeInt("int");

        kv.encode("string", "Hello from mmkv");
        String str = kv.decodeString("string");
        MMKVTestBean mm=new MMKVTestBean();
        mm.setAge(0);
        mm.setFalg(true);
        mm.setTest("test");
        kv.encode("parcelable",mm);
        MMKVTestBean mm2= kv.decodeParcelable("parcelable",MMKVTestBean.class);
        TaoTools.d("Falg=="+mm2.isFalg());
        TaoTools.d("String=="+mm2.getTest());


    }

    @Override
    public void onClick(View v) {

    }
}
