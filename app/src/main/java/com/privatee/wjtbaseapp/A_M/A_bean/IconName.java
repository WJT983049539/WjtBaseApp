package com.privatee.wjtbaseapp.A_M.A_bean;

import java.io.Serializable;

/**
 * 类的作用：
 * 包名 com.privatee.wjtbaseapp.A_M.A_bean
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018-09-25 17:29.
 * 修改历史:
 */
public class IconName implements Serializable{
    private String iconName;

    public IconName(String str){
        this.iconName=str;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}
