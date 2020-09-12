package com.privatee.wjtbaseapp.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author:create by
 * 邮箱 983049539@qq.com
 */
public class MMKVTestBean implements Parcelable {
private String test;
private int age;
private boolean falg;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFalg() {
        return falg;
    }

    public void setFalg(boolean falg) {
        this.falg = falg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.test);
        dest.writeInt(this.age);
        dest.writeByte(this.falg ? (byte) 1 : (byte) 0);
    }

    public MMKVTestBean() {
    }

    protected MMKVTestBean(Parcel in) {
        this.test = in.readString();
        this.age = in.readInt();
        this.falg = in.readByte() != 0;
    }

    public static final Parcelable.Creator<MMKVTestBean> CREATOR = new Parcelable.Creator<MMKVTestBean>() {
        @Override
        public MMKVTestBean createFromParcel(Parcel source) {
            return new MMKVTestBean(source);
        }

        @Override
        public MMKVTestBean[] newArray(int size) {
            return new MMKVTestBean[size];
        }
    };
}
