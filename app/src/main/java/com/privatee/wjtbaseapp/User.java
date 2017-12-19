package com.privatee.wjtbaseapp;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类的作用：
 * Created by WJT on  2017/12/18 17:58.
 */
 @Entity
public class User {
    @Id
    int age;
    String name;
    @Generated(hash = 1080248539)
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
