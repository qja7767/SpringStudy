package com.varxyz.JavaCafe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuImage {
	private long imgCode;
	private String cateCode;
	private String imgName;
	private String imgSource;
	private String imgUrl;
	
	public MenuImage() {	
	}
	
}

//=====MenuImage TABLE=====
//imgCode 		BIGINT 			PRIMARY KEY AUTO_INCREMENT,
//cateCode		VARCHAR(20)		DEFAULT NULL,
//imgName		VARCHAR(300)	DEFAULT NULL,
//imgSource		VARCHAR(300)	DEFAULT NULL,
//imgUrl		VARCHAR(300)	DEFAULT NULL,
