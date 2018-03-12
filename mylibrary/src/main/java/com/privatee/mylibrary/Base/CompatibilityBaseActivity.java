package com.privatee.mylibrary.Base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

import static com.privatee.mylibrary.R.id.lay_bg;

/**
 * 类的作用：低版本的兼容Activity,在比如ViewPage上需要使用
 * Created by WJT on  2017/11/1 17:23.
 */

public abstract class CompatibilityBaseActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏任务栏
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
}