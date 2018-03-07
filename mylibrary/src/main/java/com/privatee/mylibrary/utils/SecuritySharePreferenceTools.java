package com.privatee.mylibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

import static com.privatee.mylibrary.utils.TaoTools.FILE_NAME;

/**
 * 类的作用：加密的共享参数工具
 * Created by WJT on  2018/3/7 17:44.
 */

public class SecuritySharePreferenceTools {

    public static void putValuetoSP(Context context, String key, Object object){
        SecuritySharedPreference securitySharedPreference = new SecuritySharedPreference(context,FILE_NAME, Context.MODE_PRIVATE);
        SecuritySharedPreference.SecurityEditor securityEditor = securitySharedPreference.edit();
        if (object instanceof String) {
            securityEditor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            securityEditor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            securityEditor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            securityEditor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            securityEditor.putLong(key, (Long) object);
        } else {
            securityEditor.putString(key, object.toString());
        }

        securityEditor.apply();

    }
    /**
     * 从共享参数中取值，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object getValueofSP(Context context, String key, Object defaultObject) {
        SecuritySharedPreference securitySharedPreference = new SecuritySharedPreference(context,FILE_NAME, Context.MODE_PRIVATE);
        SecuritySharedPreference.SecurityEditor securityEditor = securitySharedPreference.edit();

        if (defaultObject instanceof String) {
            return securitySharedPreference.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return securitySharedPreference.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return securitySharedPreference.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return securitySharedPreference.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return securitySharedPreference.getLong(key, (Long) defaultObject);
        }

        return null;
    }



    /**
     * 移除某个key值已经对应的共享参数的值
     *
     * @param context
     * @param key
     */
    public static void removeValueforSP(Context context, String key) {
        SecuritySharedPreference securitySharedPreference = new SecuritySharedPreference(context,FILE_NAME, Context.MODE_PRIVATE);
        SecuritySharedPreference.SecurityEditor securityEditor = securitySharedPreference.edit();
        securityEditor.remove(key);
        securityEditor.apply();
    }




    /**
     * 清除所有共享参数数据
     *
     * @param context
     */
    public static void clearAllSPvalue(Context context) {
        SecuritySharedPreference securitySharedPreference = new SecuritySharedPreference(context,FILE_NAME, Context.MODE_PRIVATE);
        SecuritySharedPreference.SecurityEditor securityEditor = securitySharedPreference.edit();
        securityEditor.clear();
        securityEditor.apply();
    }


    /**
     * 查询某个key是否已经存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean containsofSP(Context context, String key) {
        SecuritySharedPreference securitySharedPreference = new SecuritySharedPreference(context,FILE_NAME, Context.MODE_PRIVATE);
        return securitySharedPreference.contains(key);
    }

    /**
     * 返回所有的共享参数键值对
     *
     * @param context
     * @return
     */
    public static Map<String, ?> getAllofSP(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getAll();
    }

}
