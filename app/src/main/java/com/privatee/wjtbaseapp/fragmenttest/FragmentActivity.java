package com.privatee.wjtbaseapp.fragmenttest;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.privatee.mylibrary.Base.CompatibilityBaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/7/2 10:12.
 */
public class FragmentActivity extends CompatibilityBaseActivity{
    private  FragmentManager.OnBackStackChangedListener listener;
    @Override
    public String setNowActivityName() {
        return "fragment测试";
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_test;
    }

    @Override
    public void inintView() {


        FragmentManager manager = getSupportFragmentManager();
        listener= new FragmentManager.OnBackStackChangedListener() {

            @Override
            public void onBackStackChanged() {
                Log.e("wjt","回退栈改变了");
            }
        };
        manager.addOnBackStackChangedListener(listener);



        fvbi(R.id.btn_add_frag1).setOnClickListener(this);
        fvbi(R.id.btn_add_frag2).setOnClickListener(this);
        fvbi(R.id.btn_add_frag3).setOnClickListener(this);
        fvbi(R.id.btn_add_frag4).setOnClickListener(this);
        fvbi(R.id.button_popbackstack).setOnClickListener(this);
        fvbi(R.id.button_BackToFrag).setOnClickListener(this);
        fvbi(R.id.button_BackToStack2_INCLUSIVE).setOnClickListener(this);
        fvbi(R.id.receple_button).setOnClickListener(this);





    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //添加fragment1
            case R.id.btn_add_frag1:
                OneFragment fragment1 = new OneFragment();
                addFragment(fragment1, "fragmentOne");
                break;
            //添加fragment2
            case R.id.btn_add_frag2:
                TwoFragment fragment2 = new TwoFragment();
                addFragment(fragment2, "fragmentTwo");
                break;
                //移除fragment2
            case R.id.btn_add_frag3:
                ThreeFragment fragment3 = new ThreeFragment();
                addFragment(fragment3, "fragmentThree");
                break;
            case R.id.btn_add_frag4:
                FourFragment fragment4 = new FourFragment();
                addFragment(fragment4, "fragmentFour");
                break;
            case R.id.button_popbackstack:
                //回滚是以提交的事务为单位进行的！提交一次事物，不管加了多少层，回退都直接退了
                FragmentManager manager = getSupportFragmentManager();
                manager.popBackStack();//最顶层的fragment去掉
                break;
            case R.id.button_BackToFrag:
                FragmentManager manager2 = getSupportFragmentManager();
                //不带自己，第二个参数的意义
                manager2.popBackStack("fragmentTwo",0);//方法一,将fragmentTwo设为顶栈，剩下的全部删除退栈
                break;
            case R.id.button_BackToStack2_INCLUSIVE:
                FragmentManager manager3 = getSupportFragmentManager();
                //连带fragmentTwo一块出栈，带自己
                manager3.popBackStack("fragmentTwo",FragmentManager.POP_BACK_STACK_INCLUSIVE);//方法一,通过TAG回退

                //替换一下是不是把One以外的都顶替了
            case R.id.receple_button:
                FragmentManager manager4 = getSupportFragmentManager();
                TwoFragment fragmentOO = new TwoFragment();
                FragmentTransaction transaction = manager4.beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentOO, "fragmentTwo");
                transaction.addToBackStack("fragmentTwo");//添加到回退窄
                transaction.commitAllowingStateLoss();

                break;
        }
    }
    //添加fragment
    private void addFragment(Fragment fragment, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, fragment, tag);
        transaction.addToBackStack(tag);//添加到回退窄
        transaction.commit();
    }
    //移除
    private void removeFragment2() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag("fragmentTwo");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }
    private void replaceFragment1() {
        FragmentManager manager = getSupportFragmentManager();
        TwoFragment fragment2 = new TwoFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment2);
        transaction.commit();
    }




    protected void onDestroy() {
        super.onDestroy();
        FragmentManager manager = getSupportFragmentManager();
        manager.removeOnBackStackChangedListener(listener);
    }


}
