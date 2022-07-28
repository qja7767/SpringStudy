package com.varxyz.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.banking.dao.AccountDao;
import com.varxyz.banking.domain.Account;

public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountDao accountDao;

	@Override
	public void addAccounts(Account account) {
		accountDao.addAccount(account);
	}
	
	@Override
	public List<Account> getAllAccount() {
		return accountDao.getAllAccounts();
	}

	@Override
	public List<Account> getAccounts(String userId) {
		return accountDao.getAccounts(userId);
	}

	@Override
	public void doTransfer(double money, String withdrawAccountNum, String depositAccountNum) {
		accountDao.doTransfer(money, withdrawAccountNum, depositAccountNum);
		
	}

	@Override
	public double getBalance(String accountNum) {		
		return accountDao.getBalance(accountNum);
	}

}
