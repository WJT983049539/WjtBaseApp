package com.privatee.wjtbaseapp.A_tools;

import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedHookUtil implements IXposedHookLoadPackage {
    String class_name = "com.privatee.wjtbaseapp.A_V.activity.XposedTestActivity";
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        Log.i("test","到达XposedHoodUtil");
        Class clazz = loadPackageParam.classLoader.loadClass(class_name);
        XposedHelpers.findAndHookMethod(clazz, "getGG", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                return "广告被拦截了";
            }
        });
    }

}
