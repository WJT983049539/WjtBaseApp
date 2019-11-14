//package com.privatee.wjtbaseapp.A_V.activity;
//
//import android.content.ContentResolver;
//import android.database.Cursor;
//import android.net.Uri;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.privatee.mylibrary.Base.BaseActivity;
//import com.privatee.wjtbaseapp.Activity.RecycleListTestActivity;
//import com.privatee.wjtbaseapp.Bean.RecyclerViewPartUpdateBean;
//import com.privatee.wjtbaseapp.R;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
///**
// * 获取联系人和短信信息
// */
//public class GetContactAndSMSInfoActivity extends BaseActivity {
//    private Button getcontacts;
//    private Button getsms;
//    private ContentResolver contentResolver;//内容访问者
//    private RecyclerView re_getinfo;
//
//    @Override
//    public String setNowActivityName() {
//        return "获取联系人和短信信息";
//    }
//
//    @Override
//    public int setLayout() {
//        return R.layout.activity_getsmsandcontactinfo;
//    }
//
//    @Override
//    public void inintView() {
//        getcontacts=fvbi(R.id.getcontacts);
//        getsms=fvbi(R.id.getsms);
//        re_getinfo=fvbi(R.id.re_getinfo);
//        getcontacts.setOnClickListener(this);
//        getsms.setOnClickListener(this);
//    }
//
//    @Override
//    public void inintData() {
//
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//
//            //获取联系人列表
//            case R.id.getcontacts:
//                RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
//                re_getinfo.setLayoutManager(layoutManager);
//                List<Map<String,Object>> list= getcontactsInfo();
//                MyRecyclerAdapter2 myRecyclerAdapter=new MyRecyclerAdapter2(list);
//                re_getinfo.setAdapter(myRecyclerAdapter);
//
//                break;
//                //获取信息列表
//            case R.id.getsms:
////                RecyclerView.LayoutManager layoutManager2=new LinearLayoutManager(this);
////                getSMSInfo();
////                re_getinfo.setLayoutManager(layoutManager2);
////
////                MyRecyclerAdapter2 myRecyclerAdapter2=new MyRecyclerAdapter2();
////                re_getinfo.setAdapter(myRecyclerAdapter2);
//                break;
//
//        }
//    }
//    //获取信息列表
//    private List<String > getSMSInfo() {
//    List<String>list=new ArrayList<String>();
//        Cursor cursor = contentResolver.query(Uri.parse("content://sms/"), new String[]{"_id", "address", "body", "date", "type"}, null, null, null);
//        if (cursor != null && cursor.getCount() > 0) {
//            int _id;
//            String address;
//            String body;
//            String date;
//            int type;
//            while (cursor.moveToNext()) {
//                //实例化一个messagemap集合放电话号码跟短信内容的值
//             Map<String,Object> messagemap = new HashMap<String, Object>();
//                _id = cursor.getInt(0);
//                address = cursor.getString(1);
//                body = cursor.getString(2);
//                date = cursor.getString(3);
//                type = cursor.getInt(4);
//                //给messagemap集合里设值
//                messagemap.put("myphones",address);
//                messagemap.put("content",body);
//
//
//            }
//
//
//        }
//    }
//
//    //获取电话本信息
//    private List<Map<String,Object>> getcontactsInfo() {
//        //获取内容访问者
//        contentResolver = getContentResolver();
//        //实例化一个集合用来保存联系人的信息
//        List<Map<String,Object>> persondata = new ArrayList<Map<String, Object>>();
//        //协议：content://com.android.contacts/raw_contacts（获得联系人的id，姓名）
//        Cursor cursor = contentResolver.query(Uri.parse("content://com.android.contacts/raw_contacts"), null, null, null, null);
//        while(cursor.moveToNext()){
//           Map<String,Object> personmap = new HashMap<String, Object>();
//            //得到联系人id
//            int id=cursor.getInt(cursor.getColumnIndex("_id"));
//            String displayname=cursor.getString(cursor.getColumnIndex("display_name"));
//            //把名字添加到集合中
//            personmap.put("name",displayname);
//
//            Cursor cursordate = contentResolver.query(Uri.parse("content://com.android.contacts/raw_contacts/" + id + "/data"), null, null, null, null);
//
//            //得到联系人类型
//            //得到联系人的类型
//            String type = cursordate.getString(cursordate.getColumnIndex("mimetype"));
//            //得到联系人电话号码
//            String PhoneCode=cursordate.getString(cursordate.getColumnIndex("dada1"));
//            personmap.put("phones",PhoneCode);
//            persondata.add(personmap);
//        }
//        return persondata;
//    }
//
//    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyHolder> {
//        private RecycleListTestActivity recycleListTestActivity;
//        private List<Map<String,Object>> mDatass;
//        public  MyRecyclerAdapter(RecycleListTestActivity recycleListTestActivity, List<Map<String,Object>> list) {
//            mDatass=list;
//            this.recycleListTestActivity=recycleListTestActivity;
//
//        }
//        // 重写onCreateViewHolder方法，返回一个自定义的ViewHolder
//        @Override
//        public MyRecyclerAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            LayoutInflater layoutInflater=LayoutInflater.from(recycleListTestActivity);
//            View view=layoutInflater.inflate(R.layout.item_recyclerview2,null);
//           MyRecyclerAdapter.MyHolder holder = new MyRecyclerAdapter.MyHolder(view);
//            return holder;
//        }
//
//        // 填充onCreateViewHolder方法返回的holder中的控件
//        @Override
//        public void onBindViewHolder(MyRecyclerAdapter.MyHolder holder, int position) {
////            holder.textViewa.setText(mDatass.get(position));
//        }
//
////        /**
////         * 局部更新的方法
////         * @param holder
////         * @param position
////         * @param payloads
////         */
////        @Override
////        public void onBindViewHolder(MyHolder holder, int position, List<Object> payloads) {
////            //如果是空的话更新整个界面
////            if(payloads.isEmpty()){
////                onBindViewHolder(holder,position);//绑定数据
////
////            }else{//刷新局部改变的
////
////                for(int i=0;i<payloads.size();i++){
////                    String strig= (String) payloads.get(i);
////                }
////            }
////            super.onBindViewHolder(holder, position, payloads);
////        }
//
//        @Override
//        public int getItemCount() {
//            return mDatass.size();
//        }
//
//        class MyHolder extends RecyclerView.ViewHolder{
//            private TextView textViewa;
//            public MyHolder(View itemView) {
//                super(itemView);
//                textViewa=itemView.findViewById(R.id.ry_item2);
//            }
//        }
//    }
//
//    private  class MyRecyclerAdapter2 extends RecyclerView.Adapter<MyRecyclerAdapter2.MyHolder2> {
//        private RecycleListTestActivity recycleListTestActivity;
//        private List<Map<String,Object>> mDatass;
//        public  MyRecyclerAdapter2( List<Map<String,Object>>mDatas) {
//            mDatass=mDatas;
//            this.recycleListTestActivity=recycleListTestActivity;
//
//        }
//
//
//
//        // 重写onCreateViewHolder方法，返回一个自定义的ViewHolder
//        @Override
//        public MyRecyclerAdapter2.MyHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
//            LayoutInflater layoutInflater=LayoutInflater.from(recycleListTestActivity);
//            View view=layoutInflater.inflate(R.layout.item_recyclerview3,null);
//            MyRecyclerAdapter2.MyHolder2 holder2 = new MyRecyclerAdapter2.MyHolder2(view);
//            return holder2;
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull MyHolder2 holder, int position) {
//            holder.telephonecode.setText(mDatass.get(position).get("phones").toString());
//            holder.item_name.setText(mDatass.get(position).get("name").toString());
//        }
//
//        // 填充onCreateViewHolder方法返回的holder中的控件
//
//
//        @Override
//        public int getItemCount() {
//            return mDatass.size();
//        }
//
//        class MyHolder2 extends RecyclerView.ViewHolder{
//            private TextView item_name;
//            private TextView telephonecode;
//
//            public MyHolder2(View itemView) {
//                super(itemView);
//                item_name=itemView.findViewById(R.id.item_name);
//                telephonecode=itemView.findViewById(R.id.telephone_code);
//            }
//        }
//    }
//}
