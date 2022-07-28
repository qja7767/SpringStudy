package com.varxyz.banking.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.banking.dao.CustomerDao;
import com.varxyz.banking.domain.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public boolean isValidUser(String userId, String passwd) {
		return customerDao.isValidUser(userId, passwd);
	}
	
	public Customer getCustomerByUserId(String userId) {
		return customerDao.getCustomerByUserId(userId);
	}
	
	public Customer getCustomerByAccountNum(String accountNum) {
		return customerDao.getCustomerByAccountNum(accountNum);
	}
}



