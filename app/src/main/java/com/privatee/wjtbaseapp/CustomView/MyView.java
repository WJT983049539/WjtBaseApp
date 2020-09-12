package com.privatee.wjtbaseapp.CustomView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * 类的作用：
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/27 16:29.
 */
public class MyView extends View {
    private Path mpath=new Path();
    private float mPreX,mPreY;
    private int  mItemWaveLength=400;
    private int dx;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//            switch (event.getAction()){
//
//                case MotionEvent.ACTION_DOWN:
//                    mpath.moveTo(event.getX(), event.getY());
//                    mPreX = event.getX();
//                    mPreY = event.getY();
//                    return true;
//                case MotionEvent.ACTION_MOVE:
//                    float endX = (mPreX+event.getX())/2;
//                    float endY = (mPreY+event.getY())/2;
//                    mpath.quadTo(mPreX,mPreY,endX,endY);//贝尔赛曲线，连接俩个点的中点
////                    mpath.lineTo(event.getX(),event.getY());
//                    mPreX = event.getX();
//                    mPreY =event.getY();
//                    postInvalidate();//重绘
//                    break;
//                default:
//                    break;
//            }
//
//        return super.onTouchEvent(event);
//    }

    @Override
    protected void onDraw(Canvas canvas) {


        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(200);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setStyle(Paint.Style.FILL);
        mpath.reset();//初始化
        int originY = 300;
        int halfWaveLen = mItemWaveLength/2;//200
        mpath.moveTo(-mItemWaveLength+dx,originY);

        for (int i = -mItemWaveLength;i<=getWidth()+mItemWaveLength;i+=mItemWaveLength){
            mpath.rQuadTo(halfWaveLen/2,-100,halfWaveLen,0);
            mpath.rQuadTo(halfWaveLen/2,100,halfWaveLen,0);
        }
        mpath.lineTo(getWidth(),getHeight());
        mpath.lineTo(0,getHeight());
        mpath.close();

        canvas.drawPath(mpath,paint);
    }

//        mpath.moveTo(100,300);
//        mpath.rQuadTo(100,-100,200,0);//控制点   x加100，y轴减100  ，终点点 下x轴+200y
//        mpath.rQuadTo(100,100,200,0);
//        canvas.drawPath(mpath,paint);
//        super.onDraw(canvas);
    public void reset(){
        mpath.reset();
        invalidate();
    }
    public void startAnim(){
        ValueAnimator animator = ValueAnimator.ofInt(0,mItemWaveLength);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int)animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

}
