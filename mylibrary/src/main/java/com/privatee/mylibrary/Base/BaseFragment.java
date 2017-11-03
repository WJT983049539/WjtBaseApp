package com.privatee.mylibrary.Base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类的作用： 基础Fragment
 * Created by WJT on  2017/10/28 09:31.
 */

public abstract class BaseFragment extends Fragment {

    /**
     * 贴附的activity
     */
    protected Activity mActivity;
    /**
     * 根view
     */
    protected View mRootView;
    /**
     * 是否对用户可见
     */
    protected boolean mIsVisible;
    /* 是否加载完成
     * 当执行完oncreatview,View的初始化方法后方法后即为true
     */
    protected boolean mIsPrepare;

    @Override
    public void onAttach(Context context)
    {
        mActivity = getActivity();
        super.onAttach(context);

    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        mRootView = inflater.inflate(setLayoutResouceId(), container, false);

        getDataforOther(getArguments());

        initView();

        mIsPrepare = true;

        onLazyLoad();

        setListener();

        return mRootView;
    }

    /**
     * @return frament的布局view
     */
    public View getFragmentView(){
        return mRootView;
    }
    /**
     * 初始化数据
     * @author 漆可
     * @date 2016-5-26 下午3:57:48
     * @param arguments 接收到的从其他地方传递过来的参数
     */
    protected void getDataforOther(Bundle arguments)
    {

    }

    /**
     * 初始化View
     * @author
     * @date 2016-5-26 下午3:58:49
     */
    protected void initView()
    {

    }

    /**
     * 设置监听事件
     * @author 漆可
     * @date 2016-5-26 下午3:59:36
     */
    protected void setListener()
    {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        super.setUserVisibleHint(isVisibleToUser);

        this.mIsVisible = isVisibleToUser;

        if (isVisibleToUser)
        {
            onVisibleToUser();
        }
    }

    /**
     * 用户可见时执行的操作
     * @author 漆可
     * @date 2016-5-26 下午4:09:39
     */
    protected void onVisibleToUser()
    {
        if (mIsPrepare && mIsVisible)
        {
            onLazyLoad();
        }
    }

    /**
     * 懒加载，仅当用户可见切view初始化结束后才会执行
     * @author 漆可
     * @date 2016-5-26 下午4:10:20
     */
    protected void onLazyLoad()
    {

    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T fVB(int id)
    {
        if (mRootView == null)
        {
            return null;
        }

        return (T) mRootView.findViewById(id);
    }

    /**
     * 设置根布局资源id
     * @author 漆可
     * @date 2016-5-26 下午3:57:09
     * @return
     */
    protected abstract int setLayoutResouceId();
}
