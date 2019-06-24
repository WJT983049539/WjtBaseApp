package com.privatee.wjtbaseapp.sql;

import java.io.Serializable;

/**
 * 类的作用：
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018/6/29 12:14.
 */
public class BianQian implements Serializable{
    private String bianqianTile;
    private String BianqianContent;
    private String BianqianTime;
    private int BianqianId;

    public String getBianqianTile() {
        return bianqianTile;
    }

    public void setBianqianTile(String bianqianTile) {
        this.bianqianTile = bianqianTile;
    }

    public String getBianqianContent() {
        return BianqianContent;
    }

    public void setBianqianContent(String bianqianContent) {
        BianqianContent = bianqianContent;
    }

    public String getBianqianTime() {
        return BianqianTime;
    }

    public void setBianqianTime(String bianqianTime) {
        BianqianTime = bianqianTime;
    }

    public int getBianqianId() {
        return BianqianId;
    }

    public void setBianqianId(int bianqianId) {
        BianqianId = bianqianId;
    }

    @Override
    public String toString() {
        return "BianQian{" +
                "bianqianTile='" + bianqianTile + '\'' +
                ", BianqianContent='" + BianqianContent + '\'' +
                ", BianqianTime='" + BianqianTime + '\'' +
                ", BianqianId=" + BianqianId +
                '}';
    }
}
