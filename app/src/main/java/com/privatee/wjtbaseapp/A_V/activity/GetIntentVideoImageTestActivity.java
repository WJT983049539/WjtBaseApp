package com.privatee.wjtbaseapp.A_V.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.view.View;
import android.widget.ImageView;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

import wseemann.media.FFmpegMediaMetadataRetriever;

public class GetIntentVideoImageTestActivity extends BaseActivity {
    ImageView imageView4;
    @Override
    public String setNowActivityName() {
        return "GetIntentVideoImageTestActivity";
    }

    @Override
    public int setLayout() {
        return R.layout.intentvideo_iamge;
    }

    @Override
    public void inintView() {
        imageView4=fvbi(R.id.imageView4);
    }

    @Override
    public void inintData() {
    //new出对象
        FFmpegMediaMetadataRetriever mmr = new FFmpegMediaMetadataRetriever();
         String mUri=" http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/bipbop_4x3_variant.m3u8";
    //设置数据源
        mmr.setDataSource(mUri);

    //获取媒体文件的专辑标题
        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM);

    //获取媒体文件的专辑艺术家
        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST);

    //获取2秒处的一帧图片（这里的2000000是微秒！！！）
        Bitmap b = mmr.getFrameAtTime(2000000, FFmpegMediaMetadataRetriever.OPTION_CLOSEST);
        imageView4.setImageBitmap(b);
    //释放资源
    }

    @Override
    public void onClick(View view) {

    }



     public static Bitmap getNetVideoBitmap(String videoUrl, Context context) {
        Bitmap bitmap = null;

            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            try {
                //根据url获取缩略图
                //获得第一帧图片
                bitmap = retriever.getFrameAtTime();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } finally {
                retriever.release();
            }


        return bitmap;
    }

}
