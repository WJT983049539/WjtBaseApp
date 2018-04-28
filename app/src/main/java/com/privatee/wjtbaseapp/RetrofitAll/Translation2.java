package com.privatee.wjtbaseapp.RetrofitAll;

/**
 * 类的作用：
 * Created by WJT on  2018/3/7 10:50.
 */

public class Translation2 {
    private int status;

    private content content;
    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show() {
        System.out.println( "Rxjava翻译结果：" + status);
        System.out.println("Rxjava翻译结果：" + content.from);
        System.out.println("Rxjava翻译结果：" + content.to);
        System.out.println("Rxjava翻译结果：" + content.vendor);
        System.out.println("Rxjava翻译结果：" + content.out);
        System.out.println("Rxjava翻译结果：" + content.errNo);
    }

}
