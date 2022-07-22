package com.varxyz.jvx330.lifecycle.example3;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Horse implements InitializingBean, DisposableBean {
	private static int count;
	private String name;
	
	@PostConstruct
	public void initMenuData() {
		
	}
	
	public Horse() {
		count++;
	}
	
	private static int getCount() {
		return count;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//프로퍼티 세팅이후 호출되는 메서드
		System.out.println("horse afterPropertiesSet 호출");
		if(name==null) {
			System.out.println("horse Property name must be set");
		}else {
			System.out.println(name);
		}
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("horse destory 호출");
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		//프로토타입 TEST
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);		
		System.out.println("Horse's final count : " + Horse.getCount());
		context.close();
	}
}
