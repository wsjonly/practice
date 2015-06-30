package com.wsjonly.spring_ioc_model;

import com.wsjonly.spring_ioc_model.ApplicationContext;
import com.wsjonly.spring_ioc_model.ClassPathXMLApplicationContext;
import com.wsjonly.spring_ioc_model.Person;

public class SpringIocTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXMLApplicationContext("applicationContext.xml");
		Person person = (Person)context.getBean("person");
		System.out.println(person.getUser().toString());
	}
}
