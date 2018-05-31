package com.privatee.mylibrary.Base;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.XLog;
import com.elvishew.xlog.printer.AndroidPrinter;
import com.elvishew.xlog.printer.ConsolePrinter;
import com.elvishew.xlog.printer.Printer;
import com.elvishew.xlog.printer.file.FilePrinter;
import com.elvishew.xlog.printer.file.naming.DateFileNameGenerator;
import com.privatee.mylibrary.utils.UpdateManager;

import java.io.File;

/**
 * 类的作用：设置全局参数
 * Created by WJT on  2017/10/27 19:51.
 */

public class BaseAndroid {

    public static BaseConfig baseConfig;

    public static void init(BaseConfig config) {
        baseConfig = config;
        initaa();
    }

    private static void initaa() {
        LogConfiguration config = new LogConfiguration.Builder()
                .tag("XSY")//制定TAG
                .t() // 允许打印线程信息，默认禁止
                .st(2) // 允许打印深度为2的调用栈信息，默认禁止
                .b() // 允许打印日志边框，默认禁止
                .build();
        Printer androidPrinter = new AndroidPrinter();             // 通过 android.util.Log 打印日志的打印器
        Printer consolePrinter = new ConsolePrinter();             // 通过 System.out 打印日志到控制台的打印器
        Printer filePrinter = new FilePrinter                      // 打印日志到文件的打印器
                .Builder("/sdcard/xlog/")                         // 指定保存日志文件的路径
                .fileNameGenerator(new DateFileNameGenerator())
                .build();    // 指定日志文件名生成器，默认为 ChangelessFileNameGenerator("log")

        XLog.init(                                                 // 初始化 XLog
                config,                                                // 指定日志配置，如果不指定，会默认使用 new LogConfiguration.Builder().build()
                androidPrinter,                                        // 添加任意多的打印器。如果没有添加任何打印器，会默认使用 AndroidPrinter(Android)/ConsolePrinter(java)
                consolePrinter,
                filePrinter);


    }

    public static BaseConfig getBaseConfig() {
        if (baseConfig == null) {
            throw new IllegalArgumentException("请先调用init方法");
        }
        return baseConfig;
    }

    /**
     * 版本更新
     *
     * @param context
     * @param versionCode   版本号
     * @param url           apk下载地址
     * @param updateMessage 更新内容
     * @param isForced      是否强制更新
     */
    public static void checkUpdate(Context context, int versionCode, String url, String updateMessage, boolean isForced) {
        if (versionCode > UpdateManager.getInstance().getVersionCode(context)) {
            int type = 0;//更新方式，0：引导更新，1：安装更新，2：强制更新
            if (UpdateManager.getInstance().isWifi(context)) {
                type = 1;
            }
            if (isForced) {
                type = 2;
            }
            //检测是否已下载
            String downLoadPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/downloads/";
            File dir = new File(downLoadPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String fileName = url.substring(url.lastIndexOf("/") + 1, url.length());
            if (fileName == null && TextUtils.isEmpty(fileName) && !fileName.contains(".apk")) {
                fileName = context.getPackageName() + ".apk";
            }
            File file = new File(downLoadPath + fileName);

            //设置参数
            UpdateManager.getInstance().setType(type).setUrl(url).setUpdateMessage(updateMessage).setFileName(fileName).setIsDownload(file.exists());
            if (type == 1 && !file.exists()) {
                UpdateManager.getInstance().downloadFile(context);
            } else {
                UpdateManager.getInstance().showDialog(context);
            }
        }
    }
}
