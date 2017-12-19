package com.privatee.wjtbaseapp;

import android.view.View;
import android.widget.TextView;

import com.privatee.mylibrary.Base.BaseActivity;

public class MainActivity extends BaseActivity {
    private TextView aaa;

    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inintView() {
        aaa=fvbi(R.id.aaa);
        aaa.setOnClickListener(this);
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.aaa:
//                DialogManager.getInstnce().showProgressDialog(this);
//                final Dialog loadingDialog=NomerLodingDialogUtils.createLoadingDialog(this,"请稍等");
//
//                CountDownTimer countDownTimer=new CountDownTimer(6000,1000) {
//                    @Override
//                    public void onTick(long l) {
////                        Toast.makeText(MainActivity.this,l/1000+"",Toast.LENGTH_SHORT).show();
//                        TaoTools.i(l/1000+"");
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        TaoTools.i("onFinish");
//                        NomerLodingDialogUtils.closeDialog(loadingDialog);
//                    }
//                }.start();
//                break;


                //测试greenDao


        }
    }
}
