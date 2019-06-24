package com.privatee.wjtbaseapp.A_M.A_impl;

import com.privatee.wjtbaseapp.A_M.A_bean.Student;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * <p>文件描述：<p>
 * <p>作者：wjt<p>
 * <p>创建时间：2018/12/14<p>
 * <p>更改时间：2018/12/14<p>
 * <p>版本号：1<p>
 */

public interface Retrofit2Service {
    @GET("my")
    Observable<Student> getStudent();
}
