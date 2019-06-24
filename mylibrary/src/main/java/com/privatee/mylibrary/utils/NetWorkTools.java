package com.privatee.mylibrary.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;


/**
 * 类的作用：网络工具类
 * Created by WJT on  2017/11/16 19:30.
 */

public class NetWorkTools {

    /**
     * 判断网络是否连接
     *
     * @param context 上下文
     * @return boolean 网络连接状态 ，打印网络类型日志打印
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            //获取连接对象
            if (mNetworkInfo != null) {
                //判断是TYPE_MOBILE网络
                if(ConnectivityManager.TYPE_MOBILE == mNetworkInfo.getType()){
                    TaoTools.i( "网络连接类型为：TYPE_MOBILE");
                    //判断移动网络连接状态
                    NetworkInfo.State STATE_MOBILE = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
                    if (STATE_MOBILE == NetworkInfo.State.CONNECTED) {
                        TaoTools.i(  "网络连接类型为：TYPE_MOBILE, 网络连接状态CONNECTED成功！");
                        return mNetworkInfo.isAvailable();
                    }
                }
                //判断是TYPE_WIFI网络
                if(ConnectivityManager.TYPE_WIFI == mNetworkInfo.getType()){
                    TaoTools.i( "网络连接类型为：TYPE_WIFI");
                    //判断WIFI网络状态
                    NetworkInfo.State STATE_WIFI = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
                    if (STATE_WIFI == NetworkInfo.State.CONNECTED) {
                        TaoTools.i( "网络连接类型为：TYPE_WIFI, 网络连接状态CONNECTED成功！");
                        return mNetworkInfo.isAvailable();
                    }
                }
            }
        }
        return false;
    }


    /**
     * 打开网络设置界面
     *
     * @param activity Activity
     */
    public static void openNetSetting(Activity activity) {
        Intent intent = new Intent("/");
        ComponentName cm = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
        intent.setComponent(cm);
        intent.setAction("android.intent.action.VIEW");
        activity.startActivityForResult(intent, 0);
    }

    /**
     * 判断当前网络的类型是否是移动网络
     *
     * @param context 上下文
     * @return 当前网络的类型是否是移动网络。false：当前没有网络连接或者网络类型不是移动网络
     */
    public static boolean isMobileByType(Context context) {
        return getCurrentNetworkType(context) ==
                ConnectivityManager.TYPE_MOBILE;
    }


