package com.privatee.wjtbaseapp.RetrofitAll;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 类的作用：
 * Created by WJT on  2018/3/7 10:53.
 */

public interface GetRequest_Rxjava_Interface {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20world")
    Observable<Translation2> getCall();
    // 采用Observable<...>接口
    // getCall()是接受网络请求数据的方法
}
