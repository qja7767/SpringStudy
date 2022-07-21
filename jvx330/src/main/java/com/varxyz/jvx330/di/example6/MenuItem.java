package com.varxyz.jvx330.di.example6;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class MenuItem {
	private String name;
	private int price;
	
	public MenuItem(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
}
