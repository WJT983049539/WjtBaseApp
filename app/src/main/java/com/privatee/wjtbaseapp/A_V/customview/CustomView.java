package com.privatee.wjtbaseapp.A_V.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Paint paint=new Paint();
//        paint.setColor(Color.BLUE);
//        paint.setStyle(Paint.Style.FILL);
//        canvas.translate(100,100);//原点向右平移100，向y轴（向下）平移100
//        Rect rect1=new Rect(0,0,400,220);
//        canvas.drawRect(rect1,paint);
        canvas.drawColor(Color.BLUE);
        canvas.save();//保存当前画布大小；即整个屏幕
        canvas.clipRect(new Rect(100,100,800,600));
        canvas.drawColor(Color.RED);
        //恢复整屏画布
        canvas.restore();
        canvas.drawColor(Color.GREEN);
    }
}
