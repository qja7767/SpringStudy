package com.varxyz.banking;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.jdbc.DataSourceConfig;

@Controller("banking.addCustomerController")
public class AddCustomerController {
	
	@GetMapping("/banking/add_customer")
	public String addCustomerForm() {
		return "banking/add_customer";
	}
	
	@PostMapping("/banking/add_customer")
	public String addCustomer(Customer customer, Model model) {		
		model.addAttribute("customer", customer);
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
		
		dao.addCustomer(customer);
				
		context.close();
		
		return "banking/success_add_customer";
	}
	
}
