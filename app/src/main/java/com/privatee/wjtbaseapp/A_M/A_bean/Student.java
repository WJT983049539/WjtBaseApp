package com.privatee.wjtbaseapp.A_M.A_bean;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private int age;
	private String adress;
	private String phoneNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				", adress='" + adress + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				'}';
	}
}
