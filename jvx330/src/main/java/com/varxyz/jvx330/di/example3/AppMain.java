package com.varxyz.jvx330.di.example3;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
		
		//XML으로 출력		
//		String config="com/varxyz/jvx330/di/example3/beans.xml";
//		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		//No XML
		GenericApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		//공통		
		MemberService memberService = context.getBean("memberService", MemberService.class);
		
		//람다식 스타일 출력
		memberService.getAllMembers().forEach(member -> System.out.println(member));
		
		//기본 스타일 출력
		List<Member> list = memberService.getAllMembers();
		for(Member member : list) {
			System.out.println(member);
		}
		context.close();
	}	
}
