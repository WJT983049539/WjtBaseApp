package com.privatee.wjtbaseapp.service;

/**
 * @auther wjt
 * @date 2019/5/27
 */
public class PlanItemModel {
    private String id;
    private String code;
    private String planId;
    private String devicePropertyId;
    private String devicePropertyName;
    private String deviceId;
    private String deviceName;
    private String descr;
    private int value;
    private String propertyRank;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getDevicePropertyId() {
        return devicePropertyId;
    }

    public void setDevicePropertyId(String devicePropertyId) {
        this.devicePropertyId = devicePropertyId;
    }

    public String getDevicePropertyName() {
        return devicePropertyName;
    }

    public void setDevicePropertyName(String devicePropertyName) {
        this.devicePropertyName = devicePropertyName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getPropertyRank() {
        return propertyRank;
    }

    public void setPropertyRank(String propertyRank) {
        this.propertyRank = propertyRank;
    }

    @Override
    public String toString() {
        return "PlanItemModel{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", planId='" + planId + '\'' +
                ", devicePropertyId='" + devicePropertyId + '\'' +
                ", devicePropertyName='" + devicePropertyName + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", descr='" + descr + '\'' +
                ", value=" + value +
                ", propertyRank='" + propertyRank + '\'' +
                '}';
    }
}
