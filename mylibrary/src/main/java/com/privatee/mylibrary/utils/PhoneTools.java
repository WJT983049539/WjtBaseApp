package com.privatee.mylibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.WindowManager;

import java.io.File;
import java.util.List;

/**
 * 类的作用：手机相关的工具类
 * Created by WJT on  2017/12/12 10:00.
 */

public class PhoneTools {


    /**
     * 获取手机系统版本号
     *
     * @return
     */
    public int getSDKVersionNumber() {
        int sdkVersion;
        try {
            sdkVersion = Integer.valueOf(android.os.Build.VERSION.SDK_INT);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            sdkVersion = 0;
        }
        return sdkVersion;
    }

    /**
     * 获取手机型号
     */
    public String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机宽度
     */
    @SuppressWarnings("deprecation")
    public int getPhoneWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    /**
     * 获取手机高度
     *
     * @param context
     */
    @SuppressWarnings("deprecation")
    public int getPhoneHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }

    /**
     * 获取手机imei串号 ,GSM手机的 IMEI 和 CDMA手机的 MEID.
     *
     * @param context
     */
    public String getPhoneImei(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null)
            return null;
        return tm.getDeviceId();
    }

    /**
     * 获取手机sim卡号
     *
     * @param context
     */
    public String getPhoneSim(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null)
            return null;
        return tm.getSubscriberId();
    }

    /**
     * 获取手机号
     *
     * @param context
     */
    public String getPhoneNum(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null)
            return null;
        return tm.getLine1Number();
    }

    /**
     * 判断sd卡是否挂载
     */
    public boolean isSDCardMount() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取sd卡剩余空间的大小
     */
    @SuppressWarnings("deprecation")
    public long getSDFreeSize() {
        File path = Environment.getExternalStorageDirectory(); // 取得SD卡文件路径
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize(); // 获取单个数据块的大小(Byte)
        long freeBlocks = sf.getAvailableBlocks();// 空闲的数据块的数量
        // 返回SD卡空闲大小
        return (freeBlocks * blockSize) / 1024 / 1024; // 单位MB
    }

    /**
     * 获取sd卡空间的总大小
     */
    @SuppressWarnings("deprecation")
    public long getSDAllSize() {
        File path = Environment.getExternalStorageDirectory(); // 取得SD卡文件路径
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize(); // 获取单个数据块的大小(Byte)
        long allBlocks = sf.getBlockCount(); // 获取所有数据块数
        // 返回SD卡大小
        return (allBlocks * blockSize) / 1024 / 1024; // 单位MB
    }

    /**
     * 判断是否是平板
     */
    public boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    /**
     * 判断一个apk是否安装
     *
     * @param context
     * @param packageName
     */
    public boolean isApkInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packageName, 0);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 跳转至系统设置界面
     *
     * @param mContext
     *            上下文
     */
    public static void toSettingActivity(Context mContext) {
        Intent settingsIntent = new Intent(Settings.ACTION_SETTINGS);
        mContext.startActivity(settingsIntent);
    }

    /**
     * 跳转至WIFI设置界面
     *
     * @param mContext
     *            上下文
     */
    public static void toWIFISettingActivity(Context mContext) {
        Intent wifiSettingsIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        mContext.startActivity(wifiSettingsIntent);
    }

    /**
     * Gps是否打开
     *
     * @param context
     * @return
     */
    public static boolean isGpsEnabled(Context context) {
        LocationManager locationManager = ((LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE));
        List<String> accessibleProviders = locationManager.getProviders(true);
        return accessibleProviders != null && accessibleProviders.size() > 0;
    }

}
