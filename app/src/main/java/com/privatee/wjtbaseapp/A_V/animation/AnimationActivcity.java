package com.privatee.wjtbaseapp.A_V.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * 动画练习类
 */
public class AnimationActivcity extends BaseActivity {
    @Override
    public String setNowActivityName() {
        return "动画练习";
    }

    @Override
    public int setLayout() {
        return R.layout.activity_animatioin;
    }

    @Override
    public void inintView() {

        /**
         * 尺寸Scale标签
         * anroid:fromXScale:动画起始时，控件在X轴方向相对自身的缩放比例，浮点值，1.0代表自身无变化，0.5代表缩小1倍，2.0代表放大一倍
         * android:toXScale:动画结束时，控件在X轴方向上相对自身的缩放比例，浮点值
         * android:fromYScale:动画起始时，控件在Y轴方向相对自身的缩放比例，浮点值
         * android:toYScale:动画结束时，控件在Y轴方向相对自身的缩放比例，浮点值
         * android:pivotX:缩放起始点X轴坐标，可以使数值，百分比，百分数，百分数P三种形式，如果是数值，
         * 则表示在当前视图的左上角，加上数值px,,如果是%50则表示在当前控件的左上角加上自己宽度的50%，
         * 如果是%50p,则表示在当前控件的左上角加上父控件的宽度的%50座位缩放起始点X轴坐标
         * anroid:pivotY;
         */
        fvbi(R.id.btn_startanima).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               TextView tv=fvbi(R.id.tv);
                TextView textView9=fvbi(R.id.textView9);
               //得到动画实例，尺寸缩放动画
                Animation animation= AnimationUtils.loadAnimation(AnimationActivcity.this,R.anim.scaleanim);
                tv.startAnimation(animation);//通过View 实例加载动画
                //得到动画实例，尺寸缩放动画
                Animation animation2= AnimationUtils.loadAnimation(AnimationActivcity.this,R.anim.scaleanim2);
                textView9.startAnimation(animation2);
            }
        });
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View view) {

    }
}
