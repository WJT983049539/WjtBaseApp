package com.privatee.wjtbaseapp.fragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：
 * Created by WJT on  2018/3/2 09:10.
 */

public class WebViewFragment extends Fragment {


    private WebView webView;
    private View Mview;
/*

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getActivity().getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
//                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
                }
*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Mview = inflater.inflate(R.layout.fragment_webview_test, container, false);
        webView = Mview.findViewById(R.id.test_webview);
        inint();
        String url = Environment.getExternalStorageDirectory() + "/" + "201802281042392313" + "/" + "index.html";
        webView.loadUrl("file:///" + url);

        return Mview;
    }
   /* @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }*/

    private void inint() {

        webView.setDrawingCacheEnabled(true); //设置可截屏
        WebSettings webSettings = webView.getSettings();
        // 设置WebView属性，能够执行Javascript脚本

        webView.setInitialScale(100);

        //自适应
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH); // 提高渲染的优先级
        // 设置可以访问文件
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportZoom(true);  //支持缩放，默认为true。是下面那个的前提。
        // 设置此属性，可任意比例缩放
        webSettings.setLoadWithOverviewMode(true);

//        // 设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webView.setWebChromeClient(new WebChromeClient());
        //硬件加速
//        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        //设置后退
        webView.canGoBack();
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 不加载缓存内容
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.getSettings().setUseWideViewPort(true);
//        webView.addJavascriptInterface(new AndroidtoJsPersonCenter(getActivity()), "ibpd");//AndroidtoJS类对象映射到js的test对象
        // webView.setInitialScale(100);
        // 设置Web视图

        webView.setWebViewClient(new MyWebviewCient() {
            @Override
            public void onReceivedError(WebView webView, int i, String s, String s1) {
                //网页加载失败的处理，一般是出错图片，跳转到出错处理页面
                super.onReceivedError(webView, i, s, s1);
            }
        });
    }

    public class MyWebviewCient extends WebViewClient {
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            WebResourceResponse response = null;
            response = super.shouldInterceptRequest(view, url);
            return response;
        }

        /* （非 Javadoc）
         * @see android.webkit.WebViewClient#onPageFinished(android.webkit.WebView, java.lang.String)
         */
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            view.loadUrl("javascript:(function() { var videos = document.getElementsByTagName('video'); " +
                    "for(var i=0;i<videos.length;i++){videos[i].play();}})()");
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String s) {
//            FragmentTransaction transaction=getActivity().getFragmentManager().beginTransaction();
//            NewWebFragment newWebFragment=new NewWebFragment();
//            newWebFragment.setinfo(s);
//            transaction.replace(R.id.main_content_fragment,newWebFragment);
//            transaction.commitAllowingStateLoss();
            webView.loadUrl(s);
            return true;

        }
    }
}
