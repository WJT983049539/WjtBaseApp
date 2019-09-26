package com.privatee.wjtbaseapp.Activity;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.xhapimanager.XHApiManager;
import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

import java.util.List;

/**
 * 类的作用：随便测试的类，随便练习的类
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/7/18 17:09.
 */
public class CasuallyActivity extends BaseActivity{
//    private RecyclerView recyclerview_mytest;
    private Button setoffontime;

    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.layout_mycasually;
    }

    @Override
    public void inintView() {
//        recyclerview_mytest=fvbi(R.id.recyclerview_mytest);
////        myAdapter=new MyAdapter();
////        recyclerview_mytest.setAdapter();
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
//        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
//        recyclerview_mytest.addItemDecoration(divider);
//        //放入布局管理器
//        recyclerview_mytest.setLayoutManager(layoutManager);
        setoffontime=fvbi(R.id.setoffontime);
        setoffontime.setOnClickListener(this);
    }

    @Override
    public void inintData() {
//        List<String > list=new ArrayList<String>();
//        list.clear();
//        for(int i=0;i<100;i++){
//            list.add(""+i);
//        }
//        recyclerview_mytest.setAdapter(new MyAdapter(this,list));
//        DefaultItemAnimator defaultItemAnimator=new DefaultItemAnimator();
//        defaultItemAnimator.setAddDuration(1000);
//        defaultItemAnimator.setRemoveDuration(1000);
//        recyclerview_mytest.setItemAnimator(defaultItemAnimator);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.setoffontime){
            XHApiManager xhApiManager = new XHApiManager();
            xhApiManager.XHSetPowerOffOnTime("2018-09-04-18-04","",true);
            xhApiManager.XHSetPowerOffOnTime("","2018-09-04-18-09",true);
            Toast.makeText(CasuallyActivity.this,"设置完毕等待关机",Toast.LENGTH_LONG).show();
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<VH>{
        Context context;
        List<String> list=null;
        public MyAdapter(Context context, List<String> list) {
            this.context=context;
            this.list=list;

        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
            VH vh=new VH(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {
            holder.textView.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class VH extends RecyclerView.ViewHolder{
        TextView textView;
        public VH(View itemView) {
            super(itemView);

            itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                    menu.setHeaderTitle("提示");
                    menu.add(0,1,0,"傻逼");
                    menu.add(0,2,0,"呵呵");
                }
            });
            textView=itemView.findViewById(R.id.item_textview);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case 1:showToast("fuck you !");

            break;

            case 2:showToast("操你妈的");

            break;
        }
        return super.onContextItemSelected(item);

}
}
