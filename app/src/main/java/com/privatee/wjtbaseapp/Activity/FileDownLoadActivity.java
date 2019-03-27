package com.privatee.wjtbaseapp.Activity;

import android.os.Environment;
import android.view.View;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.Widge.NumberProgressBar;
import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：下载器demo
 * Created by WJT on  2018/4/16 17:32.
 */

public class FileDownLoadActivity extends BaseActivity {
    private NumberProgressBar progressBar;
    String Url="http://baobab.kaiyanapp.com/api/v1/playUrl?vid=97187&editionType=high&source=qcloud";
    String Url2="http://a.wdjcdn.com/release/files/phoenix/5.51.20.13150/wandoujia-wandoujia-web_seo_google_binded_5.51.20.13150.apk";
    @Override
    public String setNowActivityName() {
        return "下载器";
    }

    @Override
    public int setLayout() {
        return R.layout.activity_download;
    }

    @Override
    public void inintView() {
        progressBar=fvbi(R.id.down_progress);
        String path= Environment.getExternalStorageDirectory()+"/"+"testDown/"+"test.mp4";
        FileDownloader.getImpl().create(Url).setWifiRequired(true).setPath(path).setListener(new FileDownloadListener() {
            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                TaoTools.i("pending  soFarBytes="+soFarBytes);

            }
            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                int percent=(int) ((double) soFarBytes / (double) totalBytes * 100);
                TaoTools.i("("+percent+"%"+")");
                     progressBar.setProgress(percent);
            }

            @Override
            protected void completed(BaseDownloadTask task) {
                TaoTools.i("completed");
            }

            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                TaoTools.i("paused");
            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {
                TaoTools.i("error="+e.toString());
            }

            @Override
            protected void warn(BaseDownloadTask task) {
                TaoTools.i("warn");
            }
        }).start();
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View view) {

    }
}
