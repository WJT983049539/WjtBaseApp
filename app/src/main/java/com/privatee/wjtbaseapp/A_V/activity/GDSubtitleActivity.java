package com.privatee.wjtbaseapp.A_V.activity;

import android.Manifest;
import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.Nullable;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import com.privatee.mylibrary.utils.FileTools;
import com.privatee.wjtbaseapp.A_tools.ScrollTextSurfaceView;
import com.privatee.wjtbaseapp.R;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.functions.Consumer;


import static com.tencent.smtt.sdk.TbsReaderView.TAG;

/**
 * @auther wjt
 * @date 2019/6/10
 */
public class GDSubtitleActivity extends Activity {
    ScrollView scrollView;
    TextView text;
    int height=0;
    int off=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_subtitle);
        inintView();
    }


    public void inintView() {
        requestPermissions(this);
        String [] sa=FileTools.getExtSDCardPath(this);
//        String textConten=FileTools.getString(sa[0]+"/","Tips.txt");
        String textConten=FileTools.getString(Environment.getExternalStorageDirectory() + "/media/text/" , "Tips.txt");
//
        try {
            AssetManager mgr = getAssets();
            Typeface tmp = Typeface.createFromAsset(mgr, "font/" + "songti.ttf");
        ScrollTextSurfaceView scrollTextSurfaceView=findViewById(R.id.surfaceView);
        scrollTextSurfaceView.displayParametersInit(textConten, 50, 0xFF1f5eef, tmp,90);
        scrollTextSurfaceView.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        scrollView=findViewById(R.id.test_scrollview);
//        text=findViewById(R.id.textView9);
//        AssetManager assets = getAssets();
//        Typeface fromAsset = Typeface.createFromAsset(assets, "font/kaiti.ttf");
//        text.setTypeface(fromAsset);
//        text.setText(textConten);
//        text.setTextSize(60);
//        text.setTextColor(0xFF1f5eef);
//
//
//
//        mThread mThread=new mThread();
//        mThread.start();
    }


    public  void requestPermissions(final Activity activity) {
        RxPermissions rxPermission = new RxPermissions(activity);
        rxPermission.requestEach(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.INTERNET,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.REQUEST_INSTALL_PACKAGES,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {

                            // 用户已经同意该权限
                            Log.d(TAG, permission.name + " 用户已经同意该权限.");
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                            Log.d(TAG, permission.name + " 用户拒绝了该权限");
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』
                        }

                    }
                });
    }


//
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if(event.getEventTime()-onclickfirst<500){
//                onclick++;
//                TaoTools.i("onclick=="+onclick);
//                onclickfirst=event.getEventTime();
//
//                if(onclick==5){
//                    //连续点击5次成功转到设置页面
//                    startActivity(new Intent(Settings.ACTION_SETTINGS));
//                    TaoTools.i("点击了5次了");
//                    return false;
//                }
//            }else {
//                onclickfirst=event.getEventTime();
//                onclick=0;
//            }
//
//        }
//
//        return true;
//
//    }
//    long onclickfirst=0;
//    int onclick=0;



    class mThread extends Thread{
        @Override
        public void run() {
            super.run();
            do {
                try {
                    Thread.sleep(100);
                    height = text.getHeight();
                    Log.d("test","Textheight="+ height);
                    Log.d("test","off="+ off);
                    off=off+1;
                    if(off> height){
                        off = 1;
                    }
                    Message msg = new Message();
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            scrollView.scrollTo(0,off);
        }
    };
}
