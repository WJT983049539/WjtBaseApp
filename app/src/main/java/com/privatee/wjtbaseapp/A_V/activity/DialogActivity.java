package com.privatee.wjtbaseapp.A_V.activity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;

import com.privatee.mylibrary.utils.DensityUtil;
import com.privatee.wjtbaseapp.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * dialog形式的Activitry
 */
public class DialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urllist);
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
        WindowManager.LayoutParams p = getWindow().getAttributes(); // 获取对话框当前的参值
        int witch= DensityUtil.getScreenWidth(this);
        int height=DensityUtil.getScreenHeight(this);
        p.width=witch/4;
        p.height= (int) (height*0.8);
        p.alpha = 1.0f; // 设置本身透明度
        p.dimAmount = 0.0f; // 设置黑暗度
        getWindow().setAttributes(p); // 设置生效
        getWindow().setGravity(Gravity.LEFT); // 设置靠右对齐


    }
}
