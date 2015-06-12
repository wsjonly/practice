package com.weng.spring_ioc_model;

public class SpringIocTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXMLApplicationContext("applicationContext.xml");
		Person person = (Person)context.getBean("person");
		System.out.println(person.getUser().toString());
	}
}
