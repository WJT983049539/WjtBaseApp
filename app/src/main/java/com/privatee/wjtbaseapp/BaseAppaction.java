package com.privatee.wjtbaseapp;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * 类的作用：
 * Created by WJT on  2017/12/19 09:52.
 */

public class BaseAppaction extends Application{
    private static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        //配置数据库
        setupDatabase();
    }


    //配置数据库
    private void setupDatabase() {
        //创建数据库shop.db"
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "XSYStudentInfo.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }
}
