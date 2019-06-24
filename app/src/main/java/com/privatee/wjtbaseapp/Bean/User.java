package com.privatee.wjtbaseapp.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * @auther wjt
 * @date 2019/4/28
 */
@Entity
public class User {
    @Property
    String age;
    @Convert(columnType = String.class, converter = TestStudentListBeanConverter.class)
    List<TestStudent> listbean;
    @Generated(hash = 1719820277)
    public User(String age, List<TestStudent> listbean) {
        this.age = age;
        this.listbean = listbean;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public List<TestStudent> getListbean() {
        return this.listbean;
    }
    public void setListbean(List<TestStudent> listbean) {
        this.listbean = listbean;
    }
        public static class TestStudentListBeanConverter implements PropertyConverter<List<TestStudent>,String>{
            @Override
            public List<TestStudent> convertToEntityProperty(String databaseValue) {
                if (databaseValue == null) {
                    return null;
                }
                // 先得获得这个，然后再typeToken.getType()，否则会异常
                TypeToken<List<TestStudent>> typeToken = new TypeToken<List<TestStudent>>(){};
                return new Gson().fromJson(databaseValue, typeToken.getType());
            }

            @Override
            public String convertToDatabaseValue(List<TestStudent> entityProperty) {
                if (entityProperty == null||entityProperty.size()==0) {
                    return null;
                } else {
                    String sb = new Gson().toJson(entityProperty);
                    return sb;

                }
            }
        }
}
