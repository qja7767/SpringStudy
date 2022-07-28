package com.varxyz.banking;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);		
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)"
				+ " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, customer.getEmail(), customer.getPasswd(),
				customer.getName(), customer.getSsn(), customer.getPhone());
	}
	
	public List<Customer> findAllCustomer() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	public List<Customer> findCustomerByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate"
				+ " FROM Customer WHERE DATE(regDate)=?";
		
		return jdbcTemplate.query(sql, new CustomerRowMapper(), regDate);
	}
	
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate"
				+ " FROM Customer WHERE email=?";
		
		return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), email);			
	}
	
	public Customer findCidByEmail(String email) {
		String sql = "SELECT cid"
				+ " FROM Customer WHERE cid=?";
		
		return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), email);			
	}
	
	public long countCustomers() {
		String sql = "SELECT count(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
	
}
