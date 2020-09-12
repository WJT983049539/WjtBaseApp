package com.privatee.mylibrary.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:create by wjt
 * 邮箱 983049539@qq.com
 */
public class ImageHelper {
    /**
     * 通过绝对路径获取图片的私有存储路径
     * 将图片复制到私有目录下，下次加载、删除啥的就没有影响了
     * 但是注意删除的仅是app私有的数据，并不是真正删除相册的图片
     * 存在部分图片能查到uri但是无法正常加载，故需要判断一下
     * 如果返回路径为空，则跳过该图片，并提示用户手动在系统相册中将图片添加至相册再重试
     * @param context 上下文
     * @param path 图片绝对路径（直接获取到的）
     * @return String 返回一个复制到私有路径下相同的图片路径
     * */
    public static String coverFromBitmap(Context context, String path){
        Bitmap bitmap=SuperSuitWay(context,path);
        if(bitmap==null){
            return "";
        }
        return compressImage(context,bitmap).getAbsolutePath();
    }

    /**
     * 把bitmap写入app私有目录下
     * @param context 上下文
     * @param bitmap 这个bitmap不能为null
     * @return File
     * */
    private static File compressImage(Context context, Bitmap bitmap) {
        String filename;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        //图片名
        filename = format.format(date);
        final File[] dirs = context.getExternalFilesDirs("Documents");
        File primaryDir = null;
        if (dirs != null && dirs.length > 0) {
            primaryDir = dirs[0];
        }
        File file = new File(primaryDir.getAbsolutePath(), filename + ".png");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            try {
                fos.write(baos.toByteArray());
                fos.flush();
                fos.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        // recycleBitmap(bitmap);
        return file;
    }
    /**
     * 通过绝对路径获取bitmap
     * 适配安卓Q使用绝对路径无法正确加载的问题
     * @param context 上下文
     * @param path 绝对路径
     * @return Bitmap
     * */
    private static Bitmap SuperSuitWay(Context context,String path){
        Uri external = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[] { MediaStore.Images.Media._ID }, MediaStore.Images.Media.DATA + "=? ",
                new String[] { path }, null);
        Uri imageUri = null;
        if (cursor != null && cursor.moveToFirst()) {
            imageUri = ContentUris.withAppendedId(external, cursor.getLong(0));
            cursor.close();
        }
        ParcelFileDescriptor pfd = null;
        if (imageUri != null) {
            try {
                pfd = context.getContentResolver().openFileDescriptor(imageUri, "r");
                if (pfd != null) {
                    Bitmap bitmap = BitmapFactory.decodeFileDescriptor(pfd.getFileDescriptor());
                    return bitmap;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (pfd != null) {
                        pfd.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
