package com.varxyz.jvx330.di.example5.ex2;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class QualifierAutowireTest {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example5/ex2/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		CartController controller = context.getBean("cartController", CartController.class);
		controller.processRequest();
		CartController controller2 = context.getBean("cartController", CartController.class);
		controller2.processRequest();
		
		context.close();
		
	}
}
