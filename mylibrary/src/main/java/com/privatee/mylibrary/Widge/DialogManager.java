package com.privatee.mylibrary.Widge;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;

/**
 * 类的作用：
 * Created by WJT on  2017/11/23 11:42.
 */

public class DialogManager {

    private static DialogManager mInstnce = null;
    private LoadingDialog mDialog;

    public static DialogManager getInstnce() {

        if (mInstnce == null) {
            //线程安全模式
            synchronized (DialogManager.class) {
                if (mInstnce == null) {
                    mInstnce = new DialogManager();
                }
            }
        }
        return mInstnce;
    }

    public void showProgressDialog(Context context) {

        if (mDialog == null||context!=null) {
            mDialog = new LoadingDialog(context,"");
            mDialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
            //设置点击dialog外部，不会自动退出dialog
            mDialog.setCanceledOnTouchOutside(false);
        }
        mDialog.show();
    }

    public void dismissProgressDialog() {

        if (mDialog != null) {
            mDialog.dismiss();
        }
        mDialog = null;
    }

}
