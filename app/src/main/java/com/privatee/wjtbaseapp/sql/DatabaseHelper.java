package com.privatee.wjtbaseapp.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 类的作用：主要做数据库的创建和版本控制
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/29 10:30.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String name="count";//数据库名称
    private static final int version = 1; //数据库版本
    //第三个参数CursorFactory指定在执行查询时获得一个游标实例的工厂类,设置为null,代表使用系统默认的工厂类
    public DatabaseHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS bianqian (bianqianId integer primary key autoincrement, bianqianTile varchar(20), BianqianContent varchar(20),BianqianTime varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion==1 && newVersion==2) {//升级判断,如果再升级就要再加两个判断,从1到3,从2到3
            db.execSQL("ALTER TABLE person ADD phone TEXT;");
        }
    }
}