package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MenuItemTest {
	
	public static void main(String[] args) {
		
		//XML		
		String config="com/varxyz/jvx330/di/example6/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);		
		
		//공통		
		MenuItemService menuItemService = context.getBean("menuItemService", MenuItemService.class);
		
		//출력

		
		context.close();
	}	
}
