package com.privatee.wjtbaseapp.JsonCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类的作用：
 * Created by WJT on  2018/5/3 09:46.
 */
public class Test2CallBack<T> implements Callback{
    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {

    }
}
