package com.privatee.wjtbaseapp.A_V.activity;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;
import com.warkiz.widget.IndicatorSeekBar;

import java.util.ArrayList;

/**
 * seekbar测试
 * @auther wjt
 * @date 2019/3/27
 */
public class SeekBarTestActivity extends BaseActivity {
    SeekBar seekBar;
    TextView textView;
   TextView textView7;

    @Override
    public String setNowActivityName() {
        return "seekbar测试";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_seekbar;
    }

    @Override
    public void inintView() {
        seekBar = (SeekBar) findViewById(R.id.progress);
        textView = (TextView) findViewById(R.id.text1);
        textView7 = (TextView) findViewById(R.id.textView7);

        //从asset 读取字体
        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "font/TFB.TTF");//仿宋
        textView7.setTypeface(tf);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 当拖动条的滑块位置发生改变时触发该方法,在这里直接使用参数progress，即当前滑块代表的进度值
                textView.setText("Value:" + Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("------------", "开始滑动！");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("------------", "停止滑动！");
            }
        });

    }

    @Override
    public void inintData() {
    }

    @Override
    public void onClick(View v) {

    }


}
