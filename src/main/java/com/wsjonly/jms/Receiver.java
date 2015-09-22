package com.wsjonly.jms;

import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * <b>function:</b> Spring JMSTemplate 消息接收者
 * 
 * @author hoojo
 * @createDate 2013-6-24 下午02:22:32
 * @file Receiver.java
 * @package com.hoo.mq.spring.support
 * @project ActiveMQ-5.8
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class Receiver {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext-*.xml");

		JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");
		while (true) {
			Map<String, Object> map = (Map<String, Object>) jmsTemplate.receiveAndConvert();

			System.out.println("收到消息：" + map.get("message"));
		}
	}
}