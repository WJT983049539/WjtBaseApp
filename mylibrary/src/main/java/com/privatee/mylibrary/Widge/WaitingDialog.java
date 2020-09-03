package com.privatee.mylibrary.Widge;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.WindowManager;
import android.widget.ImageView;

import com.privatee.mylibrary.R;

/**
 * 类的作用：好看的通用的
 * Created by WJT on  2018/3/3 10:21.
 */

public class WaitingDialog extends Dialog{
    private Context mContext;
    ImageView imageView;
    public WaitingDialog(@NonNull Context context) {
        super(context, R.style.LoadingDialog);
        mContext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inintView();
    }

    private void inintView() {
        setContentView(R.layout.dialog_loading_layout);
        imageView = (ImageView) findViewById(R.id.loading_view);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }
}
