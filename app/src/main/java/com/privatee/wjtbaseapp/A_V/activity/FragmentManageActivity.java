package com.privatee.wjtbaseapp.A_V.activity;

import android.graphics.Color;
import androidx.annotation.NonNull;
import android.view.View;

import com.liang.jtablayout.tab.Tab;
import com.liang.widget.JTabLayout;
import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.wjtbaseapp.R;

/**
 * fragment管理
 * @author wjt
 * @date 2019/7/22 8:43
 * @contact 983049539@qq.com
 */
public class FragmentManageActivity extends BaseActivity {
    @Override
    public String setNowActivityName() {
        return "fragment管理类";
    }

    @Override
    public int setLayout() {
        return R.layout.activity_fragmentmanager;
    }

    @Override
    public void inintView() {

        /**
         * TabView.setIcon(R.mipmap.tab_icon_normal, R.mipmap.tab_icon_selected);选项卡图标
         * TabView.setTitle("娱乐");选项卡文本
         * TabView.setObject(Object);选项卡自定义内容
         * TabView.setTitleColor(); 选项卡切换状态时的字体颜色
         * TabView.setBackgroundRes(); 选项卡背景
         * TabView.setSelected(); 选项卡状态
         * TabView.setTextTransitionMode();字体颜色改变方式
         * TabView.setBold();选项卡选中时字体是否变粗
         * TabView.setTextSize();选项卡字体大小
         * TabView.setBadgeTextColor();选项卡角标的字体颜色
         * TabView.setBadgeTextSize();选项卡角标的字体大小
         * TabView.setBadgeColor();选项卡角标的背景颜色
         * TabView.setBadgeStroke(width,color);选项卡角标的边框宽度和边框颜色
         */
        JTabLayout tabLayout=findViewById(R.id.tablayout1);
        Tab tabItem=tabLayout.newTab();
        tabItem.setIcon(R.mipmap.loading_icon, R.mipmap.ic_launcher);
        tabItem.setTabBackgroundResId(R.color.white);
        tabItem.setTitleColor(Color.parseColor("#808080"),Color.parseColor("#0d7bdf"));
        tabLayout.addTab(tabItem );
        Tab tabItem2=tabLayout.newTab();
        tabItem2.setTitle("学习");
        tabLayout.addTab(tabItem2 );
        tabItem2.setTabBackgroundResId(R.color.white);
        tabItem2.setTitleColor(Color.parseColor("#808080"),Color.parseColor("#0d7bdf"));
        Tab tabItem3=tabLayout.newTab();
        tabItem3.setTitle("实践");
        tabItem3.setTabTextBold(true);
        tabLayout.addTab(tabItem3 );
        tabItem3.setTitleColor(Color.parseColor("#808080"),Color.parseColor("#0d7bdf"));
        tabItem3.setTabBackgroundResId(R.color.white);



        JTabLayout jTabLayout2=fvbi(R.id.tablayout2);
        Tab tabitemm=jTabLayout2.newTab();
        tabitemm.setTitle("学习");
        tabitemm.setBadgeTextColor(Color.parseColor("#4601fe"));

        jTabLayout2.addTab(tabitemm);
        Tab tabitemm2=jTabLayout2.newTab();
        tabitemm2.setTitle("实践");
        jTabLayout2.addTab(tabitemm2);
        Tab tabitemm3=jTabLayout2.newTab();
        tabitemm3.setTitle("运用");
        jTabLayout2.addTab(tabitemm3);
        jTabLayout2.setBadgeColor(Color.parseColor("#4601fe"));
        tabLayout.addOnTabSelectedListener(new JTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(@NonNull Tab var1) {
                //当切换时回调


                TaoTools.d("onTabSelected");
            }

            @Override
            public void onTabUnselected(@NonNull Tab var1) {
                TaoTools.d("onTabUnselected");
                //离开选中了

            }

            @Override
            public void onTabReselected(@NonNull Tab var1) {
                //当重复选中时回调
                TaoTools.d("onTabReselected");
            }
        });

    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {

    }
}
