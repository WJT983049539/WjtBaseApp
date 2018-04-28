package com.privatee.wjtbaseapp;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.privatee.mylibrary.Base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的作用：
 * Created by WJT on  2018/1/29 10:08.
 */

    public class    RecycleListTestActivity extends BaseActivity{

    private List<String> mDatas=new ArrayList<>();

    private RecyclerView recyclerview_test;

    @Override
    public String setNowActivityName() {
        return "循环view，listView变形";
    }

    @Override
    public int setLayout() {
        return R.layout.activity_recycle;
    }

    @Override
    public void inintView() {
        recyclerview_test=fvbi(R.id.recyclerview_test);
        //创建布局管理器，主要是运用在布局方向:(横向布局，纵向布局，瀑布流布局)
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        //放入布局管理器
        recyclerview_test.setLayoutManager(layoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerview_test.addItemDecoration(divider);

    }

    @Override
    public void inintData() {
        for(int i=0;i<100;i++){
            mDatas.add(""+i);
        }
        // 设置适配器
        recyclerview_test.setAdapter(new MyRecyclerAdapter(this, mDatas));
    }

    @Override
    public void onClick(View view) {

    }


    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyHolder> {
        private RecycleListTestActivity recycleListTestActivity;
        private  List<String> mDatass;
        public MyRecyclerAdapter(RecycleListTestActivity recycleListTestActivity, List<String> mDatas) {
            mDatass=mDatas;
            this.recycleListTestActivity=recycleListTestActivity;

        }
        // 重写onCreateViewHolder方法，返回一个自定义的ViewHolder
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(recycleListTestActivity);
            View view=layoutInflater.inflate(R.layout.item_recyclerview,null);
            MyHolder holder = new MyHolder(view);
            return holder;
        }

        // 填充onCreateViewHolder方法返回的holder中的控件
        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.textViewa.setText(mDatass.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatass.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            private TextView textViewa;
            public MyHolder(View itemView) {
                super(itemView);
                textViewa=itemView.findViewById(R.id.item_textview);
            }
        }
    }
}
