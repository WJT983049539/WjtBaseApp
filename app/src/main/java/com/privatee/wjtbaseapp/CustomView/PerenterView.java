package com.privatee.wjtbaseapp.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.privatee.mylibrary.utils.TaoTools;

/**
 * 类的作用：
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/13 17:03.
 */
public class PerenterView extends View {
    private Paint mpaint;
    private  RectF oval;
    public PerenterView(Context context) {
        super(context);
        inint();
    }

    public PerenterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inint();
    }

    public PerenterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inint();
    }

    private void inint() {
        mpaint=new Paint();
        mpaint.setAntiAlias(true);
        oval=new RectF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heighMode= MeasureSpec.getMode(heightMeasureSpec);
        int heighSize= MeasureSpec.getSize(heightMeasureSpec);
        Log.e("XSY","onMeasure--widthMode-->"+widthMode);
        Log.e("XSY", "onMeasure--widthSize-->" + widthSize);
        Log.e("XSY", "onMeasure--heightMode-->" + heighMode);
        Log.e("XSY", "onMeasure--heightSize-->" + heighSize);
        switch(widthMode){
            case MeasureSpec.EXACTLY:
                TaoTools.i("exactly");
                break;
            case MeasureSpec.AT_MOST:
                TaoTools.i("at_most");
                break;
            case MeasureSpec.UNSPECIFIED:
                TaoTools.i("unspecofied");
                break;

        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        TaoTools.i("onlayout     "+"changed=="+changed+"  left=="+left+" top=="+top+"bottom=="+bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mpaint.setColor(Color.GREEN);
        // FILL填充, STROKE描边,FILL_AND_STROKE填充和描边
        mpaint.setStyle(Paint.Style.FILL_AND_STROKE);
        int with = getWidth();
        int height = getHeight();
        float radius=with/4;
        canvas.drawCircle(with / 2, with / 2, radius, mpaint);
        mpaint.setColor(Color.BLUE);
        oval.set(with / 2 - radius, with / 2 - radius, with / 2
                + radius, with / 2 + radius);//用于定义的圆弧的形状和大小的界限
        canvas.drawArc(oval, 270, 120, true, mpaint);  //根据进度画圆弧
    }
}
