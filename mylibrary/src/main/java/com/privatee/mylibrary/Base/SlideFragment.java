package com.privatee.mylibrary.Base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类的作用：引导页fragment
 * Created by WJT on  2018/2/27 09:08.
 */

public class SlideFragment extends Fragment {
    private static final String ARG_LAYOUT_RES_ID = "layoutResId";
    //新建实例
    public static SlideFragment newInstance (int layoutResId){
        SlideFragment slideFragment=new SlideFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        slideFragment.setArguments(bundle);
        return slideFragment;
    }

    private int LayoutResId;
    public SlideFragment(){}


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments()!=null&&getArguments().containsKey(ARG_LAYOUT_RES_ID)){

            LayoutResId=getArguments().getInt(ARG_LAYOUT_RES_ID);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(LayoutResId,container,false);
    }


}
