package com.privatee.wjtbaseapp.A_V.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

import com.privatee.mylibrary.Base.CompatibilityBaseActivity;
import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.wjtbaseapp.A_V.fragment.TestFragment;
import com.privatee.wjtbaseapp.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutTestActivity extends CompatibilityBaseActivity {
    TabLayout mytab;
    ViewPager mViewPager;
    List<String> mTitle;
    List<Fragment> mFragment;
    @Override
    public String setNowActivityName() {
        return "TabLayoutTestActivity";
    }

    @Override
    public int setLayout() {
        return R.layout.activity_tablayout;
    }

    @Override
    public void inintView() {
         mytab=fvbi(R.id.tablayout);
        mViewPager=fvbi(R.id.mViewPager);
    }

    @Override
    public void inintData() {
        addTabToTabLayout();
    }
    /**
     * Description：给TabLayout添加tab，Tab.setIcon()方法可以给Tab添加图片
     */
    private void addTabToTabLayout() {
        mTitle = new ArrayList<>();
        mTitle.add("选项卡一");
        mTitle.add("选项卡二");
        mTitle.add("选项卡三");
        mTitle.add("选项卡四");

        mFragment = new ArrayList<>();
        mFragment.add(new TestFragment());
        mFragment.add(new Fragment());
        mFragment.add(new TestFragment());
        mFragment.add(new Fragment());



        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });


        mytab.addTab(mytab.newTab().setText("选项卡一").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("选项卡二").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("选项卡三").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("选项卡四").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("选项卡五").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("选项卡六").setIcon(R.mipmap.ic_launcher));
        mytab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //添加选中Tab的逻辑
                TaoTools.d("onTabSelected");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            //选中离开的tab
                TaoTools.d("onTabUnselected");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            //再次选中tab的逻辑
                TaoTools.d("onTabReselected");
            }
        });
        mytab.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(2);
    }

    @Override
    public void onClick(View v) {

    }
}
