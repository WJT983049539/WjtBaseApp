package com.privatee.mylibrary.Base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.privatee.mylibrary.R;
import com.privatee.mylibrary.utils.ActivityController;
import com.privatee.mylibrary.utils.SharedPreferenceTools;
import com.privatee.mylibrary.utils.TaoTools;

import java.lang.reflect.Field;

import static com.privatee.mylibrary.Base.BaseAndroid.baseConfig;
import static com.privatee.mylibrary.R.id.lay_bg;

/**
 * 类的作用：低版本的兼容Activity,在比如ViewPage上需要使用
 * Created by WJT on  2017/11/1 17:23.
 */

public abstract class CompatibilityBaseActivity extends FragmentActivity implements View.OnClickListener,SlidingPaneLayout.PanelSlideListener{

    private FragmentBackListener backListener;
    private boolean isInterception = false;
    private long clickTime=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if(baseConfig.isTitle()){
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏导航栏
        }
        super.onCreate(savedInstanceState);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        //隐藏底部键盘，一直不会弹出
        layoutParams.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE;
        //屏幕常亮
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setNowActivityName();
        setContentView(setLayout());
        inintView();
        inintData();
        TaoTools.i("在"+setNowActivityName()+"oncreate");
        ActivityController.addActivity(this);
        if(baseConfig.isSwipBack()){
            initSwipeBackFinish();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        TaoTools.i("在"+setNowActivityName()+"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        TaoTools.i("在"+setNowActivityName()+"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.RemoveActivity(this);
        TaoTools.i("在"+setNowActivityName()+"onDestroy");
    }

    /**
     *  通过类名启动Activity
     */
    protected void openActivity(Class<?> pClass) {
        openActivity(pClass, null);
    }
    /**
     * 通过类启动Activity,然后销毁自己
     */

    protected void openActicityAndDestoryme(Class<?> hClass){
        openActivityAndDestoryme(hClass,null);
    }
    /**
     * //通过类名启动Activity并携带Bundle数据,这个是跳转后销毁的
     *
     * @param pClass
     * @param pBundle
     */
    protected void openActivityAndDestoryme(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
        this.finish();
    }
    /**
     * //通过类名启动Activity并携带Bundle数据
     *
     * @param pClass
     * @param pBundle
     */
    protected void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }
    /**
     * 弹出Toast
     */
    public void showToast(String string) {
        Toast.makeText(CompatibilityBaseActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    /**
     * 检查字符串是否是空对象或空字符串
     */
    public boolean isNull(String str) {
        if (null == str || "".equals(str) || "null".equalsIgnoreCase(str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 保存sp数据
     *
     * @param key
     * @param object
     */
    public void putSp(String key, Object object) {
        SharedPreferenceTools.putValuetoSP(CompatibilityBaseActivity.this, key, object);
    }

    /**
     * 清除Sp数据
     */
    public void clearSp() {
        SharedPreferenceTools.clearAllSPvalue(CompatibilityBaseActivity.this);
    }

    /**
     * 获取sp数据
     *
     * @param key
     * @param object
     * @return
     */
    public Object getSp(String key, Object object) {
        return SharedPreferenceTools.getValueofSP(CompatibilityBaseActivity.this, key, object);
    }


    /**
     * 设置标题栏信息
     */
    public void setTitleText(String string) {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(lay_bg);
        relativeLayout.setBackgroundResource(BaseAndroid.getBaseConfig().getAppColor());
        LinearLayout backTv = (LinearLayout) findViewById(R.id.ly_base_back);
        backTv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
        TextView titleTv = (TextView) findViewById(R.id.tv_base_titleText);
        titleTv.setText(string);
    }

    /**
     * 隐藏后退
     */
    public void hideBack() {
        LinearLayout backTv = (LinearLayout) findViewById(R.id.ly_base_back);
        backTv.setVisibility(View.INVISIBLE);
    }

    /**
     * 隐藏title
     */
    public void hidetitle(){
        RelativeLayout backTv = (RelativeLayout) findViewById(lay_bg);
        if(backTv.getVisibility()==View.VISIBLE){
            backTv.setVisibility(View.GONE);
        }
    }
    /**
     * 设置标题栏右边按钮文字
     */
    public void setRightButtonText(String string, View.OnClickListener onClickListener) {
        TextView editTv = (TextView) findViewById(R.id.tv_base_edit);
        editTv.setVisibility(View.VISIBLE);
        editTv.setText(string);
        editTv.setOnClickListener(onClickListener);
    }

    /**
     * 设置右边图片
     */
    public void setRightImg(int bg, View.OnClickListener onClickListener) {
        ImageView imageView = (ImageView) findViewById(R.id.iv_right);
        imageView.setImageResource(bg);
        imageView.setOnClickListener(onClickListener);
    }

    /**
     * 标题栏背景设为透明
     */
    public void setBgNul() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(lay_bg);
        relativeLayout.setBackgroundColor(Color.parseColor("#00000000"));
    }

    /**
     * 标题栏背景
     */
    public void setTitleViewBg(int bg) {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(lay_bg);
        relativeLayout.setBackgroundResource(bg);
    }




///////////////////////////////////////////////////////////////////

    /**
     * 标识本Activity
     * @return
     */
    public abstract String setNowActivityName();

    /**
     * 主布局
     */
    public abstract int setLayout();

    /**
     * 初始化控件
     */
    public abstract void inintView();

    /**
     * 初始化数据
     */
    public abstract void inintData();

    /**
     * 简化findViewById()
     * @param resId
     * @param <T>
     * @return
     */
    protected <T extends View> T fvbi(int resId){
        return (T) findViewById(resId);
    }
    /**
     * 点击返回键，判断是否是最后一个activity，如果是就提示用户是否退出
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (isInterception()) {
                if (backListener != null) {
                    backListener.onbackForward();
                    return false;
                }
            }

            //剩最后一个了
            if(ActivityController.getActivities().size()==1){
                if (SystemClock.uptimeMillis() - clickTime <= 1500) {
                    //如果两次的时间差＜1s，就不执行操作
                } else {
                    //当前系统时间的毫秒值
                    clickTime = SystemClock.uptimeMillis();
                    Toast.makeText(this, "再次点击退出", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public FragmentBackListener getBackListener() {
        return backListener;
    }

    public void setBackListener(FragmentBackListener backListener) {
        this.backListener = backListener;
    }

    public boolean isInterception() {
        return isInterception;
    }

    public void setInterception(boolean isInterception) {
        this.isInterception = isInterception;
    }


    /**
     * 初始化滑动返回
     */
    private void initSwipeBackFinish() {
        if (isSupportSwipeBack()) {
            SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(this);
            //通过反射改变mOverhangSize的值为0，这个mOverhangSize值为菜单到右边屏幕的最短距离，默认
            //是32dp，现在给它改成0
            try {
                //mOverhangSize属性，意思就是左菜单离右边屏幕边缘的距离
                Field f_overHang = SlidingPaneLayout.class.getDeclaredField("mOverhangSize");
                f_overHang.setAccessible(true);
                //设置左菜单离右边屏幕边缘的距离为0，设置全屏
                f_overHang.set(slidingPaneLayout, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            slidingPaneLayout.setPanelSlideListener(this);
            slidingPaneLayout.setSliderFadeColor(getResources().getColor(android.R.color.transparent));
            // 左侧的透明视图
            View leftView = new View(this);
            leftView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            slidingPaneLayout.addView(leftView, 0);  //添加到SlidingPaneLayout中
            // 右侧的内容视图
            ViewGroup decor = (ViewGroup) getWindow().getDecorView();
            ViewGroup decorChild = (ViewGroup) decor.getChildAt(0);
            decorChild.setBackgroundColor(getResources().getColor(android.R.color.white));
            decor.removeView(decorChild);
            decor.addView(slidingPaneLayout);
            // 为 SlidingPaneLayout 添加内容视图
            slidingPaneLayout.addView(decorChild, 1);
        }
    }

    /**
     * 是否支持滑动返回
     *
     * @return
     */
    protected boolean isSupportSwipeBack() {
        return true;
    }

    @Override
    public void onPanelClosed(View view) {

    }

    @Override
    public void onPanelOpened(View view) {
        finish();
//        this.overridePendingTransition(0, R.anim.out_to_right);
    }

    @Override
    public void onPanelSlide(View view, float v) {
    }


}