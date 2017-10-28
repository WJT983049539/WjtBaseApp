package com.privatee.mylibrary.Base;

import com.privatee.mylibrary.R;

/**
 * 类的作用：
 * Created by WJT on  2017/10/27 19:52.
 */

public class BaseConfig {
    /**
     * app主颜色
     */
    private int appColor = R.color.base;

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

}
