package com.privatee.wjtbaseapp.Activity;

import android.util.Log;
import android.view.View;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.R;
import com.privatee.wjtbaseapp.RetrofitAll.GetRequest_Interface;
import com.privatee.wjtbaseapp.RetrofitAll.GetRequest_Rxjava_Interface;
import com.privatee.wjtbaseapp.RetrofitAll.GetYouDaoRequest_Interface;
import com.privatee.wjtbaseapp.RetrofitAll.Translation;
import com.privatee.wjtbaseapp.RetrofitAll.Translation1;
import com.privatee.wjtbaseapp.RetrofitAll.Translation2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类的作用：
 * Created by WJT on  2018/3/5 15:00.
 */

public class Retrofit_RxJavaActivity extends BaseActivity{
    @Override
    public String setNowActivityName() {
        return "retrofitRxjava类  ";
    }

    @Override
    public int setLayout() {
        return R.layout.retrofit_rx_layout;
    }

    @Override
    public void inintView() {
//        request();
//        request2();-
        request4();
    }



    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View view) {

    }

    //具体的操作类
    private void request() {
        //4部操作
        //创建Retrofit对象
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")//设置网络请求url
                .addConverterFactory(GsonConverterFactory.create())//设置转换器
                .build();


        // 创建 网络请求接口 的实例
        GetRequest_Interface getRequest=retrofit.create(GetRequest_Interface.class);
        Call<Translation> call=getRequest.getCall();
        //发送网络请求(异步)
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                //处理返回的数据结果
                response.body().show();
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                System.out.println("连接失败");
            }
        });


    }

    //post Retrofit请求数据
    private void request2() {
        //首先创建 Retrofit对象，需要把baseUrl和转换器传进去
    Retrofit retrofit2=new Retrofit.Builder()
            .baseUrl("http://fanyi.youdao.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        //然后创建接口对象
        GetYouDaoRequest_Interface getyoudao=retrofit2.create(GetYouDaoRequest_Interface.class);
        //对发送的 需要翻译的字符串进行封装

        //创建Call对象
        Call<Translation1> call= getyoudao.getCall("come on");

        //发送网络请求
        call.enqueue(new Callback<Translation1>() {
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                System.out.println(response.body().getTranslateResult().get(0).get(0).getTgt());
            }

            @Override
            public void onFailure(Call<Translation1> call, Throwable t) {
                System.out.println("请求失败");
                System.out.println(t.getMessage());
            }
        });

    }
    private void request3() {
        //首先创建Retrofit对象
        Retrofit reteofit=new Retrofit.Builder().baseUrl("http://fanyi.youdao.com/").addConverterFactory(GsonConverterFactory.create())
                .build();
        //创建servive对象
        GetYouDaoRequest_Interface getRequest=reteofit.create(GetYouDaoRequest_Interface.class);
        //创建Call
        Call<Translation1>call=getRequest.getCall("I love you");

        //使用call开始请求
        call.enqueue(new Callback<Translation1>() {
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {

            }

            @Override
            public void onFailure(Call<Translation1> call, Throwable t) {

            }
        });


    }

    public void request4(){
        Retrofit retrofit3=new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")//放入基础地址
                .addConverterFactory(GsonConverterFactory.create())//放入Gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//对Rxjava的支持
                .build();
        GetRequest_Rxjava_Interface getRequest_rxjava_interface=retrofit3.create(GetRequest_Rxjava_Interface.class);
        Observable<Translation2> observable=getRequest_rxjava_interface.getCall();
        observable.subscribeOn(Schedulers.io())//上游请求放在io线程
                .observeOn(AndroidSchedulers.mainThread())//处理结果放在主线程
                .subscribe(new Observer<Translation2>() {
                    @Override
                    public void onSubscribe(Disposable d) {//disposable是流开关
                        Log.d("XSY", "开始采用subscribe连接");

                    }

                    @Override
                    public void onNext(Translation2 value) {
                        //对数据进行处理
                        value.show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        //异常了
                    }

                    @Override
                    public void onComplete() {

                        //处理接受完成
                    }
                });
    }

}
