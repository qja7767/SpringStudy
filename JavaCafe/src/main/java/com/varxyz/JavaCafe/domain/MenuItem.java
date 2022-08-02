package com.varxyz.JavaCafe.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	private MenuCategory menuCategory;
}
