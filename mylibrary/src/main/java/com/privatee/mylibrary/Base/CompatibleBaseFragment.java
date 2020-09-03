package com.privatee.mylibrary.Base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.privatee.mylibrary.utils.TaoTools;

/**
 * 类的作用： 兼容基础Fragment v4
 * Created by WJT on  2017/10/28 09:31.
 */

public abstract class CompatibleBaseFragment extends Fragment{

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
        TaoTools.i("在"+setNowfragmentName()+"的onAttach方法中");
        mActivity = getActivity();
        super.onAttach(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setNowfragmentName();
        TaoTools.i("在"+setNowfragmentName()+"的onCreate方法");

    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        TaoTools.i("在"+setNowfragmentName()+"的onCreateView方法中");
        mRootView = inflater.inflate(setLayoutResouceId(), container, false);

        getDataforOther(getArguments());

        initView();
        inintData();
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
     * 标识本fragment
     * @return
     */
    public abstract String setNowfragmentName();
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
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void inintData();

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
    protected <T extends View> T fvbi(int id)
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
