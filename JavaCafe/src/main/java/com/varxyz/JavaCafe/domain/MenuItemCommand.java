package com.varxyz.JavaCafe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItemCommand {
	private String cateCodeRef;
	private String cateCode;
	private String menuName;
	private Double menuPrice;
	private String menuInfo;
	private Long imgCode;
	private String imgName;
	private String imgSource;
	private String imgUrl;
}
