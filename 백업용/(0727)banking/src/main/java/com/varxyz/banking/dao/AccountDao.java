package com.varxyz.banking.dao;

import static java.sql.Types.*;
import static java.sql.Types.CHAR;
import static java.sql.Types.DOUBLE;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.SavingAccount;


public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account (customerId, accountNum, accType, balance, interestRate, overAmount)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		SavingAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		int[] types = new int[] {BIGINT, CHAR, CHAR, DOUBLE, DOUBLE, DOUBLE};
		
		if(account instanceof SavingAccount) {
			sa = (SavingAccount)account;
			args = new Object[] {
					sa.getCustomer().getCid(), sa.getAccountNum(), String.valueOf(sa.getAccType()),
					sa.getBalance(), sa.getInterestRate(), 0.0
			};
		}else {
			ca = (CheckingAccount)account;
			args = new Object[] {
					ca.getCustomer().getCid(), ca.getAccountNum(), String.valueOf(ca.getAccType()),
					ca.getBalance(), 0.0, ca.getOverAmount()
			};
		}
			
		jdbcTemplate.update(sql, args, types);
		System.out.println("계좌신청 완료");
	}
	
	//이메일로 계좌 찾기
	public List<Account> getAccounts(String email){
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance,"
				+ " a.interestRate, a.overAmount, a.regDate"
				+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid"
				+ " WHERE c.email=?";
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), email);
	}
	
	//모든 계좌 조회
	public List<Account> getAllAccounts() {
		String sql = "SELECT aid, customerId, accountNum, accType, balance,"
				+ " interestRate, overAmount, regDate FROM Account";
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper());
	}
	
	//송금
	public void transfer(double money, String withdrawAccountNum, String depositAccountNum) {
		String sql = "UPDATE Account SET balance = balance - ? WHERE accountNum=?";
		String sql2 = "UPDATE Account SET balance = balance + ? WHERE accountNum=?";
		jdbcTemplate.update(sql, money, withdrawAccountNum);
		jdbcTemplate.update(sql2, money, depositAccountNum);
	}
	
	//입금
	public void doWithdraw(double money) {
		String sql = "UPDATE Account SET balance = balance + ? WHERE accountNum=?";
		jdbcTemplate.update(sql, money);
	}
	
	//출금
	public void doDeposit(double money) {
		String sql = "UPDATE Account SET balance = balance - ? WHERE accountNum=?";
		jdbcTemplate.update(sql, money);
	}
	
	public void saveInterest(String accountNum, double interestRate) {
		String sql = "UPDATE Account SET balance = balance + "
				+ "(balance * (balance / ?)) WHERE accountNum=?";
		jdbcTemplate.update(sql, interestRate, accountNum);
	}
	
	public long getBalance(String accountNum) {
		String sql = "SELECT a.balance FROM Account a INNER JOIN Customer c ON"
				+ " a.customerId = c.cid WHERE a.accountNum=?";
		
		return jdbcTemplate.queryForObject(sql, Long.class, accountNum);
	}
	
}
