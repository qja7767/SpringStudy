package com.varxyz.jvx330.intro;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
		String config="com/varxyz/jvx330/intro/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		Hello hello = context.getBean("helloBean", Hello.class);
		Hello hello1 = context.getBean("helloBean1", Hello.class);
		
		Hello helloEn = new HelloBeanEn(); // 일반 자바
		Hello helloKo = new HelloBeanKo();
		
		System.out.println(helloEn.sayHello("Spring"));
		System.out.println(helloKo.sayHello("Spring"));
		System.out.println(hello.sayHello("Spring"));//스프링 XML
		System.out.println(hello1.sayHello("Spring"));//스프링 XML
		
		context.close();	
	}
}
