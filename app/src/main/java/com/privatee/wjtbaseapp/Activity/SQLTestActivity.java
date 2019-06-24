package com.privatee.wjtbaseapp.Activity;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.sql.BianQian;
import com.privatee.wjtbaseapp.sql.BianQianService;
import com.privatee.wjtbaseapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类的作用：SQL数据库
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/29 10:06.
 */
public class SQLTestActivity extends BaseActivity{
    private Button id_delete;
    private Button id_insert;
    private Button id_update;
    private Button id_query;
    private TextView tiele_text;
    private BianQianService service;
    private ListView sqllist;
    private Myadapter nnadapter;
     List<BianQian>bianQians=null;

    @Override
    public String setNowActivityName() {
        return "数据库";
    }

    @Override
    public int setLayout() {
        return R.layout.activity_sql;
    }

    @Override
    public void inintView() {
        bianQians=new ArrayList<BianQian>();
        service=new BianQianService(this);
        bianQians.clear();

        bianQians=service.queryAllDate();
        sqllist=fvbi(R.id.sqllist);
        if(bianQians.size()==0){
            //为空
            service=new BianQianService(this);
            BianQian bb=new BianQian();
            bb.setBianqianTile("我靠没值啊");
            SimpleDateFormat sm=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            String nowtime=sm.format(new Date());
            bb.setBianqianTime(nowtime);
            bb.setBianqianContent("卧槽哦没值");
            bianQians.add(bb);
        }

        nnadapter=new Myadapter(this,bianQians);
//        adapter= new ArrayAdapter<BianQian>(this,android.R.layout.simple_list_item_1,);
        sqllist.setAdapter(nnadapter);
        sqllist.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("选择");
                menu.add(0,1,0,"修改");
                menu.add(0,2,0,"删除");
            }
        });

        id_insert=fvbi(R.id.id_insert);
        id_insert.setOnClickListener(this);
        id_query=fvbi(R.id.id_query);
        id_query.setOnClickListener(this);
        tiele_text=fvbi(R.id.tiele_text);
    }

    @Override
    public void inintData() {



    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.id_insert:
             service=new BianQianService(this);
             //增加
             BianQian bianQian=new BianQian();
             bianQian.setBianqianTile("3536");
             Date date=new Date();
             SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String time=simpleDateFormat.format(date);
             bianQian.setBianqianTime(time);
             bianQian.setBianqianContent("开车了");
             service=new BianQianService(this);
             if( service.insertBianQian(bianQian)){
                 bianQians.clear();
                 service=new BianQianService(this);
                 bianQians=service.queryAllDate();
                 nnadapter=new Myadapter(this,bianQians);
                 sqllist.setAdapter(nnadapter);
             }


             break;
         case R.id.id_query:
             service=new BianQianService(this);
//             bianQians.clear();
             bianQians=service.queryAllDate();
             nnadapter=new Myadapter(this,bianQians);
             sqllist.setAdapter(nnadapter);
             break;
     }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("操作");
        menu.setHeaderIcon(R.drawable.ic_launcher);
        menu.add(1,1,1,"修改");
        menu.add(1,2,1,"删除");


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //得到选择的listView选择的那个
        AdapterView.AdapterContextMenuInfo adapter= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position=adapter.position;
        switch (item.getItemId()){
            case 1://修改
                service=new BianQianService(this);
                BianQian bb=new BianQian();
                bb.setBianqianId(bianQians.get(position).getBianqianId());
                bb.setBianqianContent("我日");
                bb.setBianqianTile("靠 啊");
                bb.setBianqianTime("asdasdasdas");
                service.updateBianqian(bb);
                bianQians.clear();
                service=new BianQianService(this);
                bianQians=service.queryAllDate();
                nnadapter=new Myadapter(this,bianQians);
                sqllist.setAdapter(nnadapter);
                break;
            case 2://删除
                service=new BianQianService(this);
                Boolean flag=service.deleteBianQian(bianQians.get(position).getBianqianId());
                if(flag){
                    showToast("删除成功");
                }
                bianQians.clear();
                service=new BianQianService(this);
                bianQians=service.queryAllDate();
                nnadapter=new Myadapter(this,bianQians);
                sqllist.setAdapter(nnadapter);
                break;
        }
        return super.onContextItemSelected(item);
    }


    private class Myadapter extends BaseAdapter {
        SQLTestActivity sqlTestActivity;
        List<BianQian> bianQians;
        public Myadapter(SQLTestActivity sqlTestActivity, List<BianQian> bianQians) {
            this.sqlTestActivity=sqlTestActivity;
            this.bianQians=bianQians;
        }

        @Override
        public int getCount() {
            return bianQians.size();
        }

        @Override
        public Object getItem(int position) {
            return bianQians.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView te;
            LayoutInflater inflater=LayoutInflater.from(sqlTestActivity);
            View view= inflater.inflate(R.layout.item_adapter, parent,false);
            te=view.findViewById(R.id.item_text);
            te.setText(bianQians.get(position).getBianqianContent());
            return view;
        }
    }
}
