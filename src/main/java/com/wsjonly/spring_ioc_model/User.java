package com.wsjonly.spring_ioc_model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -4300409148070030484L;
	
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
