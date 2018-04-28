//package com.privatee.wjtbaseapp.fragment;
//
//import android.content.Context;
//import android.support.v7.widget.DefaultItemAnimator;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.OrientationHelper;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.StaggeredGridLayoutManager;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.privatee.mylibrary.Base.BaseFragment;
//import com.privatee.wjtbaseapp.R;
//
//import java.util.ArrayList;
//
//
///**
// * 类的作用：
// * Created by WJT on  2018/1/29 11:54.
// */
//
//public class RecyclerFragment extends BaseFragment{
//    RecyclerView recyclerView;
//    private ArrayList<String> list;
//    private LinearLayoutManager mLayoutManager;
//    public static TestRecyclerAdapter adapter;
//    private Button add_button;
//    private Button remove_button;
//    private int pp=0;
//    @Override
//    protected int setLayoutResouceId() {
//        return R.layout.fragment_layout_recycler;
//    }
//
//    @Override
//    public String setNowfragmentName() {
//        return "recyclerViewFragment    ";
//    }
//
//    @Override
//    protected void initView() {
//        add_button=fVB(R.id.add_button);
//        remove_button=fVB(R.id.remove_button);
//        recyclerView=fVB(R.id.recyclerView);
////        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false);
//        //设置布局管理器
////        mLayoutManager=new LinearLayoutManager(getActivity());
////        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,        StaggeredGridLayoutManager.VERTICAL));
////        recyclerView.setLayoutManager(mLayoutManager);
//        //创建适配器，并且设置
//        adapter = new TestRecyclerAdapter(getActivity(), new TestRecyclerAdapter.OnRecyclerItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                pp=position;
//                Toast.makeText(getActivity(),"第"+position+"个",Toast.LENGTH_SHORT).show();
//            }
//        }, inintData());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.addItemDecoration(new MyDividerItemDecoration(getActivity(), OrientationHelper.VERTICAL));
//        //添加默认的动画效果
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//    }
//
//    private ArrayList<String> inintData() {
//        list=new ArrayList<>();
//        list.add("第一个");
//        list.add("第er个cvsv");
//        list.add("第一个xcvzxcv");
//        list.add("第一个zxcvzxcvzxcv");
//        list.add("第一个zxcvzxcvzxcvz");
//        list.add("第一个zxc");
//        return  list;
//    }
//
//    @Override
//    protected void setListener() {
//        super.setListener();
//        add_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                adapter.addItem("加一条"+pp,pp);
//            }
//        });
//
//        remove_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
//    }
//
//    @Override
//    protected void onLazyLoad() {
//        super.onLazyLoad();
//    }
//
//    private static class TestRecyclerAdapter extends RecyclerView.Adapter {
//        /**
//         * 自定义RecyclerView 中item view点击回调方法
//         */
//        private interface OnRecyclerItemClickListener{
//            void onItemClick(View view, int position);
//        }
//
//        private Context context;
//       OnRecyclerItemClickListener onRecyclerItemClickListener;
//        private  ArrayList<String> list;
//        public TestRecyclerAdapter(Context contexts ,OnRecyclerItemClickListener onRecyclerItemClickListener,ArrayList<String> list2) {
//             context=contexts;
//           this.onRecyclerItemClickListener=onRecyclerItemClickListener;
//            list=list2;
//        }
//
//        @Override
//        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View View= LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
//            ViewHolder viewHolder=new ViewHolder(View);
//            View.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(onRecyclerItemClickListener!=null){
//                        onRecyclerItemClickListener.onItemClick(view, (int)view.getTag());
//                    }
//                }
//            });
//            return viewHolder;
//        }
//
//        @Override
//        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//            TextView te=holder.itemView.findViewById(R.id.item_textview);
//            te.setText(list.get(position));
//            holder.itemView.setTag(position);
//        }
//
//        @Override
//        public int getItemCount() {
//            return list.size();
//        }
//
//        /**
//         * 增加数据
//         * @param Date
//         * @param postion
//         */
//        public void addItem(String Date, int postion){
//            list.add(postion,Date);
//            notifyItemInserted(postion);
//        }
//        /**
//         * 删除数据
//         */
//
//        public void deleteItem(int  postion){
//            list.remove(postion);
//            notifyItemRemoved(postion);
//
//        }
//
//    }
//    static class ViewHolder extends RecyclerView.ViewHolder{
//        public TextView tee;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            tee=itemView.findViewById(R.id.item_textview);
//        }
//    }
//
//
//}
