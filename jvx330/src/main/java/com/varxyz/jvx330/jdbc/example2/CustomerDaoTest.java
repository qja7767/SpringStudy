package com.varxyz.jvx330.jdbc.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.DataSourceConfig;
import com.varxyz.jvx330.jdbc.example1.AddCustomerDao;

public class CustomerDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
		findAllCustomers(dao);
		
		context.close();
	}
	
	public static void findAllCustomers(CustomerDao dao) {
		System.out.println("[findAllCustomers()]");
		dao.findAllCustomer().forEach(c -> System.out.println(c));
	}
	
	public static void findCustomerByRegDate(CustomerDao dao) {
		dao.findCustomerByRegDate().forEach(c -> System.out.println(c));
	}
	
}
