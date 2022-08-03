package com.varxyz.JavaCafe.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItem {
	private String cateCodeRef;
	private String cateCode;
	private String menuName;
	private double menuPrice;
	private int menuNum;
	private int menuStock;
	private String menuInfo;
	private String menuImg;
	private Date regDate;
	private MenuImage menuImage;
	private MenuCategory menuCategory;
	
	public MenuItem() {
		
	}
}
