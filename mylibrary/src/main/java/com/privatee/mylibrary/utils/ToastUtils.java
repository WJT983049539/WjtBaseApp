package com.privatee.mylibrary.utils;

import com.privatee.mylibrary.Interface.CommonDialogListener;

/**
 * 类的作用：全剧唯一dialog提示框工具类
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/8 11:48.
 */
public class ToastUtils {
    private static ToastUtils instances;
    private static CommonDialogListener mListener;

    private ToastUtils() {

    }

    public void setListener(CommonDialogListener listener) {
        this.mListener = listener;
    }

    public static ToastUtils getInstances() {
        if (instances == null) {
            synchronized (ToastUtils.class) {
                if (instances == null) {
                    instances = new ToastUtils();
                }
            }
        }
        return instances;
    }


    public void showDialog() {
        if (mListener != null) {
            mListener.show();
        }
    }

    public void cancel() {
        if (mListener != null) {
            mListener.cancel();
        }
    }
}

