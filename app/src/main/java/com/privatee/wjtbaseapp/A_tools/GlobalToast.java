package com.privatee.wjtbaseapp.A_tools;

import android.annotation.SuppressLint;
import android.app.Application;
import android.widget.Toast;

import com.privatee.wjtbaseapp.BaseAppaction;

/**
 * 全局Toast，不会频繁显示
 * @auther wjt
 * @date 2019/5/25
 */
public class GlobalToast {
    private static Toast toast = null;
    private static Application sContext;
    public static void init(BaseAppaction application) {
        sContext = application;
    }
    @SuppressLint("ShowToast")
    public static void show(CharSequence sequence, int toastDuration){
        if (toast == null) {
            toast = Toast.makeText(sContext, sequence, toastDuration);
        } else {
            toast.cancel();
            toast.setText(sequence);
            toast = Toast.makeText(sContext, sequence, Toast.LENGTH_LONG);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();

    }

}
