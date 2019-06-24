package com.privatee.wjtbaseapp.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的作用：
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/29 12:13.
 */
public class BianQianService {
    private SQLiteDatabase database=null;
    public  BianQianService(Context context){
        database=new DatabaseHelper(context).getWritableDatabase();
    }
    /**
     * 添加数据
     * 使用的是拼写sql语句来通过sqlitedatabase对象来执行 ，sql语句 字符串需要用 ' ' 括起来
     * @param bianqian
     * @return
     */
    public  boolean insertBianQian(BianQian  bianqian){
        boolean  flag=false;
        //准备insert语句
        StringBuilder  insertBianQian=new StringBuilder();
        insertBianQian.append("insert  into bianqian values(null,'");
        insertBianQian.append(bianqian.getBianqianTile()+"','");
        insertBianQian.append(bianqian.getBianqianContent()+"','");
        insertBianQian.append(bianqian.getBianqianTime()+"');");
        System.out.println(insertBianQian.toString());
        try{
            database.execSQL(insertBianQian.toString());
            Log.i("WJT", "增加sql代码"+insertBianQian.toString());
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
            flag=false;
        }
        database.close();
        return flag;
    }


    /**
     * 删除操作
     * 使用拼写sql语句通过sqlitedatabase对象来执行
     */
    public boolean deleteBianQian(int id){
        boolean flag=false;
        String Delete="delete from bianqian where bianqianId="+id+";";
        try{
            database.execSQL(Delete);
            Log.i("WJT","删除代码"+Delete.toString());
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            flag=false;
        }
        database.close();
        return  flag;

    }
    /**
     * 更改，通过拼写字符串 通过sqlitedatabase对象来执行sql代码
     */
    public boolean updateBianqian(BianQian bianQian){
        boolean  flag=false;
        StringBuilder  update=new  StringBuilder();
        update.append("update bianqian set bianqianTile='");
        update.append(bianQian.getBianqianTile()+"',BianqianContent='");
        update.append(bianQian.getBianqianContent()+"',BianqianTime='");
        update.append(bianQian.getBianqianTime()+"'");
        update.append(" where BianqianId=");
        update.append(bianQian.getBianqianId()+";");
        Log.i("WJT","更新代码"+update.toString());
        try{
            database.execSQL(update.toString());
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            flag=false;
        }
        return flag;
    }
    /**
     * 查询 所有数据
     * 通过rawQuery 查询所有的数据的到的游标，使用过游标移动下一行
     * cursor.getColumnIndex（键）得到本行的本列的键的对象
     * 然后通过游标的get方法得到具体的值
     */
    public List<BianQian> queryAllDate(){
        List<BianQian>list=new ArrayList<BianQian>();
        list.clear();
        String select="select * from bianqian";
        Cursor cursor=database.rawQuery(select,null);
        while(cursor.moveToNext()){
            int idd=cursor.getInt(cursor.getColumnIndex("bianqianId"));
            String bianqianTitle=cursor.getString(cursor.getColumnIndex("bianqianTile"));
            String BianqianTime=cursor.getString(cursor.getColumnIndex("BianqianTime"));
            String BianqianContent=cursor.getString(cursor.getColumnIndex("BianqianContent"));
            BianQian bianQian=new BianQian();
            bianQian.setBianqianId(idd);
            bianQian.setBianqianContent(BianqianContent);
            bianQian.setBianqianTile(bianqianTitle);
            bianQian.setBianqianTime(BianqianTime);
            list.add(bianQian);
        }
        cursor.close();database.close();
        return list;
    }
}
