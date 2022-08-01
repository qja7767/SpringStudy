package com.varxyz.jvx330.mvc.example6;

import com.varxyz.jvx330.mvc.example5.CustomerCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCommand {
	private String accountNum;
	private double balance;
	private String accType;
	private CustomerCommand customer;
	
}
