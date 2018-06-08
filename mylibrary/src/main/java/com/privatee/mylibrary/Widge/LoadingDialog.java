package com.privatee.mylibrary.Widge;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.privatee.mylibrary.R;

/**
 * 类的作用：等待dialog
 * Created by WJT on  2017/11/23 11:04.
 */

public class LoadingDialog extends Dialog{

    private Context mContext;
    private String testWord="";
    ImageView imageView;
    TextView textView;

    public LoadingDialog(Context context,String text) {
        super(context, R.style.LoadingDialog);
        mContext=context;
        testWord=text;
    }
    public LoadingDialog(Context context) {
        super(context, R.style.LoadingDialog);
        mContext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.dialog_loading_layout);
        imageView = (ImageView) findViewById(R.id.loading_view);
        textView=findViewById(R.id.tv_load_dialog);
        if(!testWord.equals("")){
            textView.setText(testWord);
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

}
