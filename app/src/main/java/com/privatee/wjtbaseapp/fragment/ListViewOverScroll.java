package com.privatee.wjtbaseapp.fragment;

import android.widget.ArrayAdapter;

import com.privatee.mylibrary.Base.CompatibleBaseFragment;
import com.privatee.wjtbaseapp.CustomView.OverScrollView;
import com.privatee.wjtbaseapp.R;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 类的作用：
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/7/3 10:51.
 */
public class ListViewOverScroll extends CompatibleBaseFragment{


    private String[] mStrings = {"Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler"};
    private LinkedList<String> mListItems;
    private OverScrollView mListView;
    private ArrayAdapter<String> mAdapter;
    @Override
    public String setNowfragmentName() {
        return null;
    }

    @Override
    public void initView() {
        mListView = (OverScrollView) fvbi(R.id.listview);
        //配置Adapter
        mListItems = new LinkedList<String>();
        mListItems.addAll(Arrays.asList(mStrings));
        mAdapter = new ArrayAdapter<String>(getActivity(),R.layout.item_layout, mListItems);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void inintData() {

    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.layout_listview_scroll_test;
    }
}
