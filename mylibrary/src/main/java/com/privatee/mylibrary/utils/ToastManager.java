package com.privatee.mylibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 类的作用：
 * Created by WJT on  2018/5/3 15:21.
 */
public class ToastManager {
    private static ToastManager mInstnce = null;
    private Toast mDialog;
    public static ToastManager getInstnce() {

        if (mInstnce == null) {
            //线程安全模式
            synchronized (ToastManager.class) {
                if (mInstnce == null) {
                    mInstnce = new ToastManager();
                }
            }
        }
        return mInstnce;
    }

    public void showToast(Context context,String ss) {

        if (mDialog == null) {
            mDialog = Toast.makeText(context,ss,Toast.LENGTH_LONG);
        }
         mDialog.setText(ss);
         mDialog.show();
    }

    public void dismissProgressDialog() {

        if (mDialog != null) {
            mDialog.cancel();
        }
        mDialog = null;
    }

}