    /**
     * 获取当前网络的类型
     *
     * @param context 上下文
     * @return 当前网络的类型。具体类型可参照ConnectivityManager中的TYPE_BLUETOOTH、TYPE_MOBILE、TYPE_WIFI等字段。当前没有网络连接时返回NetworkUtils.NETWORK_TYPE_NO_CONNECTION
     */
    public static int getCurrentNetworkType(Context context) {
        NetworkInfo networkInfo
                = ((ConnectivityManager) context.getSystemService(
                Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return networkInfo != null
                ? networkInfo.getType()
                : NETWORK_TYPE_NO_CONNECTION;
    }




    //未找到合适匹配网络类型
    public static final int TYPE_NO = 0;

    //中国移动CMNET网络(中国移动GPRS接入方式之一, 主要为PC、笔记本电脑、PDA设立)
    public static final int TYPE_MOBILE_CMNET = 1;

    //中国移动CMWAP网络(中国移动GPRS接入方式之一,主要为手机WAP上网而设立)
    public static final int TYPE_MOBILE_CMWAP = 2;

    //中国联通UNIWAP网络(中国联通划分GPRS接入方式之一, 主要为手机WAP上网而设立)
    public static final int TYPE_MOBILE_UNIWAP = 3;

    //中国联通3GWAP网络
    public static final int TYPE_MOBILE_3GWAP = 4;

    //中国联通3HNET网络
    public static final int TYPE_MOBLIE_3GNET = 5;

    //中国联通UNINET网络(中国联通划分GPRS接入方式之一, 主要为PC、笔记本电脑、PDA设立)
    public static final int TYPE_MOBILE_UNINET = 6;

    //中国电信CTWAP网络
    public static final int TYPE_MOBILE_CTWAP = 7;

    //中国电信CTNET网络
    public static final int TYPE_MOBILE_CTNET = 8;

    //WIFI网络
    public static final int TYPE_WIFI = 10;

    /**
     * 网络类型 - 无连接
     */
    public static final int NETWORK_TYPE_NO_CONNECTION = -1231545315;

    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final String NETWORK_TYPE_3G = "eg";
    public static final String NETWORK_TYPE_2G = "2g";
    public static final String NETWORK_TYPE_WAP = "wap";
    public static final String NETWORK_TYPE_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_DISCONNECT = "disconnect";
    private static NetworkInterface networkInterface;





    /**
     * 得到mac地址
     * @param context
     * @return
     */
    public static String getLocalMacAddressFromWifiInfo(Context context){
        String Macadd;
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        Macadd=info.getMacAddress();
        if(Macadd.equals("02:00:00:00:00:00"))
        {
            Macadd = getMacAddr();
        }
        return Macadd;


    }


    /**
     * 得到ip地址
     * @param context
     * @return
     */

    public static String getLocalIpAddressFromWifiInfo(Context context){
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        int i=info.getIpAddress();
        return (i & 0xFF )+"."+((i >> 8 ) & 0xFF)+"."+((i >>16) & 0xFF)+"."+( i >> 24 & 0xFF) ;
    }


    /**
     * 信号强度
     * 获取连接速度，可以让用户获知这一信息。这里得到信号强度就靠wifiinfo.getRssi()；这个方法。得到的值是一个0到-100的区间值，是一个int型数据，其中0到-50表示信号最好，-50到-70表示信号偏差，小于-70表示最差，有可能连接不上或者掉线，一般Wifi已断则值为-200
     * @param context
     * @return
     */
    public static int getWifiRssi(Context context){
        WifiManager wifi_service = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifi_service.getConnectionInfo();
//		wifiInfo.getBSSID();
//		wifiInfo.getSSID();
//		wifiInfo.getIpAddress();//获取IP地址。
//		wifiInfo.getMacAddress();//获取MAC地址。
//		wifiInfo.getNetworkId();//获取网络ID。
//		wifiInfo.getLinkSpeed();
        return wifiInfo.getRssi();//
    }






    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:",b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "02:00:00:00:00:00";
    }

    /**
     * 判断一个字符串是否是一个合法的ip地址：
     *    1 首先检查字符串的长度 最短应该是0.0.0.0 7位 最长 000.000.000.000 15位
     *    2 尝试按.符号进行拆分     拆分结果应该是4段
     *    3 查看拆分到的每一个子字符串，应该都是纯数字
     *    4 对拆分结果转成整数 判断 应该是0到255之间的整数
     *    5 经过各种磨砺之后 挺过来了！！！返回true
     */
    public static boolean check_ip(String str){
        // 1 首先检查字符串的长度 最短应该是0.0.0.0 7位 最长 000.000.000.000 15位
        if(str.length()<7 || str.length() >15) {
            return false;    // 如果长度不符合条件 返回false
        }

        // 2 尝试按.符号进行拆分     拆分结果应该是4段
        String[] arr = str.split("\\.");
        if( arr.length != 4 ) {
            return false;    //如果拆分结果不是4个字串 返回false
        }

        // 3 查看拆分到的每一个子字符串，应该都是纯数字
        for(int i = 0 ; i <4 ; i++ ){
            for(int j = 0; j<arr[i].length();j++){
                char temp = arr[i].charAt(j);
                if(!( temp>'0' && temp< '9' ) ) {
                    return false;    //如果某个字符不是数字就返回false
                }
            }
        }

        // 4 对拆分结果转成整数 判断 应该是0到255之间的整数
        for(int i = 0 ; i<4;i++){
            int temp = Integer.parseInt( arr[i] );
            if( temp<0 || temp >255) {
                return false;    //如果某个数字不是0到255之间的数 就返回false
            }
        }

        // 5 经过各种磨砺之后 挺过来了！！！返回true
        return true;
    }

}
