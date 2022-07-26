package com.varxyz.banking;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.jdbc.DataSourceConfig;

@Controller("banking.addAccountController")
public class AddAccountController {
	char accType;

	@GetMapping("/banking/add_account")
	public String addAccountForm() {
		return "banking/add_account";
	}
	
	@PostMapping("/banking/add_account")
	public String addAccount(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AccountDao Adao = context.getBean("accountDao", AccountDao.class);		
		
		CustomerDao Cdao = context.getBean("customerDao", CustomerDao.class);
		Customer c = Cdao.findCustomerByEmail(email);
		
		email = c.getEmail();
		Cdao.findCustomerByEmail(email);
		
		context.close();
		return "banking/add_account2";
	}
	
	@PostMapping("/banking/add_account2")
	public String addAccount2(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");
		String accountType = request.getParameter("accountType");
		
		if(accountType.equals("SavingsAccount")) {
			accType = 'S';
		}else if(accountType.equals("CheckingAccount")) {
			accType = 'C';
		}
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AccountDao Adao = context.getBean("accountDao", AccountDao.class);		
		
		CustomerDao Cdao = context.getBean("customerDao", CustomerDao.class);
		Customer c = Cdao.findCustomerByEmail(email);
		
		email = c.getEmail();
		
		Account account = null;
		
		if(accType == 'C') {
			account = new CheckingAccount();
		}else if (accType == 'S' ) {
			account = new SavingsAccount();
		}
		
		Adao.addAccount(account);
		
		context.close();
		return "banking/success_add_account";
	}
	
}
