package com.varxyz.banking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.SavingAccount;
import com.varxyz.banking.service.AccountServiceImpl;
import com.varxyz.banking.service.CustomerServiceImpl;

@Controller
public class MoneyTransferController {
	@Autowired
	AccountServiceImpl accountService;
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@GetMapping("account/transfer1")
	public String moneyTransferForm() {
		return "account/transfer1";
	}
	
	@PostMapping("account/transfer1")
	public String moneyTransfer1(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String accountNum = request.getParameter("accountNum");
		String accountNum1 = request.getParameter("accountNum1");
		accountService.transfer(1000.0, accountNum, accountNum1);
		
		return "account/transfer1";		
	}
	
	@PostMapping("account/transfer2")
	public String moneyTransfer2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		return "account/transfer2";
	}
	
	@PostMapping("account/transfer3")
	public String moneyTransfer3(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		return "account/transfer3";
	}
	
	@PostMapping("account/trasnfer4")
	public String moneyTransfer4(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		return "account/trasnfer4";
	}
	
}
