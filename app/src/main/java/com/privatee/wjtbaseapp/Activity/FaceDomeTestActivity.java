package com.privatee.wjtbaseapp.Activity;

import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

import static com.privatee.mylibrary.utils.DensityUtil.getScreenWidth;

/**
 * 类的作用：
 * 包名 com.privatee.wjtbaseapp.Activity
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018-10-30 15:42.
 * 修改历史:
 */
public class FaceDomeTestActivity extends BaseActivity implements GestureDetector.OnGestureListener{
    private Button check_facebutton;
    private Button inputfacedate;
    private View popupWindow_view;

    private GestureDetector mGestureDetector;

    /**
     * 获得屏幕尺寸
     */

    private PopupWindow popupWindow;

    private View contentView;


    private int from = 0;

    private static final String TAG = "GuestModelActivity";

    @Override
    public String setNowActivityName() {
        return "面部识别";
    }
    @Override
    public int setLayout() {
        return R.layout.layout_face;
    }

    @Override
    public void inintView() {
        getPopupWindow();
        mGestureDetector = new GestureDetector(this, this);
        check_facebutton=fvbi(R.id.check_facebutton);
        inputfacedate=fvbi(R.id.inputfacedate);
        //开始面部识别
        check_facebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //添加数据
        inputfacedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    @Override
    public void inintData() {


    }

    @Override
    public void onClick(View v) {

    }


    /*** 
     * 获取PopupWindow实例 
     */
    private void getPopupWindow() {
        if (null != popupWindow) {
            popupWindow.dismiss();
            return;
        } else {
            initPopuptWindow();
        }
    }

    private void initPopuptWindow() {
        // TODO Auto-generated method stub
        // 获取自定义布局文件activity_popupwindow_left.xml的视图
        popupWindow_view = getLayoutInflater().inflate(R.layout.activity_popupwindow_top, null, false);
        // 创建PopupWindow实例,200,LayoutParams.MATCH_PARENT分别是宽度和高度
        popupWindow = new PopupWindow(popupWindow_view, 200, 50, true);
        // 设置动画效果
        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        // 点击其他地方消失
        popupWindow_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        /**
         * 拖动手势
         */
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //手指划过屏幕的横向距离
        float x = e2.getX() - e1.getX();
        //手指划过屏幕的纵向距离
        float y = e2.getY() - e1.getY();
        //取得横向距离的绝对值
        float x_abs = Math.abs(x);
        //取得纵向距离的绝对值
        float y_abs = Math.abs(y);
        float x_limit = getScreenWidth(FaceDomeTestActivity.this) / 5;

        if(x > x_limit || x < -x_limit){
            if(x > 0){
//向右
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }



            }else if(x < 0 ){
                //向左
                // 这里是位置显示方式,在屏幕的左侧
//                if(null!=popupWindow_view) {
//                popupWindow.showAtLocation(popupWindow_view, Gravity.RIGHT, 0, 0);
//                }
                if(null!=popupWindow_view) {
                    popupWindow.showAtLocation(popupWindow_view, Gravity.RIGHT, 0, 0);
                }

            }
        }

        return false;
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
    }
