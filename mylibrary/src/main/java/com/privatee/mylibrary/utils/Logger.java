package com.privatee.mylibrary.utils;

import com.elvishew.xlog.XLog;

/**
 * 类的作用：详细的log
 * Created by WJT on  2018/3/13 16:13.
 */

public class Logger {
    /**
     * Log i  显示
     * @param msg 要显示的信息
     */
    public static void i(String msg){
           XLog.i(msg);
    }
    /**
     * Log v  显示v
     * @param msg 要显示的信息
     */
    public static void v(String msg){
           XLog.v(msg);
    }
    /**
     * Log w  显示
     * @param msg 要显示的信息
     */
    public static void w(String msg){
           XLog.w(msg);
    }
    /**
     * Log e  显示
     * @param msg 要显示的信息
     */
    public static void e(String msg){
           XLog.e(msg);
    }
    /**
     * Log d  显示
     * @param msg 要显示的信息
     */
    public static void d(String msg){
           XLog.d(msg);
    }
}
