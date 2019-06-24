package com.privatee.wjtbaseapp.A_V.activity;

import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.wjtbaseapp.A_M.A_bean.Student;
import com.privatee.wjtbaseapp.A_M.A_impl.Retrofit2Service;
import com.privatee.wjtbaseapp.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request.Builder;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import  com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

/**
 * 类的作用：Rxjava2测试Activity
 * 包名 com.privatee.wjtbaseapp.A_V.activity
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018-11-20 10:30.
 * 修改历史:
 */
public class    RxjavaActivity extends BaseActivity{
    @Override
    public String setNowActivityName() {
        return "RxJAVA2";
    }

    @Override
    public int setLayout() {
        return R.layout.rxtest;
    }

    @Override
    public void inintView() {


        /**
         * 测试RxJAVA 和Retrofitxxxx
         */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.20.83:8080/SelecvtTestDemo/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))//添加JSON转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加Call转Rxjava转换器
                .build();


        Retrofit2Service service=retrofit.create(Retrofit2Service.class);
        Observable<Student> observable=service.getStudent();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Student>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Student student) {
                        TaoTools.i("得到student信息="+student.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        TaoTools.i("请求报错！！！！！！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
//        //创建被观察者
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//             e.onNext("1");
//             e.onNext("2");
//             e.onNext("3");
//             e.onNext("4");
//             e.onNext("5");
//             e.onNext("6");
//            }
//        }).subscribe(new Observer<String>() {//订阅
//            //初始化观察者
//            private String i;
//            private Disposable mDisposable;
//
//            @Override
//            public void onSubscribe(Disposable d) {
//                mDisposable=d;
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.i("Test",s);
//                if(s.equals("3")){
//                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
//                    mDisposable.dispose();
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i("Test","跑到报错信息里面了onError");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i("Test","结束了，跑到onComplete里面了");
//            }
//        });
    }

    @Override
    public void inintData() {
//            Observable.create(new ObservableOnSubscribe<String>() {
//                @Override
//                public void subscribe(ObservableEmitter<String> e) throws Exception {
//                    TaoTools.e("未定阅之前，未修改线程，Current thread is " + Thread.currentThread().getName());
//                     e.onNext("1");
//                    TaoTools.d("发射1");
//                     e.onNext("2");
//                    TaoTools.d("发射2");
//                     e.onNext("3");
//                    TaoTools.d("发射3");
//                     e.onNext("4");
//                    TaoTools.d("发射4");
//                     e.onNext("5");
//                    TaoTools.d("发射5");
//                     e.onNext("6");
//                    TaoTools.d("发射6");
//                }
//            }).subscribeOn(Schedulers.newThread())
//                    .subscribeOn(Schedulers.io()).//上游线程
//                    observeOn(AndroidSchedulers.mainThread())//下游线程
//                    .doOnNext(new Consumer<String>() {
//                        @Override
//                        public void accept(String s) throws Exception {
//                        TaoTools.d("在订阅之前，修改数据二次发射"+s);
//                            TaoTools.e("未定阅之前，修改了二次线程，Current thread is " + Thread.currentThread().getName());
//                        }
//                    }).observeOn(Schedulers.io())
//                    .subscribe(new Observer<String>() {
//                @Override
//                public void onSubscribe(Disposable d) {
//
//                }
//
//                @Override
//                public void onNext(String s) {
//                    TaoTools.e("定阅之后，最后的线程，Current thread is " + Thread.currentThread().getName());
//                }
//
//                @Override
//                public void onError(Throwable e) {
//
//                }
//
//                @Override
//                public void onComplete() {
//
//                }
//            });

        /**
         * 这是测试RxJava+oKhttp
         */

//        Observable.create(new ObservableOnSubscribe() {
//            @Override
//            public void subscribe(ObservableEmitter e) throws Exception {
//                TaoTools.d("请求之前在哪个线程 Current thread is"+Thread.currentThread().getName());
//                //使用Okhttp进行测试
//                Builder builder=new Builder()
//                        .url("http://192.168.20.83:8080/SelecvtTestDemo/my")
//                        .get();
//               Request request=builder.build();
//                Call call= new OkHttpClient().newCall(request);
//                Response response =call.execute();
//                e.onNext(response);
//
//            }
//        }).map(new Function<Response,Student>() {
//            @Override
//            public Student apply(Response response) throws Exception {
//                //如果代码在[200..300]中，则返回true，这意味着请求是成功接收，理解和接受0。
//                if(response.isSuccessful()){//这是什么啊判断什么的？？知道了的话一定要记住，，
//                    ResponseBody responseBody=response.body();
//                    if (responseBody != null) {
//                        TaoTools.d("map:转换前:" + response.body());
//                        TaoTools.d("另外显示显示map在哪个线程 Current thread is"+Thread.currentThread().getName());
//                        return new Gson().fromJson(responseBody.string(),Student.class);
//                    }
//                }
//                return null;
//            }
//        }).subscribeOn(Schedulers.io())//上游放在io线程里面
//        .observeOn(AndroidSchedulers.mainThread())//下游放在主线程
//        .doOnNext(new Consumer<Student>() {
//            @Override
//            public void accept(Student student) throws Exception {
//                TaoTools.d("转化成功成功"+student.toString());
//                TaoTools.d("Onnext在哪个线程 Current thread is"+Thread.currentThread().getName());
//            }
//        }).subscribe(new Observer<Student>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Student student) {
//            TaoTools.d("请求成功成功"+student.toString());
//                TaoTools.d("请求之后在哪个线程 Current thread is"+Thread.currentThread().getName());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });



    }

    @Override
    public void onClick(View v) {

    }
}
