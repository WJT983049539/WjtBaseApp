package com.privatee.mylibrary.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import com.privatee.mylibrary.R;
import com.privatee.mylibrary.Widge.NumberProgressBar;

/**
 * 类的作用：
 * Created by WJT on  2018/4/13 10:35.
 */

public class CustomProgressDialog extends ProgressDialog{

    private NumberProgressBar numberProgressBar;
    public CustomProgressDialog(Context context) {
        super(context);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }

    private void init(Context context) {
        //设置不可取消，点击其他区域不能取消，实际中可以抽出去封装供外包设置
//        setCancelable(false);
//        setCanceledOnTouchOutside(false);
        setContentView(R.layout.load_dialog);
        numberProgressBar=findViewById(R.id.pb_load);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }
    public void setPropress(int aa){
        numberProgressBar.setProgress(aa);
    };
    @Override
    public void show()
    {
        super.show();
    }
}
