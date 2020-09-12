package com.privatee.mylibrary.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.WeakHashMap;

/**
 * 类的作用：图片相关的工具类
 * Created by WJT on  2017/11/9 14:21.
 */

public class ImageUtils {
    private WeakHashMap<Integer, WeakReference<Bitmap>> mBitmaps;
    private WeakHashMap<Integer, WeakReference<Drawable>> mDrawables;
    private Context mContext;
    // 下载图片，最大边长
    public static int MIN_SIDE_LENGTH = 256;
    // 是否重新计算压缩比
    public static boolean isComputeSampleSize = false;

    private static final long POLY64REV = 0x95AC9329AC4BC9B5L;
    private static final long INITIALCRC = 0xFFFFFFFFFFFFFFFFL;

    private static long[] sCrcTable = new long[256];

    public ImageUtils(Context context) {
        mContext = context.getApplicationContext();
        mBitmaps = new WeakHashMap<Integer, WeakReference<Bitmap>>();
        mDrawables = new WeakHashMap<Integer, WeakReference<Drawable>>();
    }

    /**
     * 根据私有路径加载
     * @param context 上下文
     * @param path 这个路径一定是私有路径，即应用自己的目录下（data/包名）
     * @return Drawable 用来设置背景什么的
     * */
    public static Drawable getByPrivatePath(Context context,String path){
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        Drawable drawable = new BitmapDrawable(context.getResources(), bitmap);
        return drawable;
    }


    /**
     * 把bitmap写入app私有目录下
     * @param context 上下文
     * @param bitmap 这个bitmap不能为null
     * @return File
     * 适配到4.4
     * */
    private static File compressImage(Context context, Bitmap bitmap) {
        String filename;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date(System.currentTimeMillis());
            //图片名
            filename = format.format(date);
        }else {
            Date date=new Date();
            filename=date.getYear()+date.getMonth()+date.getDate()+date.getHours()+date.getMinutes()+date.getSeconds()+"";
        }

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
     * 根据drawable id获取Bitmap
     *
     * @param resource
     * @return
     */
    public Bitmap getBitmap(int resource) {
        if (!mBitmaps.containsKey(resource) && mContext != null) {
            mBitmaps.put(resource, new WeakReference<Bitmap>(
                    readDrawableBitmap(mContext, resource)));
        }
        return ((WeakReference<Bitmap>) mBitmaps.get(resource)).get();
    }


//    /**
//     *bitmap转drawable
//     * @param uri
//     * @param mcontext
//     * @return
//     */
//    public static Drawable bitmapToDrawble(Uri uri, Context mcontext){
//        Drawable drawable = new BitmapDrawable(mcontext.getResources(), getBitmapFromUri(mcontext, uri));
//        return drawable;
//    }


    /**
     * 保存文件
     * @param bm
     * @throws IOException
     */
    public static String saveFile(Bitmap bm) throws IOException {
        String path= Environment.getExternalStorageDirectory()+"/temp/"+Math.abs(Math.random())+".jpg";
        File myCaptureFile = new File(path);
        if(!myCaptureFile.exists()){
            myCaptureFile.createNewFile();
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
        return path;
    }



    /**
     * 以最省内存的方式读取本地资源的图片
     *
     * @param context
     * @param resId
     * @return
     */
    public static Bitmap readDrawableBitmap(Context context, int resId) {
        final BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        // 获取资源图片
        final InputStream is = context.getResources().openRawResource(resId);
        final Bitmap bitmap = BitmapFactory.decodeStream(is, null, opt);

        try {
            if (is != null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /**
     * 根据 路径 得到 file 得到 bitmap
     * @param filePath
     * @return
     * @throws IOException
     */
    public static Bitmap decodeFile(String filePath) throws IOException{
        Bitmap b = null;
        int IMAGE_MAX_SIZE = 600;

        File f = new File(filePath);
        if (f == null){
            return null;
        }
        //Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;

        FileInputStream fis = new FileInputStream(f);
        BitmapFactory.decodeStream(fis, null, o);
        fis.close();

        int scale = 1;
        if (o.outHeight > IMAGE_MAX_SIZE || o.outWidth > IMAGE_MAX_SIZE) {
            scale = (int) Math.pow(2, (int) Math.round(Math.log(IMAGE_MAX_SIZE / (double) Math.max(o.outHeight, o.outWidth)) / Math.log(0.5)));
        }

        //Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        fis = new FileInputStream(f);
        b = BitmapFactory.decodeStream(fis, null, o2);
        fis.close();
        return b;
    }


}
