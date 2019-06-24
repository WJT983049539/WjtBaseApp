package com.privatee.wjtbaseapp.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * @auther wjt
 * @date 2019/4/28
 */
@Entity
public class TwoListBean  {
    @Property
    int value;
    @Property
    String lastname;
    @Generated(hash = 438590034)
    public TwoListBean(int value, String lastname) {
        this.value = value;
        this.lastname = lastname;
    }
    @Generated(hash = 1426358294)
    public TwoListBean() {
    }
    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String getLastname() {
        return this.lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
