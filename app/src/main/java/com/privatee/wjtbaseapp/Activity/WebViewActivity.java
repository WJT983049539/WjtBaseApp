package com.privatee.wjtbaseapp.Activity;

import android.graphics.PixelFormat;
import android.view.View;
import android.view.WindowManager;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.Bean.MessageEvent;
import com.privatee.wjtbaseapp.R;

import org.greenrobot.eventbus.EventBus;

/**
 * 类的作用：
 * Created by WJT on  2018/3/2 10:02.
 */

public class WebViewActivity extends BaseActivity{
//    private WebView tbsContent;
    private String url = "https://www.jianshu.com/p/d3ef9c62b6c8";
    @Override
    public String setNowActivityName() {
        return "webview测试类";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_webtest;
    }

    @Override
    public void inintView() {
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

//        tbsContent = (com.tencent.smtt.sdk.WebView)findViewById(R.id.wbtest);
//        tbsContent.loadUrl(url);
//        WebSettings webSettings = tbsContent.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        tbsContent.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
        fvbi(R.id.textView2).setOnClickListener(this);

    }

    @Override
    public void inintData() {

    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.textView2){
        EventBus.getDefault().post(new MessageEvent("wo shi WebView C传过来的数据啊啊啊 啊啊啊啊啊   啊啊啊啊啊啊 "));
        this.finish();
        }
    }
}
