package com.privatee.wjtbaseapp;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 类的作用：黄油刀测试
 * Created by WJT on  2018/3/8 15:44.
 */

public class ButterKnifeActivity extends Activity {
    @BindView(R.id.knife_button)
    Button knife_button;
    @BindView(R.id.knife_text)
    TextView knife_textview;
    @BindView(R.id._knife_imageView)
    ImageView knife_imageview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knife_layout);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.knife_button)
    public void buttonClick(Button button){

        knife_textview.setText("我被小刀感染啦！");
    }
}
