package com.privatee.wjtbaseapp.A_V.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.Base.BaseConfig;
import com.privatee.mylibrary.Widge.AppIntroActivity;
import com.privatee.wjtbaseapp.A_M.A_adapter.MasonryAdapter;
import com.privatee.wjtbaseapp.A_M.A_bean.IconName;
import com.privatee.wjtbaseapp.A_V.animation.AnimationActivcity;
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
                }else if(productList.get(postion).getIconName().equals("自定义dialog和全局吐司")){
                    //创建service
                    openActivity(CustomDialogActivity.class);
                }else if(productList.get(postion).getIconName().equals("约束布局ConstrainLayout")){
                    //创建service
                    openActivity(ConstrainlayoutTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("GreenDao测试")){
                    //创建service
                    openActivity(GreenDaoTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("地图测试")){//没做
                    //创建service
                }else if(productList.get(postion).getIconName().equals("视频播放器测试")){//没做
                    openActivity(IJKPlayerActivity.class);
                    //创建service
                }else if(productList.get(postion).getIconName().equals("ACache练习")){
                    openActivity(AcacheTestActicity.class);
                    //创建service
                }else if(productList.get(postion).getIconName().equals("直播视频")){// todo 没做

                }else if(productList.get(postion).getIconName().equals("滚动字幕")){//todo 没做
                    openActivity(GDSubtitleActivity.class);
                }else if(productList.get(postion).getIconName().equals("权限获取练习")){
                    openActivity(PermissionTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("P2P连接测试")){//搁置
                    openActivity(P2PTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("支付宝支付练习")){//todo 没做
                    openActivity(AirpayTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("xposed框架运行时截取练习")){//todo 没做
                    openActivity(XposedTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("文件上传下载")) {//todo 没做
                    openActivity(XposedTestActivity.class);
                }
                else if(productList.get(postion).getIconName().equals("fragment管理")) {//todo 没做
                    openActivity(FragmentManageActivity.class);
                }
                else if(productList.get(postion).getIconName().equals("TabLayout测试实战")) {
                    openActivity(TabLayoutTestActivity.class);
                }
                else if(productList.get(postion).getIconName().equals("BottomSheet测试")) {
                    openActivity(BottomSheetActivity.class);
                }
                else if(productList.get(postion).getIconName().equals("BottomSheetFragment测试")) {//todo 没做
                    openActivity(BottomSheetTestActivity.class);
                }
                else if(productList.get(postion).getIconName().equals("日历测试")) {//todo 没做
//                    openActivity(RiliActivity.class);
                }
                else if(productList.get(postion).getIconName().equals("构建者模式练习")) {//todo 没做
                    openActivity(BuilderModelExerciseActivity.class);
                }
                else if(productList.get(postion).getIconName().equals("闹钟例子")) {//todo 没做
                    openActivity(AlarmClockTestActivity.class);
                }else if(productList.get(postion).getIconName().equals("获取短信和联系人信息")) {//todo 没做
//                    openActivity(GetContactAndSMSInfoActivity.class);
                }
                else if(productList.get(postion).getIconName().equals("自定义view练习")) {//todo 没做
                    openActivity(CustomViewTestActivity.class);
                }
                else if(productList.get(postion).getIconName().equals("获取网络视频的略缩图")) {//todo 没做
                    openActivity(GetIntentVideoImageTestActivity.class);
                }
                else if(productList.get(postion).getIconName().equals("DiaLogActivity")) {//todo 没做
                    openActivity(DialogActivity.class);
                }
                else if(productList.get(postion).getIconName().equals("动画练习")) {
                    openActivity(AnimationActivcity.class);
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
        productList.add(new IconName("自定义dialog和全局吐司"));//购物车
        productList.add(new IconName("约束布局ConstrainLayout"));//购物车
        productList.add(new IconName("GreenDao测试"));//GreenDao练习
        productList.add(new IconName("地图测试"));
        productList.add(new IconName("视频播放器测试"));
        productList.add(new IconName("ACache练习"));
        productList.add(new IconName("滚动字幕"));
        productList.add(new IconName("权限获取练习"));
        productList.add(new IconName("P2P连接测试"));
        productList.add(new IconName("支付宝支付练习"));
        productList.add(new IconName("xposed框架运行时截取练习"));
        productList.add(new IconName("fragment管理"));
        productList.add(new IconName("TabLayout测试实战"));
        productList.add(new IconName("BottomSheet测试"));
        productList.add(new IconName("日历测试"));
        productList.add(new IconName("BottomSheetFragment测试"));
        productList.add(new IconName("构建者模式练习"));
        productList.add(new IconName("闹钟例子"));
        productList.add(new IconName("获取短信和联系人信息"));
        productList.add(new IconName("获取网络视频的略缩图"));
        productList.add(new IconName("DiaLogActivity"));
        productList.add(new IconName("动画练习"));

    }


    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {

    }
}
