package com.privatee.wjtbaseapp.A_M.A_impl;

import com.privatee.wjtbaseapp.A_M.A_bean.Book;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * <p>文件描述：<p>
 * <p>作者：wjt<p>
 * <p>创建时间：2018/12/12<p>
 * <p>更改时间：2018/12/12<p>
 * <p>版本号：1<p>
 */

public interface RetrofitService {
    @GET("book/search")
    Call<Book> getSeacherBook(@Query("q")String name,
                              @Query("tag")String tag,
                              @Query("start")int start,
                              @Query("count")int count

    );

}
