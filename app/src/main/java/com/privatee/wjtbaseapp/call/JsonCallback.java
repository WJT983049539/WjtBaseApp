package com.privatee.wjtbaseapp.call;

import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.exception.HttpException;
import com.lzy.okgo.exception.StorageException;
import com.lzy.okgo.model.Response;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import okhttp3.ResponseBody;

public abstract class JsonCallback<T> extends AbsCallback<T> {
    @Override
    public T convertResponse(okhttp3.Response response) throws Throwable {
        ResponseBody body= (ResponseBody) response.body();
        if(body==null) {
            return null;
        }
        T data=null;
        Gson gson=new GsonBuilder().registerTypeAdapterFactory(new NullStringEmptyTypeAdapterFactory()).create();
//        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonReader jsonReader=new JsonReader(body.charStream());
        Type genType=getClass().getGenericSuperclass();
        Type type=((ParameterizedType)genType).getActualTypeArguments()[0];
        data =gson.fromJson(jsonReader,type);
        return data;
    }

    @Override
    public void onError(Response<T> response) {
        super.onError(response);
        Throwable exception = response.getException();
        if(exception!=null){
            exception.printStackTrace();
        }
//        if(exception instanceof UnknownHostException ||exception instanceof ConnectException){
//            GlobalToast.show("网络连接失败，请连接网络！", Toast.LENGTH_LONG);
//            if(AppManager.getAppManager().currentActivity() instanceof DisconnectActivity){
//            }else {
//                OpenHelper.openDisconnectActivity(AppManager.getAppManager().currentActivity());
//            }
//        }else if(exception instanceof SocketTimeoutException){
//            GlobalToast.show("网络请求超时", Toast.LENGTH_LONG);
//            if(AppManager.getAppManager().currentActivity()instanceof DisconnectActivity){
//            }else {
//                OpenHelper.openDisconnectActivity(AppManager.getAppManager().currentActivity());
//            }
//        }else if(exception instanceof HttpException){
//            GlobalToast.show("服务端异常了", Toast.LENGTH_LONG);
//            if(AppManager.getAppManager().currentActivity()instanceof DisconnectActivity){
//            }else {
//                OpenHelper.openDisconnectActivity(AppManager.getAppManager().currentActivity());
//            }
//        }else if(exception instanceof StorageException){
//            GlobalToast.show("服务端异常了", Toast.LENGTH_LONG);
//        }else if(exception instanceof IllegalStateException){
//            GlobalToast.show(exception.getMessage(), Toast.LENGTH_LONG);
//        }
    }

}
