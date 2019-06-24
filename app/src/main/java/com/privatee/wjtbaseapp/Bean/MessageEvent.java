package com.privatee.wjtbaseapp.Bean;

/**
 * 类的作用：EvenBus事件类
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/26 09:46.
 */
public class MessageEvent {
    public  String Message;

    public MessageEvent(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
