package com.privatee.wjtbaseapp.A_tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.privatee.wjtbaseapp.A_V.customview.xRecyclerView;
import com.privatee.wjtbaseapp.Activity.RecycleListTestActivity;
import com.privatee.wjtbaseapp.R;

import java.util.List;

/**
 * @author:create by
 * 邮箱 983049539@qq.com
 */
public class MyAdapter2 extends xRecyclerView.xAdapter<MyAdapter2.MyHolder> {
    private Context context;
    private List<String > list;
    public  MyAdapter2( List<String > list){
        this.context=context;
        this.list=list;
    }

    @Override
    protected int getxItemCount() {
        return list.size();
    }

    @Override
    protected MyHolder onCreatexViewHolder(ViewGroup viewGroup, int itemType) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    protected void onBindxViewHolder(MyHolder holder, int position) {
        holder.test_item_tv.setText(list.get(position));
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView test_item_tv;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            test_item_tv=itemView.findViewById(R.id.test_item_tv);
        }
    }
}
