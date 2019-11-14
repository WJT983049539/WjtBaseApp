package com.privatee.wjtbaseapp.A_V.activity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.utils.EntityVideo;
import com.privatee.mylibrary.utils.FileTools;
import com.privatee.wjtbaseapp.Activity.RecycleListTestActivity;
import com.privatee.wjtbaseapp.Bean.RecyclerViewPartUpdateBean;
import com.privatee.wjtbaseapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//试用ijk播放器，探索ffmpeg编码库
public class IJKPlayerActivity extends BaseActivity {
    private RecyclerView recy_list;
    MyRecyclerAdapter myRecyclerAdapter;

    @Override
    public String setNowActivityName() {
        return "ijk播放器";
    }
    @Override
    public int setLayout() {
        return R.layout.layout_activity_ijkplayer;
    }

    @Override
    public void inintView() {
        recy_list=fvbi(R.id.recy_list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recy_list.setLayoutManager(layoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recy_list.addItemDecoration(divider);



    }

    @Override
    public void inintData() {
        /**
         * 得到所有的视频文件信息
         */
        List<EntityVideo> list= FileTools.getVideoList(this);
        // 设置适配器
        myRecyclerAdapter=new MyRecyclerAdapter(this, list);
        recy_list.setAdapter(myRecyclerAdapter);

    }

    @Override
    public void onClick(View view) {

    }
    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyHolder> {

        private  List<EntityVideo> mDatas;
        public  MyRecyclerAdapter(IJKPlayerActivity recycleListTestActivity, List<EntityVideo> mDatas) {
            this.mDatas=mDatas;

        }
        // 重写onCreateViewHolder方法，返回一个自定义的ViewHolder
        @Override
        public MyRecyclerAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(IJKPlayerActivity.this);
            View view=layoutInflater.inflate(R.layout.item_recyclerview,null);
            MyRecyclerAdapter.MyHolder holder = new MyRecyclerAdapter.MyHolder(view);
            return holder;
        }

        // 填充onCreateViewHolder方法返回的holder中的控件
        @Override
        public void onBindViewHolder(MyRecyclerAdapter.MyHolder holder, int position) {
            holder.textViewa.setText(mDatas.get(position).getPath());
            Log.i("test",mDatas.get(position).getPath());
            Glide.with(IJKPlayerActivity.this).load(mDatas.get(position).getThumbPath()).into(holder.im_icon);
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
            return mDatas.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            private TextView textViewa;
            private ImageView im_icon;
            public MyHolder(View itemView) {
                super(itemView);
                im_icon=itemView.findViewById(R.id.im_icon);
                textViewa=itemView.findViewById(R.id.item_textview);
            }
        }
    }
}
