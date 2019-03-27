package com.privatee.wjtbaseapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.Base.BaseConfig;
import com.privatee.mylibrary.Widge.AppIntroActivity;
import com.privatee.wjtbaseapp.A_V.activity.PuBuLActivity;
import com.privatee.wjtbaseapp.ButterKnifeActivity;
import com.privatee.wjtbaseapp.R;
import com.privatee.wjtbaseapp.fragmenttest.FragmentActivity;

public class MainActivity extends BaseActivity {
    private TextView aaa;
    private Button welcome_button;
    private Button toast_button;
    private Button webview_button;
    private Button retrofit_rx_button;
    private Button Sysatem_button;
    private Button kk_button;
    private Button recycle_button;
    private Button gotwo_button;
    private Button progtess_button;
    private Button download_button;
    private Button rich_text;
    private Button tcp_button;
    private Button action_barr;


    @Override
    public String setNowActivityName() {
        return "第一个";
    }

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inintView() {
        BaseConfig.setMainclass(TwoActivity.class);
        aaa=fvbi(R.id.aaa);
        aaa.setOnClickListener(this);
        welcome_button=fvbi(R.id.welcome_button);
        welcome_button.setOnClickListener(this);
        toast_button=fvbi(R.id.toast_button);
        toast_button.setOnClickListener(this);
        webview_button=fvbi(R.id.webview_button);
        webview_button.setOnClickListener(this);
        retrofit_rx_button=fvbi(R.id.retrofit_rx_button);
        retrofit_rx_button.setOnClickListener(this);
        Sysatem_button=fvbi(R.id.Sysatem_button);
        Sysatem_button.setOnClickListener(this);
        kk_button=fvbi(R.id.kk_button);
        kk_button.setOnClickListener(this);
        recycle_button=fvbi(R.id.recycle_button);
        recycle_button.setOnClickListener(this);
        gotwo_button=fvbi(R.id.gotwo_button);
        gotwo_button.setOnClickListener(this);
        progtess_button=fvbi(R.id.progtess_button);
        progtess_button.setOnClickListener(this);
        fvbi(R.id.download_button).setOnClickListener(this);
        fvbi(R.id.share_button).setOnClickListener(this);
        fvbi(R.id.tcp_button).setOnClickListener(this);
        fvbi(R.id.action_barr).setOnClickListener(this);
        fvbi(R.id.qrcode_button).setOnClickListener(this);
        fvbi(R.id.gsonTest).setOnClickListener(this);
        fvbi(R.id.custom_button).setOnClickListener(this);
        fvbi(R.id.evenbus_button).setOnClickListener(this);
        fvbi(R.id.green_button).setOnClickListener(this);
        fvbi(R.id.sqldate_button).setOnClickListener(this);
        fvbi(R.id.fragment_button).setOnClickListener(this);
        fvbi(R.id.listviewscroll).setOnClickListener(this);
        fvbi(R.id.no_defined_button).setOnClickListener(this);
        fvbi(R.id.weixinLogin).setOnClickListener(this);
        fvbi(R.id.custom_view_radar).setOnClickListener(this);
        fvbi(R.id.readic_button).setOnClickListener(this);
        fvbi(R.id.androidCOM_iccard_test_button).setOnClickListener(this);
        fvbi(R.id.facetest).setOnClickListener(this);
    }

    @Override
        public void inintData() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.aaa:
//                openActivity(RecycleListTestActivity.class);
                this.finish();
            break;

            /**
             * 首页展示的欢迎页，首先需要在 设置欢迎页后面的页面Activity(也就是主Activity),然后需要加载四个需要播放的页面布局，
             * 分别命名为 a b c d.通过bundle 传播数组传过去。
             *  BaseConfig.setMainclass(TwoActivity.class);
             */
            case R.id.welcome_button:
                Intent intent=new Intent(this, AppIntroActivity.class);
                int[] wrong = new int[4];
                wrong[0]=R.layout.a;
                wrong[1]=R.layout.b;
                wrong[2]=R.layout.c;
                wrong[3]=R.layout.d;
                Bundle b=new Bundle();
                b.putIntArray("wrong", wrong);
                intent.putExtras(b);
                startActivity(intent);
                break;
            case  R.id.toast_button:
                showToast("hahahah");
                break;
            case R.id.webview_button:
                openActivity(WebViewActivity.class);
            break;
            /**
             * 网络请求框架retrofit_rxjava练习
             */
            case R.id.retrofit_rx_button:

                openActivity(Retrofit_RxJavaActivity.class);
                break;
            /**
             * 测试开关机
             */
            case R.id.Sysatem_button:
                openActivity(SytemSetActivity.class);
                break;
            /**
             * Knifez注入测试
             */
            case R.id.kk_button:
                openActivity(ButterKnifeActivity.class);
                break;
            case R.id.recycle_button:
                openActivity(RecycleListTestActivity.class);
                break;
            case R.id.gotwo_button:
                openActivity(TwoActivity.class);
                break;
            //进度条dialog测试
            case R.id.progtess_button:
                openActivity(ProgressDialogActivity.class);
                break;
            //下载测试
            case R.id.download_button:
                openActivity(FileDownLoadActivity.class);
                break;
            case R.id.share_button:
                openActivity(ShareActivity.class);
                break;
            //长连接，心跳包测试
            case R.id.tcp_button:
                openActivity(TCPTestActivity.class);
                break;
            case R.id.action_barr:
                openActivity(BARRActivity.class);
                break;
            case R.id.qrcode_button:
                openActivity(QRCodeActivity.class);
                break;
            case R.id.gsonTest:
                openActivity(GsonTestActivity.class);
                break;
            case R.id.custom_button:
                openActivity(CustomViewTestActivity.class);
                break;
                //evenbus练习
            case R.id.evenbus_button:
                openActivity(EvenBusTestActivity.class);
                break;
            case R.id.green_button:
                //greenDao数据库测试
                break;
                //自己写一个数据库
            case R.id.sqldate_button:
                openActivity(SQLTestActivity.class);
                break;
            case R.id.fragment_button:
                openActivity(FragmentActivity.class);
                break;
            case R.id.listviewscroll:
                openActivity(WjtTestActivity.class);
                break;
            case R.id.no_defined_button:
                //练习的类
//                 openActivity(CasuallyActivity.class);
                openActivity(PuBuLActivity.class);
                break;
                //微信登录测试按钮
            case R.id.weixinLogin:
                openActivity(WeiXinLoginActivity.class);
                break;
                //自定义雷达图
            case R.id.custom_view_radar:
                openActivity(RadarActivity.class);
                break;
                //ic卡读取测试
            case R.id.readic_button:
                openActivity(IcReadActivity.class);
                break;
                //安卓读卡测试
            case R.id.androidCOM_iccard_test_button:
                openActivity(AndroidCOMTestActivity.class);
                break;
            case R.id.facetest:
                openActivity(FaceDomeTestActivity.class);
                break;
        }
    }
}
