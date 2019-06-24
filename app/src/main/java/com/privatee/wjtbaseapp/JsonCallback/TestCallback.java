package com.privatee.wjtbaseapp.JsonCallback;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;

/**
 * 类的作用：
 * Created by WJT on  2018/5/3 09:24.
 */
public class TestCallback<T> extends AbsCallback<T> {


    private Type type;
    private Class<T> clazz;

    public TestCallback() {
    }

    public TestCallback(Type type) {
        this.type = type;
    }

    public TestCallback(Class<T> clazz) {
        this.clazz = clazz;
    }


    @Override
    public void onSuccess(Response<T> response) {

    }

    @Override
    public T convertResponse(okhttp3.Response response) throws Throwable {


        if (type == null) {
            if (clazz == null) {
                Type genType = getClass().getGenericSuperclass();
                type = ((ParameterizedType) genType).getActualTypeArguments()[0];
            }
        }
        ResponseBody body = response.body();
        if (body == null) return null;
        T data = null;
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(body.charStream());
        if (type != null) data = gson.fromJson(jsonReader, type);
        if (clazz != null) data = gson.fromJson(jsonReader, clazz);
        return data;
    }
}
