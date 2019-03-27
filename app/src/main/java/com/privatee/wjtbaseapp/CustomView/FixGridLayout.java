package com.privatee.wjtbaseapp.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类的作用：
 * Created by WJT on  2018/2/6 10:07.
 */

public class FixGridLayout extends ViewGroup {
    private int mCellWidth;
    private int mCellHeight;
    /**
     * 控制子控件的换行
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int cellWidth = mCellWidth;
        int cellHeight = mCellHeight;
        int columns = (r - l) / cellWidth;
        if (columns < 0) {
            columns = 1;
        }
        int x = 0;
        int y = 0;
        int i = 0;
        int count = getChildCount();
        int rows=count/columns;
        if(rows<=0){
            rows=1;
        }else{
            if(count%columns>0){
                rows++;
            }
        }
//		this.layout(l, t, l+r, t+b*rows);
        for (int j = 0; j < count; j++) {
            final View childView = getChildAt(j);
            // 获取子控件Child的宽高
            int w = childView.getMeasuredWidth();
            int h = childView.getMeasuredHeight();
            // 计算子控件的顶点坐标
            int left = x + ((cellWidth - w) / 2);
            int top = y + ((cellHeight - h) / 2);
            // int left = x;
            // int top = y;
            // 布局子控件
            childView.layout(left, top, left + w, top + h);

            if (i >= (columns - 1)) {
                i = 0;
                x = 0;
                y += cellHeight;
            } else {
                i++;
                x += cellWidth;
            }
        }
    }

    /**
     * 计算控件及子控件所占区域
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 创建测量参数
        int cellWidthSpec = MeasureSpec.makeMeasureSpec(mCellWidth, MeasureSpec.AT_MOST);
        int cellHeightSpec = MeasureSpec.makeMeasureSpec(mCellHeight, MeasureSpec.AT_MOST);
        // 记录ViewGroup中Child的总个数
        int count = getChildCount();
        // 设置子空间Child的宽高
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            childView.measure(cellWidthSpec, cellHeightSpec);
        }
        // 设置容器控件所占区域大小
        int measuredWidth = measureWidth(widthMeasureSpec);//最大宽度
        //计算几行
        int maxColumns=measuredWidth/mCellWidth;

        int rows;
        if(maxColumns<=0){
            rows=1;
        }else{
            rows=count/maxColumns;
            if(count%maxColumns>0){
                rows++;
            }
        }
        // 注意setMeasuredDimension和resolveSize的用法
        setMeasuredDimension(measuredWidth,
                resolveSize(mCellHeight*rows, heightMeasureSpec));
//		 setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
//		int measuredHeight = measureHeight(heightMeasureSpec);
//		setMeasuredDimension(measuredWidth,measuredHeight);
        // 不需要调用父类的方法
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    private int measureHeight(int measureSpec) {

        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        // Default size if no limits are specified.

        int result = 500;
        if (specMode == MeasureSpec.AT_MOST) {

            // Calculate the ideal size of your
            // control within this maximum size.
            // If your control fills the available
            // space return the outer bound.

            result = specSize;
        } else if (specMode == MeasureSpec.EXACTLY) {

            // If your control can fit within these bounds return that
            // value.
            result = specSize;
        }

        return result;
    }

    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        // Default size if no limits are specified.
        int result = 500;
        if (specMode == MeasureSpec.AT_MOST) {
            // Calculate the ideal size of your control
            // within this maximum size.
            // If your control fills the available space
            // return the outer bound.
            result = specSize;
        }

        else if (specMode == MeasureSpec.EXACTLY) {
            // If your control can fit within these bounds return that
            // value.

            result = specSize;
        }

        return result;
    }
    /**
     * 为控件添加边框
     */
    @Override
    protected void dispatchDraw(Canvas canvas) {
//		// 获取布局控件宽高
//		int width = getWidth();
//		int height = getHeight();
//		// 创建画笔
//		Paint mPaint = new Paint();
//		// 设置画笔的各个属性
//		mPaint.setColor(Color.BLUE);
//		mPaint.setStyle(Paint.Style.STROKE);
//		mPaint.setStrokeWidth(10);
//		mPaint.setAntiAlias(true);
//		// 创建矩形框
//		Rect mRect = new Rect(0, 0, width, height);
//		// 绘制边框
//		canvas.drawRect(mRect, mPaint);
//		// 最后必须调用父类的方法
        super.dispatchDraw(canvas);
    }

    public FixGridLayout(Context context) {
        super(context);
    }

    public FixGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixGridLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setmCellWidth(int w) {
        mCellWidth = w;
        requestLayout();
    }

    public void setmCellHeight(int h) {
        mCellHeight = h;
        requestLayout();
    }


}
