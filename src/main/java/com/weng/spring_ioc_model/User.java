package com.weng.spring_ioc_model;

public class User {
	String name;
	String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String toString(){
		return "[name:" + name +";" + "age:" + age + "]";
	}
}
