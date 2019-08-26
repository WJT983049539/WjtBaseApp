package com.privatee.wjtbaseapp.call;

import android.widget.Toast;

import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.exception.HttpException;
import com.lzy.okgo.exception.StorageException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import okhttp3.Response;

/**
 * @auther wjt
 * @date 2019/5/16
 */
public abstract class CustomStringCallback extends AbsCallback<String> {

    private StringConvert convert;

    public CustomStringCallback() {
        convert = new StringConvert();
    }

    @Override
    public String convertResponse(Response response) throws Throwable {
        String s = convert.convertResponse(response);
        response.close();
        return s;
    }

    @Override
    public void onError(com.lzy.okgo.model.Response<String> response) {
        super.onError(response);
        Throwable exception = response.getException();
        if(exception!=null){
            exception.printStackTrace();
        }
//        if(exception instanceof UnknownHostException ||exception instanceof ConnectException){
//            GlobalToast.show("网络连接失败，请连接网络！", Toast.LENGTH_SHORT);
//            if(AppManager.getAppManager().currentActivity()instanceof DisconnectActivity){
//            }else {
//                //打开断网页面
////                OpenHelper.openDisconnectActivity(HwApp.getApp().getCurActivity());
//            }
//        }else if(exception instanceof SocketTimeoutException){
//            GlobalToast.show("网络请求超时", Toast.LENGTH_SHORT);
//            if(AppManager.getAppManager().currentActivity()instanceof DisconnectActivity){
//            }else {
////                OpenHelper.openDisconnectActivity(HwApp.getApp().getCurActivity());
//            }
//        }else if(exception instanceof HttpException){
//            GlobalToast.show("服务端异常了", Toast.LENGTH_SHORT);
//            if(AppManager.getAppManager().currentActivity()instanceof DisconnectActivity){
//            }else {
////                OpenHelper.openDisconnectActivity(HwApp.getApp().getCurActivity());
//            }
//        }else if(exception instanceof StorageException){
//            GlobalToast.show("服务端异常了", Toast.LENGTH_SHORT);
//        }else if(exception instanceof IllegalStateException){
//            GlobalToast.show(exception.getMessage(), Toast.LENGTH_SHORT);
//        }
    }
}