package com.privatee.wjtbaseapp.A_V.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.Base.BaseConfig;
import com.privatee.mylibrary.Widge.AppIntroActivity;
import com.privatee.wjtbaseapp.A_M.A_adapter.MasonryAdapter;
import com.privatee.wjtbaseapp.A_M.A_bean.IconName;
import com.privatee.wjtbaseapp.A_helper.SpacesItemDecoration;
import com.privatee.wjtbaseapp.Activity.BARRActivity;
import com.privatee.wjtbaseapp.Activity.CustomViewTestActivity;
import com.privatee.wjtbaseapp.Activity.EvenBusTestActivity;
import com.privatee.wjtbaseapp.Activity.FileDownLoadActivity;
import com.privatee.wjtbaseapp.Activity.IcReadActivity;
import com.privatee.wjtbaseapp.Activity.ProgressDialogActivity;
import com.privatee.wjtbaseapp.Activity.QRCodeActivity;
import com.privatee.wjtbaseapp.Activity.RecycleListTestActivity;
import com.privatee.wjtbaseapp.Activity.Retrofit_RxJavaActivity;
import com.privatee.wjtbaseapp.Activity.SQLTestActivity;
import com.privatee.wjtbaseapp.Activity.ShareActivity;
import com.privatee.wjtbaseapp.Activity.SytemSetActivity;
import com.privatee.wjtbaseapp.Activity.TCPTestActivity;
import com.privatee.wjtbaseapp.Activity.TwoActivity;
import com.privatee.wjtbaseapp.Activity.WebViewActivity;
import com.privatee.wjtbaseapp.Activity.WeiXinLoginActivity;
import com.privatee.wjtbaseapp.Activity.WjtTestActivity;
import com.privatee.wjtbaseapp.ButterKnifeActivity;
import com.privatee.wjtbaseapp.R;
import java.util.ArrayList;
import java.util.List;

/**
 * 类的作用：瀑布流Activity
 * 包名 com.privatee.wjtbaseapp.A_V.activity
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018-09-25 17:12.
 * 修改历史:
 */
