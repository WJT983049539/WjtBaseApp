package com.privatee.wjtbaseapp.Activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.wjtbaseapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 类的作用：
 * Created by WJT on  2018/4/19 15:11.
 */

public class TCPTestActivity extends BaseActivity{
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.what==1){
                baginTcp();
            }

        }
    };

    OutputStream out;
    DataOutputStream outs;
    InputStream input;
    DataInputStream inputs;
    private ListView tcp_listview;
    // 定义Socket类的对象
    Socket client = null;
    @Override
    public String setNowActivityName() {
        return "tcp测试";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_tcp;
    }

    @Override
    public void inintView() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        tcp_listview=fvbi(R.id.tcp_listview);
    }

    @Override
    public void inintData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                baginTcp();
            }
        }).start();

    }

    public void baginTcp() {
        try {
            client = new Socket("192.168.1.118", 9091);
            client.setSoTimeout(10000);
            // 定义发送数据的输出流
             out = client.getOutputStream();
             outs = new DataOutputStream(out);
             input=client.getInputStream();
             inputs=new DataInputStream(input);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        genProtocol(outs,inputs,"1");
                    } catch (Exception e) {
                        e.printStackTrace();
                        TaoTools.i("跑到异常里面，开始关流和重新连接！");

                        try {
                            inputs.close();
                            input.close();
                            outs.close();
                            out.close();
                            client.close();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }


                        Message msg=new Message();
                        msg.what=1;
                        handler.sendMessage(msg);
                    }
                }
            },100,5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {

    }
    /**
     * 构造协议
     *
     * @param out
     * @param inputs
     *@param msg  @throws IOException
     */
    private void genProtocol(DataOutputStream out, DataInputStream inputs, String msg) throws IOException, JSONException {

        if(!client.isClosed()){
        out.writeUTF(msg);//发送心跳包

        String msssg=inputs.readUTF();
        JSONObject onject=new JSONObject(msssg);
        String satte=onject.getString("state");
        if(satte.equals("99")){
            TaoTools.i("心跳包收到服务器的反馈99 成功");
        }
    }else{
            //重新连接
            baginTcp();
            TaoTools.i("判断没有网，重新连接");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            inputs.close();
            input.close();
            outs.close();
            out.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
