//package com.privatee.wjtbaseapp.A_V.activity;
//
//import android.app.AlertDialog;
//import android.app.AlertDialog.Builder;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.os.Build;
//import android.support.annotation.RequiresApi;
//import android.view.View;
//import android.widget.DatePicker;
//import android.widget.TextView;
//import android.widget.TimePicker;
//
//import com.privatee.mylibrary.Base.BaseActivity;
//import com.privatee.wjtbaseapp.R;
//
//import java.util.Calendar;
//
///**
// * 日历测试
// * @author wjt
// * @date 2019/8/13 8:41
// * @contact 983049539@qq.com
// */
//public class RiliActivity extends BaseActivity implements View.OnClickListener,DatePicker.OnDateChangedListener {
//    private StringBuffer date, time;
//     TextView time_picker;
//    @Override
//    public String setNowActivityName() {
//        return null;
//    }
//
//    @Override
//    public int setLayout() {
//        return R.layout.layout_rili;
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    @Override
//    public void inintView() {
//        date=new StringBuffer();
//        time=new StringBuffer();
//        time_picker=fvbi(R.id.dade_timepicker);
//        time_picker.setOnClickListener(this);
//        initDateTime();
//        Context context;
//
//
//    }
//    private int year, month, day, hour, minute;
//    private void initDateTime() {
//        Calendar calendar = Calendar.getInstance();
//        year = calendar.get(Calendar.YEAR);
//        month = calendar.get(Calendar.MONTH) + 1;
//        day = calendar.get(Calendar.DAY_OF_MONTH);
//        hour = calendar.get(Calendar.HOUR);
//        minute = calendar.get(Calendar.MINUTE);
//        time_picker.setText(date.append(String.valueOf(year)).append("年").append(String.valueOf(month)).append("月").append(day).append("日"));
//    }
//    @Override
//    public void inintData() {
//
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.dade_timepicker:
//                AlertDialog.Builder builder=new AlertDialog.Builder(this);
//                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//
//                builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        if (date.length() > 0) { //清除上次记录的日期
//                            date.delete(0, date.length());
//                        }
//                        time_picker.setText(date.append(String.valueOf(year)).append("年").append(String.valueOf(month)).append("月").append(day).append("日"));
//                        dialog.dismiss();
//                    }
//                });
//                AlertDialog dialog=builder.create();
//                View dialogView = View.inflate(this, R.layout.dialog_date, null);
//                DatePicker timePicker=dialogView.findViewById(R.id.timePicker);
//                timePicker.init(year, month - 1, day, this);
//                dialog.setTitle("设置时间");
//                dialog.setView(dialogView);
//                dialog.show();
//
//                break;
//        }
//
//    }
//
//
//    @Override
//    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//        this.year = year;
//        this.month = monthOfYear;
//        this.day = dayOfMonth;
//    }
//}
