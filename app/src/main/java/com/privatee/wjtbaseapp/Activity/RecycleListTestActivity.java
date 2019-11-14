package com.privatee.wjtbaseapp.Activity;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.Bean.RecyclerViewPartUpdateBean;
import com.privatee.wjtbaseapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 类的作用：RecyclerView的各种写法，练习，比如拖拽，自定义item,局部更新，定时跟新
 * Created by WJT on  2018/1/29 10:08.
 */

    public class    RecycleListTestActivity extends BaseActivity{

    private List<String> mDatas=new ArrayList<>();
    private List<RecyclerViewPartUpdateBean> mDatas2=new ArrayList<RecyclerViewPartUpdateBean>();

    private RecyclerView recyclerview_test;
    private TextView testText;
    MyRecyclerAdapter myRecyclerAdapter;

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
        testText=fvbi(R.id.testText);
        testText.setOnClickListener(this);
        //创建布局管理器，主要是运用在布局方向:(横向布局，纵向布局，瀑布流布局)
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        //放入布局管理器
        recyclerview_test.setLayoutManager(layoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerview_test.addItemDecoration(divider);

    }

    @Override
    public void inintData() {
        getData();
        // 设置适配器
        myRecyclerAdapter=new MyRecyclerAdapter(this, mDatas2);
        recyclerview_test.setAdapter(myRecyclerAdapter);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.testText){
//            int index=mDatas.indexOf("测试2");
            RecyclerViewPartUpdateBean bean=new RecyclerViewPartUpdateBean();
            bean.setAge("2");
            bean.setName("zhang2");
            RecyclerViewPartUpdateBean bean2=new RecyclerViewPartUpdateBean();
            bean2.setAge("替换的数据");
            bean2.setName("替换的数据");
//            mDatas2.set(0,bean);

           Boolean flag= mDatas2.contains(bean);
            Collections.replaceAll(mDatas2, bean, bean2);
            Log.i("test",mDatas2.size()+"");

            int index=mDatas2.indexOf(bean2);
            if(myRecyclerAdapter!=null){
                myRecyclerAdapter.notifyItemChanged(index,"wocao");
            }

        }
    }

    public void getData() {

        for(int i=0;i<100;i++){
            mDatas.add("测试"+i);
        }

        for(int j=0;j<50;j++){
            RecyclerViewPartUpdateBean bean=new RecyclerViewPartUpdateBean();
            bean.setAge(j+"");
            bean.setName("zhang"+j);
            mDatas2.add(bean);
        }
    }


    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyHolder> {
        private RecycleListTestActivity recycleListTestActivity;
        private  List<RecyclerViewPartUpdateBean> mDatass;
        public  MyRecyclerAdapter(RecycleListTestActivity recycleListTestActivity, List<RecyclerViewPartUpdateBean> mDatas) {
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
            holder.textViewa.setText(mDatass.get(position).getName());
        }

//        /**
//         * 局部更新的方法
//         * @param holder
//         * @param position
//         * @param payloads
//         */
//        @Override
//        public void onBindViewHolder(MyHolder holder, int position, List<Object> payloads) {
//            //如果是空的话更新整个界面
//            if(payloads.isEmpty()){
//                onBindViewHolder(holder,position);//绑定数据
//
//            }else{//刷新局部改变的
//
//                for(int i=0;i<payloads.size();i++){
//                    String strig= (String) payloads.get(i);
//                }
//
//            }
//
//            super.onBindViewHolder(holder, position, payloads);
//        }

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
