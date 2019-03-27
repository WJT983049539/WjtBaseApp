package com.privatee.wjtbaseapp.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 类的作用：
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/7/3 10:23.
 */
public class OverScrollView extends ListView {
    //定义最大滚动高度
    int mContentMaxMoveHeight = 300;

    public OverScrollView(Context context) {
        super(context);
    }

    public OverScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OverScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mContentMaxMoveHeight, isTouchEvent);
    }
}
