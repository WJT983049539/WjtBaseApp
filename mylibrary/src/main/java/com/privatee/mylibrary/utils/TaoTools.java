package com.privatee.mylibrary.utils;

import android.util.Log;

/**
 * 类的作用：
 * Created by WJT on  2017/10/27 18:19.
 */

public class TaoTools {
    //共享参数的文件名
    public static final String FILE_NAME = "share_data";


    /**
     * Log i  显示
     * @param msg 要显示的信息
     */
    public static void i(String msg){
        Log.i("SeeLog",msg);
    }
    /**
     * Log v  显示
     * @param msg 要显示的信息
     */
    public static void v (String msg){
        Log.v("SeeLog",msg);
    }
    /**
     * Log w  显示
     * @param msg 要显示的信息
     */
    public static void w(String msg){
        Log.w("SeeLog",msg);
    }
    /**
     * Log e  显示
     * @param msg 要显示的信息
     */
    public static void e(String msg){
        Log.e("SeeLog",msg);
    }
    /**
     * Log d  显示
     * @param msg 要显示的信息
     */
    public static void d(String msg){
        Log.d("SeeLog",msg);
    }



}
