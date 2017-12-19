package com.privatee.mylibrary.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * 类的作用：App的版本号和名
 * Created by WJT on  2017/12/12 09:48.
 */

public class AppVersionUtil {



        public static String getVersionName(Context context) {
            try {
                PackageManager manager = context.getPackageManager();
                PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
                String versionName = info.versionName;
                TaoTools.i("versionName" + versionName);
                return versionName;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        /**
         * 获取版本号
         * int
         * @return 当前应用的版本号
         */
        public static int getVersionCode(Context context) {
            try {
                PackageManager manager = context.getPackageManager();
                PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
                int versionCode = info.versionCode;
                TaoTools.i("versionCode" + versionCode);
                return versionCode;
            } catch (Exception e) {
                e.printStackTrace();
                return 1;
            }
        }


}
