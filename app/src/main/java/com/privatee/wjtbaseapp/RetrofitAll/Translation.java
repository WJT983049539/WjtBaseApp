package com.privatee.wjtbaseapp.RetrofitAll;

/**
 * 类的作用：金山词霸接受json的类
 * Created by WJT on  2018/3/5 15:15.
 */

public class Translation {

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
        System.out.println(status);
        System.out.println(content.from);
        System.out.println(content.to);
        System.out.println(content.vendor);
        System.out.println(content.out);
        System.out.println(content.errNo);
    }
}
