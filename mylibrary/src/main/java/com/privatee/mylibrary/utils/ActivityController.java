package com.privatee.mylibrary.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的作用：管理activity的类
 * Created by WJT on  2017/10/27 18:50.
 */

public class ActivityController {

    private static List<Activity> activities=new ArrayList<Activity>();
    /**
     * 获取栈list
     */

    public static List<Activity> getActivities(){
        return activities;
    }
    /**
     * 加入Activity
     */
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    /**
     * 移除Activity
     * @param activity
     */

    public static void RemoveActivity(Activity activity){
        activities.remove(activity);
    }
    /**
     * 移除所有的Activity
     */
    public  static void RemoveAllActivity(){
        //遍历集合
        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }

    public static void RemoveOtherActivity(Activity activity2){
        for(Activity activity:activities){
            if(!activity.equals(activity2)){
                activity.finish();
            }
        }
    }

}
