package com.varxyz.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.domain.SavingAccount;
import com.varxyz.banking.service.AccountServiceImpl;
import com.varxyz.banking.service.CustomerServiceImpl;

@Controller
public class MoneyTransferController {
	@Autowired
	AccountServiceImpl accountService;
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@GetMapping("account/withdraw")
	public String moneyWithdraw() {
		
		return "account/withdraw";
	}
	
	@GetMapping("account/deposit")
	public String moneyDeposit() {
		
		return "account/deposit";
	}
	
	@GetMapping("account/transfer1")
	public String moneyTransferForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		List<Account> accountList = accountService.getAccounts(userId);
		request.setAttribute("accountList", accountList);		
		return "account/transfer1";
	}
	
	@PostMapping("account/transfer1")
	public String moneyTransferStep1(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");				
		
		String withdrawAccNum = request.getParameter("withdrawAccNum");
		double money = Double.parseDouble(request.getParameter("money"));
		String depositAccNum = request.getParameter("depositAccNum");
		
		
		Customer withdrawCustomer = customerService.getCustomerByAccountNum(withdrawAccNum);
		Customer depositCustomer = customerService.getCustomerByAccountNum(depositAccNum);
		
		//계좌 들어가있는지 유효성검사			
		if(withdrawCustomer == null) {
			System.out.println("withdraw 계좌 유효성검사 실패");
			return "error";
		}
		if(depositCustomer == null) {
			System.out.println("deposit 계좌 유효성검사 실패");
			return "error";
		}
		
		session = request.getSession();
		session.setAttribute("withdrawAccNum", withdrawAccNum);
		session.setAttribute("withdrawCustomerName", withdrawCustomer.getName());
		session.setAttribute("withdrawCustomerPasswd", withdrawCustomer.getPasswd());
		
		session.setAttribute("depositAccNum", depositAccNum);
		session.setAttribute("depositCustomerName", depositCustomer.getName());
		session.setAttribute("money", money);
		
		return "account/transfer2";		
	}
	
	@PostMapping("account/transfer3")
	public String moneyTransferStep2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String withdrawAccNum = (String)session.getAttribute("withdrawAccNum");
		double money = (double)session.getAttribute("money");
		String depositAccNum = (String)session.getAttribute("depositAccNum");
		String validPasswd = (String)session.getAttribute("withdrawCustomerPasswd");
		String passwd = request.getParameter("passwd");
		
		
		//잔액초과 유효성검사
		double validMoney = accountService.getBalance(withdrawAccNum);
		if(money > validMoney) {
			System.out.println("잔액 초과 유효성검사 실패");
			return "error";
		}
				
		//비밀번호일치 유효성검사
		if(!validPasswd.equals(passwd)) {
			System.out.println("비밀번호 유효성검사 실패");
			return "error";
		}
		
		accountService.doTransfer(money, withdrawAccNum, depositAccNum);
		
		//기밀정보 세션삭제
		session.removeAttribute("withdrawAccNum");
		session.removeAttribute("withdrawCustomerName");
		session.removeAttribute("withdrawCustomerPasswd");
		
		session.removeAttribute("depositAccNum");
		session.removeAttribute("depositCustomerName");
		session.removeAttribute("money");
		
		System.out.println("transfer 기능 성공");
		
		return "account/add_account";
	}

}