public class PuBuLActivity extends BaseActivity{
    private RecyclerView  recyclerView;
    private List<IconName> productList=new ArrayList<IconName>();

    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_pubu;
    }

    @Override
    public void inintView() {

        BaseConfig.setMainclass(TwoActivity.class);


        recyclerView= (RecyclerView) findViewById(R.id.recycler);
        //设置layoutManager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
        initDataa();
        MasonryAdapter adapter=new MasonryAdapter(productList);
        recyclerView.setAdapter(adapter);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(12);
        recyclerView.addItemDecoration(decoration);

        adapter.setOnItemClickListener(new MasonryAdapter.MyOnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {

                if(productList.get(postion).getIconName().equals("gson测试")){

                }else if(productList.get(postion).getIconName().equals("欢迎页测试下")){

                    Intent intent=new Intent(PuBuLActivity.this, AppIntroActivity.class);
                    int[] wrong = new int[4];
                    wrong[0]=R.layout.a;
                    wrong[1]=R.layout.b;
                    wrong[2]=R.layout.c;
                    wrong[3]=R.layout.d;
                    Bundle b=new Bundle();
                    b.putIntArray("wrong", wrong);
                    intent.putExtras(b);
                    startActivity(intent);

                }else if(productList.get(postion).getIconName().equals("Toast测试")){
                    showToast("hahahah");

                }else if(productList.get(postion).getIconName().equals("listviewscroll")){

                }else if(productList.get(postion).getIconName().equals("自定义雷达图")){

                }else if(productList.get(postion).getIconName().equals("webView测试")){
                    openActivity(WebViewActivity.class);

                }else if(productList.get(postion).getIconName().equals("retrofit_Rxjava测试")){
                    openActivity(Retrofit_RxJavaActivity.class);

                }else if(productList.get(postion).getIconName().equals("开关机设定")){
                    openActivity(SytemSetActivity.class);

                }else if(productList.get(postion).getIconName().equals("测试小刀")){
                    openActivity(ButterKnifeActivity.class);

                }else if(productList.get(postion).getIconName().equals("RecyclerView测试")){
                    openActivity(RecycleListTestActivity.class);

                }else if(productList.get(postion).getIconName().equals("调到two")){
                    openActivity(TwoActivity.class);
                }else if(productList.get(postion).getIconName().equals("进度条弹窗测试")){
                    openActivity(ProgressDialogActivity.class);

                }else if(productList.get(postion).getIconName().equals("bar测试")){
                    openActivity(BARRActivity.class);
                }else if(productList.get(postion).getIconName().equals("下载器测试")){
                    openActivity(FileDownLoadActivity.class);

                }else if(productList.get(postion).getIconName().equals("EvenBus测试")){
                    openActivity(EvenBusTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("分享测试")){
                    openActivity(ShareActivity.class);
                }else if(productList.get(postion).getIconName().equals("长连接")){
                    openActivity(TCPTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("未定义button")){
                    openActivity(CustomViewTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("二维码测试")){
                    openActivity(QRCodeActivity.class);
                }else if(productList.get(postion).getIconName().equals("listviewScroll")){
                    openActivity(WjtTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("自定义控件测试Button")){
                    openActivity(CustomViewTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("让你写一个数据库你会写吗")){
                    openActivity(SQLTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("ic卡读取测试")){
                    openActivity(IcReadActivity.class);
                }else if(productList.get(postion).getIconName().equals("微信登录测试")){
                    openActivity(WeiXinLoginActivity.class);
                }else if(productList.get(postion).getIconName().equals("人脸识别测试")){
                    openActivity(FaceRecognitionActivity.class);
                }else if(productList.get(postion).getIconName().equals("webViewJS交互")){
                    openActivity(JAVA_H5_riActivity.class);
                }else if(productList.get(postion).getIconName().equals("Rxjava测试")){
                    openActivity(RxjavaActivity.class);
                }else if(productList.get(postion).getIconName().equals("serviceBind练习")){
                    openActivity(ServiceBindTestActivity.class);
                    //开关一类的
                }else if(productList.get(postion).getIconName().equals("seekbar控件")){
                    openActivity(SeekBarTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("算法练习")){
                    //创建service
                    openActivity(AlgorithmTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("购物车控件练习可以删除")){
                    //创建service
                    openActivity(GwcTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("自定义dialog")){
                    //创建service
                    openActivity(CustomDialogActivity.class);
                }

            }
        });

    }

    private void initDataa() {
        productList.add(new IconName("gson测试"));
        productList.add(new IconName("欢迎页测试下"));
        productList.add(new IconName("Toast测试"));
        productList.add(new IconName("listviewscroll"));
        productList.add(new IconName("自定义雷达图"));
        productList.add(new IconName("webView测试"));
        productList.add(new IconName("retrofit_Rxjava测试"));
        productList.add(new IconName("开关机设定"));
        productList.add(new IconName("测试小刀"));
        productList.add(new IconName("RecyclerView测试"));
        productList.add(new IconName("调到two"));
        productList.add(new IconName("进度条弹窗测试"));
        productList.add(new IconName("bar测试"));
        productList.add(new IconName("下载器测试"));
        productList.add(new IconName("EvenBus测试"));
        productList.add(new IconName("Green测试"));
        productList.add(new IconName("分享测试"));
        productList.add(new IconName("长连接"));
        productList.add(new IconName("未定义button"));
        productList.add(new IconName("二维码测试"));
        productList.add(new IconName("listviewScroll"));
        productList.add(new IconName("gson测试"));
        productList.add(new IconName("自定义控件测试Button"));
        productList.add(new IconName("让你写一个数据库你会写吗"));
        productList.add(new IconName("ic卡读取测试"));
        productList.add(new IconName("微信登录测试"));
        productList.add(new IconName("人脸识别测试"));
        productList.add(new IconName("webViewJS交互"));
        productList.add(new IconName("Rxjava测试"));//未做
        productList.add(new IconName("serviceBind练习"));//未做
        productList.add(new IconName("seekbar控件"));//未做
        productList.add(new IconName("算法练习"));//未做
        productList.add(new IconName("购物车控件练习可以删除"));//购物车
        productList.add(new IconName("自定义dialog"));//购物车


    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {

    }
}
