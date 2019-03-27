package com.privatee.wjtbaseapp.Activity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;

import java.util.Timer;
import java.util.TimerTask;

import android_serialport_api.SerialUtilOld;

/**
 * 类的作用：安卓串口读卡
 * 包名 com.privatee.wjtbaseapp.Activity
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018-10-15 09:51.
 * 修改历史:
 */
public class AndroidCOMTestActivity extends BaseActivity {
    private TextView show_data;
    private SerialUtilOld serialUtilOld;
    private String path="/dev/ttyS1";
    private int baudrate=9600;
    private ReadThread readThread;
    //    private TextView button;
    private String SerialportData="";
    Timer mainTimer=new Timer();
    @Override
    public String setNowActivityName() {
        return "安卓串口读卡";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_android_com;
    }

    @Override
    public void inintView() {
        show_data=fvbi(R.id.show_data);
        ReadCard();
        sendCardData();
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {

    }
    private void ReadCard() {

//设置串口号、波特率，
        try {
            //设置串口号、波特率，
            serialUtilOld =new SerialUtilOld(path,baudrate,0);
            readThread=new ReadThread();
            readThread.start();
        } catch (NullPointerException e) {
            Toast.makeText(AndroidCOMTestActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    private class ReadThread extends Thread{
        @Override
        public void run() {
            super.run();
            while (!Thread.currentThread().isInterrupted()){
                try {

                    byte[] data= serialUtilOld.getData();

                    if(data!=null){
                        onDataReceived(data,data.length);
                       Log.i("xsy","串口有值了");
                    }

                }catch (NullPointerException e){
                    e.printStackTrace();
                    onDataReceived(null,0);
                    readThread.interrupt();
                }

                catch (Exception e) {
                    e.printStackTrace();
                    onDataReceived(null,0);
                    readThread.interrupt();
                }

            }
        }
    }

    protected void onDataReceived(final byte [] data, final int size){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StringBuilder builder = new StringBuilder();
                //这个size是实际有多少的
                for (int i = 0; i < size; i++) {
                    String string = bytesToHexString(data).substring(0, 2);
                    builder.append(string);
                }
                SerialportData=SerialportData+builder.toString()+" ";
                Log.i("xsy","SerialportData=="+SerialportData);
            }
        });
    }


    /** *//**
     * 把字节数组转换成16进制字符串
     * @param bArray
     * @return
     */
    public static  String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            Log.i("shen", "bArray[i]="+bArray[i]);
            Log.i("shen", "sTemp="+sTemp);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }


    private void sendCardData() {
        TimerTask taskk=new TimerTask() {
            @Override
            public void run() {
                if(!SerialportData.equals("")) {
                    //睡200毫秒，确保数据接收完毕
                    try {
                        Thread.sleep(60);//360
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                            show_data.setText(SerialportData);
                            }

                        });

                        Log.i("xsy","最后得到的数据为:"+SerialportData);
                        //制空
                        SerialportData="";

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        mainTimer.schedule(taskk,200,150);
    }
    @Override
    protected void onStop() {
        super.onStop();
        mainTimer.cancel();
        readThread.interrupt();
    }
}
