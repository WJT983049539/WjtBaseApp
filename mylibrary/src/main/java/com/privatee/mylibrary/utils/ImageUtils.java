package com.privatee.mylibrary.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
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
