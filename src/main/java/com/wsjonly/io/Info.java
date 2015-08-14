package com.wsjonly.io;

import java.io.Serializable;

import javax.persistence.Transient;

public class Info implements Serializable{
	private static final long serialVersionUID = 4209585170118428261L;
	
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "age=" + this.age + "\nname=" + this.name;
	}
}
