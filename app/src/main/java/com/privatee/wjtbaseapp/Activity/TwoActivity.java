package com.privatee.wjtbaseapp.Activity;

import android.view.View;
import android.widget.Button;

import com.ibpd.xsy.varDefine.GlobalVarDefine;
import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.Widge.MaterialDialog;
import com.privatee.mylibrary.Widge.ToastManager;
import com.privatee.mylibrary.utils.ActivityController;
import com.privatee.wjtbaseapp.R;

import java.util.HashMap;
import java.util.Map;

/**
 * 类的作用：
 * Created by WJT on  2018/1/9 18:08.
 */

public class TwoActivity extends BaseActivity{
    Map<String,String>map=new HashMap<String,String>();
//    String Url="http://117.50.12.198:1883/eshow/heartbeat";
    private MaterialDialog mMaterialDialog;
    String url = "http://ci4.ibpd.net/ci/"+ GlobalVarDefine.GET_STUDENT_INFO_URL;
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
        Button add_commit_button=fvbi(R.id.add_commit_button);
        add_commit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityController.RemoveOtherActivity(TwoActivity.this);
            }
        });

//        map.clear();
////        map.put("username","天佳科技");
////        map.put("number","1001000001");
////        map.put("1000000001","天佳科技");
////        map.put("mac","720006f3f590");
////        map.put("network","0");
////        map.put("signal","100");
////        map.put("rotate","90");
////        map.put("play","1");
//        map.put("studentId", "7");//id
//
//        OkGo.<MsgEntity>post(url).params(map).execute(new TestCallback<MsgEntity>(){
//
//            @Override
//            public void onSuccess(Response<MsgEntity> response) {
//                super.onSuccess(response);
//                TaoTools.i(response.body().toString());
//                MsgEntity msgEntity=response.body();
//
//                if(msgEntity.getIsErrorMsg()){
//                    TaoTools.i("返回结果："+msgEntity.getMsg());
//                }else {
//                    ClientStudentEntity student = (ClientStudentEntity) msgEntity.getObj();
//                    TaoTools.i("返回结果："+student.getStudName()+student.getStudNum());
//                }
//            }
//
//            @Override
//            public void onError(Response<MsgEntity> response) {
//                super.onError(response);
//                TaoTools.i(response.body().toString());
//            }
//        });

        mMaterialDialog= new MaterialDialog(this)
                .setTitle("MaterialDialog")
                .setMessage("Hello world!")
                .setPositiveButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });

        mMaterialDialog.show();

        ToastManager.getInstnce().showToast(this);


    }

    @Override
    public void inintData() {
        setTitleText("返回");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
        }
    }

}
