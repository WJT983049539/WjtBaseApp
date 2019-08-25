package com.privatee.wjtbaseapp.obsever_design;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * 具体被观察者
 */
public class Postman implements Observable {
    private List<Obsever> personList = new ArrayList<Obsever>();//保存收件人（观察者）的信息
    @Override
    public void add(Obsever obsever) {
        personList.add(obsever);
    }

    @Override
    public void remove(Obsever obsever) {
        personList.remove(obsever);
    }

    @Override
    public void notify(String string) {
        for (Obsever observer:personList){
            observer.uptade(string);
        }
    }


}
