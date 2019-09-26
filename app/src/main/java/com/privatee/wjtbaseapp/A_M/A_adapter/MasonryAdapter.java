package com.privatee.wjtbaseapp.A_M.A_adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.privatee.wjtbaseapp.A_M.A_bean.IconName;
import com.privatee.wjtbaseapp.R;

import java.util.List;

/**
 * 类的作用：
 * 包名 com.privatee.wjtbaseapp.A_M.A_adapter
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018-09-25 17:49.
 * 修改历史:
 */
public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView>{
    private List<IconName> products;
    private MyOnItemClickListener listener;

    public MasonryAdapter(List<IconName> list) {
        products=list;
    }



    public void setOnItemClickListener(MyOnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.masonry_item, parent, false);
        return new MasonryView(view,listener) ;
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
        masonryView.textView.setText(products.get(position).getIconName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    //增加一项
    public void addData(int position,IconName iconName) {
        products.add(position, iconName);
        notifyItemInserted(position);
    }

    //删除一项
    public void removeData(int position) {
        products.remove(position);
        notifyItemRemoved(position);
    }



        public  class MasonryView extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;

         private MyOnItemClickListener mListener;// 声明自定义的接口

        public MasonryView(View itemView,MyOnItemClickListener mListener){
            super(itemView);
            this.mListener=mListener;
            // 为ItemView添加点击事件
            itemView.setOnClickListener(this);
            textView= (TextView) itemView.findViewById(R.id.masonry_item_title);
        }

            @Override
            public void onClick(View v) {
                mListener.onItemClick(v, getLayoutPosition());
            }
        }

        //声明自定义接口
        public interface MyOnItemClickListener{
            public void onItemClick(View view, int postion);
        }

}
