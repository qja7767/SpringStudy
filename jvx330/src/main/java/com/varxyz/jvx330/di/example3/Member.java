package com.varxyz.jvx330.di.example3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	private String userId;
	private String name;
	
	public Member(String userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

}
