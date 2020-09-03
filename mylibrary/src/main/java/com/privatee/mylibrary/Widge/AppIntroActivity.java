package com.privatee.mylibrary.Widge;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import android.view.Window;

import com.github.paolorotolo.appintro.AppIntro;
import com.privatee.mylibrary.Base.BaseConfig;
import com.privatee.mylibrary.Base.SlideFragment;

/**
 * 类的作用： 这个欢迎介绍页面，需要传入要导入的布局页面信息
 *            最多传递5个数据，就是5个页面
 * Created by WJT on  2018/2/27 10:05.
 */

public class AppIntroActivity extends AppIntro {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setFadeAnimation();
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏导航栏
    }

    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        int[]  wrong = new int[5];
        Intent intent = getIntent();
        Bundle b=this.getIntent().getExtras();
        wrong = b.getIntArray("wrong");
        for(int x=0;x<4;x++){
            addSlide(SlideFragment.newInstance(wrong[x]));
        }
//        addSlide(SlideFragment.newInstance(R.layout.intro2));
//        addSlide(SlideFragment.newInstance(R.layout.intro3));
//        addSlide(SlideFragment.newInstance(R.layout.intro4));
//        setBarColor(Color.TRANSPARENT);
        setSeparatorColor(Color.parseColor("#3333cc"));
        setVibrateIntensity(30);
        setSkipText("直接进入");
        setDoneText("进入");
        //隐藏跳过/完成按钮。
//        showSkipButton(false);
//        setProgressButtonEnabled(false);
    }

    //当执行跳过动作时触发
    @Override
    public void onSkipPressed() {
        startMain();
    }

    /**
     * 完毕跳转到
     */
    private void startMain() {
        startActivity(new Intent(AppIntroActivity.this, BaseConfig.getMainclass()));
        finish();
    }
    //当执行跳过动作时触发
    @Override
    public void onNextPressed() {

    }
    //当执行跳过动作时触发
    @Override
    public void onDonePressed() {
        startMain();
    }
    //当执行跳过动作时触发
    @Override
    public void onSlideChanged() {

    }
}
