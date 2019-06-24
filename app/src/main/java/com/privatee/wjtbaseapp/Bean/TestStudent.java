package com.privatee.wjtbaseapp.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @auther wjt
 * @date 2019/4/28
 */
@Entity
    public class TestStudent {
    String id;
    @Property
    String StudentName;
    @Convert(columnType = String.class, converter = TwoListBeanConverter.class)
    List <TwoListBean> listBeans;
    @Generated(hash = 1938456741)
    public TestStudent(String id, String StudentName, List<TwoListBean> listBeans) {
        this.id = id;
        this.StudentName = StudentName;
        this.listBeans = listBeans;
    }
    @Generated(hash = 1786807495)
    public TestStudent() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStudentName() {
        return this.StudentName;
    }
    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }
    public List<TwoListBean> getListBeans() {
        return this.listBeans;
    }
    public void setListBeans(List<TwoListBean> listBeans) {
        this.listBeans = listBeans;
    }
    public static class TwoListBeanConverter implements PropertyConverter<List <TwoListBean>,String>{
        @Override
        public List<TwoListBean> convertToEntityProperty(String databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            // 先得获得这个，然后再typeToken.getType()，否则会异常
            TypeToken<List<TwoListBean>> typeToken = new TypeToken<List<TwoListBean>>(){};
            return new Gson().fromJson(databaseValue, typeToken.getType());
        }

        @Override
        public String convertToDatabaseValue(List<TwoListBean> entityProperty) {
            if (entityProperty == null||entityProperty.size()==0) {
                return null;
            } else {
                String sb = new Gson().toJson(entityProperty);
                return sb;

            }
        }
    }
}
