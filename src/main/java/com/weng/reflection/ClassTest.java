package com.weng.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Person{
	int age;
	String name;

	public Person(){
	}
	
	public Person(int age){
		this.age = age;
	}
	
	public Person(String name){
		this.name = name;
	}
	
	

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

	public byte[] getBytes() {
		return name.getBytes();
	}
	
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
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
	
	
}

public class ClassTest {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Class<?> a = Person.class;
		Constructor<?>[] con = Person.class.getConstructors();
		Constructor<?> cons = Person.class.getConstructor(new Class<?>[]{int.class, String.class});
		Person p = (Person) cons.newInstance(new Object[] {24, "Shijin Weng"});
		System.out.println(p.hashCode());
	}
}
