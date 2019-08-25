package com.privatee.wjtbaseapp.obsever_design;

/**
 * 定义抽象被观察者
 */
public interface Observable  {

    void add(Obsever obsever);//添加观察者
    void remove(Obsever obsever);//移除观察者
    void notify(String string);//通知观察者
}
