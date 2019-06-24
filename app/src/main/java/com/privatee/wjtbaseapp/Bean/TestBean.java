package com.privatee.wjtbaseapp.Bean;

import com.google.gson.Gson;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.converter.PropertyConverter;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @auther wjt
 * @date 2019/4/28
 */
@Entity
public class TestBean {
    @Id
    long id;
    @Property
    String name;
    @Convert(converter = UserConverter.class, columnType = String.class)
    @Property
    User user;
    @Generated(hash = 711929995)
    public TestBean(long id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }
    @Generated(hash = 2087637710)
    public TestBean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public static class UserConverter implements PropertyConverter<User,String>{

        @Override
        public User convertToEntityProperty(String databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            return new Gson().fromJson(databaseValue, User.class);
        }

        @Override
        public String convertToDatabaseValue(User entityProperty) {
            if (entityProperty == null) {
                return null;
            }
            return new Gson().toJson(entityProperty);
        }
    }
}
