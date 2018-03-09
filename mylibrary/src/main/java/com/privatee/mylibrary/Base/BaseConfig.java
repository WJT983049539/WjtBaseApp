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

    private static boolean isKeepScreen=false;


    public static boolean isKeepScreen() {
        return isKeepScreen;
    }

    public static void setIsKeepScreen(boolean isKeepScreen) {
        BaseConfig.isKeepScreen = isKeepScreen;
    }

    /**
     * 是否隐藏标题
     */
    private static  boolean isTitle=true;

    public static boolean isTitle() {
        return isTitle;
    }

    public static void setIsTitle(boolean isTitle) {
        BaseConfig.isTitle = isTitle;
    }

    /**
     * app主颜色
     */
    private int appColor = 0x00BB29;

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
    private int appLogo = R.drawable.ic_launcher;

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

}
