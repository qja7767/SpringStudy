package com.varxyz.jvx330.lifecycle.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import com.varxyz.jvx330.lifecycle.AppConfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goat {
	private static int count;
	private String name;
	
	public Goat() {
		count++;
	}
	
	private static int getCount() {
		return count;
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		//싱글톤 TEST
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);	
		System.out.println("Goat's final count : " + Goat.getCount());
		context.close();
	}
}
