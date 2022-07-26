package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
		String config="com/varxyz/jvx330/di/example1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		//스프링, 클래스만들기->관계설정
		Foo foo = context.getBean("foo", Foo.class);
		System.out.println(foo);
		
		//객체 재사용함 확인가능
		Foo foo2 = context.getBean("foo2", Foo.class);
		System.out.println(foo2);
		
		context.close();
		
		//기존 자바
		Bar bar1 = new Bar();
		Foo foo1 = new Foo(bar1);
		
	}
}
