package com.weng.spring_ioc_model;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;


public class ClassPathXMLApplicationContext implements ApplicationContext{
	
	HashMap<String,Object> map = new HashMap<String, Object>();
	
	File file = null;
	
	public ClassPathXMLApplicationContext(String config_file) {
		// TODO Auto-generated constructor stub
		URL url =this.getClass().getClassLoader().getResource(config_file);
		
		try {
			file = new File(url.toURI());
			parseXML();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	private void parseXML() throws JDOMException, IOException, ClassNotFoundException, InstantiationException,
		IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(file);
//		System.out.println(doc.getRootElement());
		List<?> beans = XPath.selectNodes(doc.getRootElement(), "//bean");
		Iterator<?> iterator = beans.iterator();
		while(iterator.hasNext()){
			
			Element bean = (Element)iterator.next();
			String id = bean.getAttributeValue("id");
			String cls = bean.getAttributeValue("class");
			Object obj = Class.forName(cls).newInstance();
			Method[] methods = obj.getClass().getDeclaredMethods();
			@SuppressWarnings("unchecked")
			List<Element> properties =  bean.getChildren("property");
			
			for(Element property: properties){
				for(int i=0;i<methods.length;i++){
					String name = methods[i].getName();
					if (name.startsWith("set")){
						String v = name.substring(3, name.length()).toLowerCase();
//						System.out.println(v);
						
						if (property.getAttributeValue("name") != null){
							if (v.equals(property.getAttributeValue("name"))){
								methods[i].invoke(obj, property.getAttributeValue("value"));
							}
						} else {
//							System.out.println(property.getAttributeValue("ref"));
							methods[i].invoke(obj, map.get(property.getAttributeValue("ref")));
						}
						
					}
				}
			}
			
			map.put(id, obj);
		}
		
	}
	
	public Object getBean(String name) {
		// TODO Auto-generated method stub
		return map.get(name);
	}
	
}
