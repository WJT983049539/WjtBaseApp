package com.privatee.wjtbaseapp.obsever_design;

/**
 * 定义抽象观察者
 */
public interface Obsever {
    void uptade(String message);//定义一个观察者收到通知后的反应
}
