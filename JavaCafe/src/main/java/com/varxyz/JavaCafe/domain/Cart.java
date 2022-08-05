package com.varxyz.JavaCafe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cart {
	private String menuName;
	private double menuPrice;
	private int stock;
	
	public Cart() {
		
	}
}
