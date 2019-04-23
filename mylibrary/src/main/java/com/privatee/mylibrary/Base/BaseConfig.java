package com.privatee.mylibrary.Base;

import com.privatee.mylibrary.R;

/**
 * 类的作用：
 * Created by WJT on  2017/10/27 19:52.
 */

public class BaseConfig {

    /**
     * 屏幕是否常亮
     * 默认不常亮
     */

    private  boolean isKeepScreen=false;


    public  boolean isKeepScreen() {
        return isKeepScreen;
    }

    public  void setIsKeepScreen(boolean sisKeepScreen) {
        isKeepScreen = sisKeepScreen;
    }

    /**
     * 是否隐藏标题
     */
    private   boolean isTitle=false;

    public  boolean isTitle() {
        return isTitle;
    }

    public  void setIsTitle(boolean sisTitle) {
        isTitle = sisTitle;
    }

    /**
     * app主颜色
     */
    private int appColor = R.color.blue;

    public int getAppColor() {
        return appColor;
    }

    public void setAppColor(int appColor) {
        this.appColor = appColor;
    }

    public int getLoadingView() {
        return loadingView;
    }

    public void setLoadingView(int loadingView) {
        this.loadingView = loadingView;
    }

    public int getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(int appLogo) {
        this.appLogo = appLogo;
    }

    /**
     * 加载框的gif图
     */

    private int loadingView = 0;

    /**
     * APP图标
     */
    private int appLogo;

    /**
     * 主Activity,主界面
     */
    public static Class mainclass=null;

    public static void setMainclass(Class mainclasss){
        mainclass=mainclasss;
    }
    public static Class getMainclass(){
        return mainclass;
    }



    /**
     * 是否使用滑动返回
     */
    private   boolean isSwipBack=false;

    public  boolean isSwipBack() {
        return isSwipBack;
    }

    public  void setSwipBack(boolean isSwipBackk) {
        isSwipBack = isSwipBackk;
    }

}
