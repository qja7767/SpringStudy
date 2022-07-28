package com.varxyz.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.SavingAccount;
import com.varxyz.banking.service.AccountServiceImpl;
import com.varxyz.banking.service.CustomerServiceImpl;

@Controller
public class AccountController {
	
	@Autowired
	AccountServiceImpl accountService;
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@GetMapping("account/add_account")
	public String addAccountForm() {
		return "/account/add_account";
	}
	
	//신규 계좌 추가
	@PostMapping("account/add_account")
	public String addAccount(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		char accType = request.getParameter("accType").charAt(0);
		Account account = null;
		
		if(accType == 'S') {
			account = new SavingAccount();
		}else if (accType == 'C') {
			account = new CheckingAccount();
		}
		
		account.setAccountNum(generateAccount());
		account.setCustomer(customerService.getCustomerByUserId(userId));
		account.setAccType(accType);
		accountService.addAccounts(account);
		request.setAttribute("accType", account.getAccountNum());
		return "account/add_success_account";		
	}
	
	//이메일(이메일ID)로 해당 계좌찾기
	@PostMapping("account/find_account")
	public String viewAccount(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
								
		List<Account> accountList = accountService.getAccounts(userId);
		request.setAttribute("accountList", accountList);
		return "account/view_my_accounts";
	}
	
	//모든 계좌찾기(관리자)
	@PostMapping("account/find_all_account")
	public String viewAllAccount(HttpServletRequest request) {
		
		List<Account> accountList = accountService.getAllAccount();
		request.setAttribute("accountList", accountList);
		return "account/view_all_accounts";
	}
	
	//랜덤 계좌생성기( ex.XXX-XX-XXXX )
	public String generateAccount() {
		String numStr = String.valueOf((int)(Math.random() * 100000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0, 3));
		sb.append("-");
		sb.append(numStr.substring(3, 5));
		sb.append("-");
		sb.append(numStr.substring(5));
		
		return sb.toString();
	}
}
