package com.privatee.wjtbaseapp.Bean;

/**
 * @author wjt
 * @date 2019/8/23 18:36
 * @contact 983049539@qq.com
 */
public class UserTest {
    //类属性定义为final不可改变和修饰
    private final String name;//必选
    private final String cardId;//必选
    private final  int age;//必选
    private final String address;//必选
    private final String phone;//必选

    private  UserTest(UserBuilder userBuilder){
       this.phone=userBuilder.phone;
       this.age=userBuilder.age;
       this.address=userBuilder.address;
       this.name=userBuilder.name;
       this.cardId=userBuilder.cardID;
    }
    public String getName(){
        return name;
    }

    public String getCardID() {
        return cardId;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

public static class UserBuilder{
    private final String name;
    private final String cardID;
    private int age;
    private String address;
    private String phone;


    public UserBuilder(String name,String cardID){
        this.name=name;
        this.cardID=cardID;
    }

    public UserBuilder age(int age){
        this.age=age;
        return this;
    }
    public UserBuilder address(String address){
        this.address=address;
        return this;
    }
    public UserBuilder phone(String phone){
        this.phone=phone;
        return this;
    }
    public UserTest builder(){
        return new UserTest(this);
    }
}


}
