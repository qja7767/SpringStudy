package com.varxyz.jvx330.jdbc;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
	private long cid;
	private String email;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	private Date regDate;
}
