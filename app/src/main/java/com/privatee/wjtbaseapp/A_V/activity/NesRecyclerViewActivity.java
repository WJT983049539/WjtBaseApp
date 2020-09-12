package com.privatee.wjtbaseapp.A_V.activity;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.A_V.customview.xRecyclerView;
import com.privatee.wjtbaseapp.A_tools.MyAdapter2;
import com.privatee.wjtbaseapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:create by
 * 邮箱 983049539@qq.com
 */
public class NesRecyclerViewActivity extends BaseActivity {
    private xRecyclerView rvNestedScrollView;
    private MyAdapter2 myAdapter;
    List<String> list=new ArrayList<String>();

    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.activity_nesreclist;
    }

    @Override
    public void inintView() {
        list.clear();
        rvNestedScrollView=fvbi(R.id.rvNestedScrollView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        initData();
        myAdapter=new MyAdapter2(list);
        rvNestedScrollView.setAdapter(myAdapter);
        rvNestedScrollView.setListener(new xRecyclerView.xAdapterListener() {
            @Override
            public void startRefresh() {
                //下拉刷新
                rvNestedScrollView.startRefreshing();
                myAdapter.notifyDataSetChanged();
                rvNestedScrollView.stopRefreshing();
            }

            @Override
            public void startLoadMore() {
            //上拉加载
                initData();
                rvNestedScrollView.stopLoadingMore();
            }
        });

    }

    private void initData() {
        for(int i=0;i<10;i++){
            list.add("数据"+i);
        }
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View view) {

    }
}
