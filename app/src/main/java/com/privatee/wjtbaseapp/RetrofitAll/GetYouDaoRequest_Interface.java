package com.privatee.wjtbaseapp.RetrofitAll;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 类的作用：有道词典翻译
 * Created by WJT on  2018/3/5 16:14.
 */

public interface GetYouDaoRequest_Interface {
    @POST("translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=")
    @FormUrlEncoded
    Call<Translation1> getCall(@Field("i") String  targetSentence);
}
