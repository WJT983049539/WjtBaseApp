package com.privatee.wjtbaseapp.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Scroller;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的作用:自定义雷达图
 * 包名 com.privatee.wjtbaseapp.CustomView
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/8/10 11:58.
 * 修改历史:
 */
public class RadarView extends View {
    private Paint mBroadPaint=new Paint();//画边的笔
    private Paint mMarkEasePaint=new Paint();//数值面积
    private Paint mMarkPaint=new Paint();//数值边
    private Paint mCircleHoldPaint=new Paint();//各个数值点
    private Paint mDrawTextPaint=new Paint();//各个角文字
    private Paint mHoldTextPaint=new Paint();//数值点文字
    private Paint mIntervalTextPaint=new Paint();//区间点

    public static final double CIRCLE_ANGLE=2*Math.PI;
    private int broad_color= Color.parseColor("#585858");//边的颜色
    private int getBroad_color_text=Color.parseColor("#88001B");//角的字体颜色
    private int mark_color = Color.parseColor("#FDECA6");//数值区域颜色
    private int mark_broad_color = Color.parseColor("#FFCA18");//数值边的颜色
    private int corner_hold_color = Color.parseColor("#EC1C24");//数组提示字体的颜色
    private int circle_hold_color = Color.parseColor("#008B8B");//数值区域点的颜色
    private int interval_text_color = Color.parseColor("#2F4F4F");//区间点的颜色

    private float mBroadStrokeWidth = 1.5f;//边的粗细
    private float mMarkBroadStrokeWidth = 1.5f;//数值区域边的粗细
    private int corner_textSize;//边角的字体的大小
    private int circle_hold_textSize;//数组提示字体的大小
    private int mMarkEaseAlpha = 70;//数值区域的透明度
    private int mBroadAlpha = 225;//各个边的连线的透明度
    private int mIntervalTextSize;//区间点的大小

    private List<String> cornerName = new ArrayList<>();//角的名字的集合
    private List<Float> listData = new ArrayList<>();
    private int angleStatus = 0;//角的状态
    private float maxValue = 0f;//最大值
    private Float radius = 0f;//画图的半径

    private float[] listAngle;//所有角的集合
    private boolean drawText = false;//画不画数组提示
    private long duration = 3000;//动画时间
    private boolean openDuration = true;//是否开启动画
    private boolean openDataEasePoint = true;//是否开启区域数值提示
    private int marginNum = 4; //画多少个雷达图的边
    private float margin; //每个雷达图边的间隔
    private double mPerimeter;
    private float mFlingPoint;

    private GestureDetector mDetector;
    private Scroller scroller;

    public RadarView(Context context) {
        super(context);
    }

    public RadarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}


