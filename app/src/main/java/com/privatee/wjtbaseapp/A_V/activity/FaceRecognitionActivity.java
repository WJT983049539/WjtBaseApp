package com.privatee.wjtbaseapp.A_V.activity;

import android.Manifest;
import android.view.View;
import android.widget.Toast;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

import io.reactivex.functions.Consumer;

/**
 * 类的作用：人脸识别
 * 包名 com.privatee.wjtbaseapp.A_V.activity
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018-10-12 10:12.
 * 修改历史:
 */
public class FaceRecognitionActivity extends BaseActivity{
    @Override
    public String setNowActivityName() {
        return "人脸识别";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_face;
    }

    @Override
    public void inintView() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE
                , Manifest.permission.READ_PHONE_STATE, Manifest.permission.RECORD_AUDIO)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            initView();
                        } else {
                            Toast.makeText(FaceRecognitionActivity.this, "请同意软件的权限，才能继续使用", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    //
    private void initView() {
        //判断文件是否存在不存在创建
        File p = new File("/sdcard/img/output");
        if (!p.exists()) p.mkdirs();

        p = new File("/sdcard/img/liveness");
        if (!p.exists()) p.mkdirs();
    }

    @Override
    public void inintData() {


    }

    @Override
    public void onClick(View v) {

    }
}
