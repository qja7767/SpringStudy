package com.varxyz.jvx330.jdbc.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AddCustomerDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		AddCustomerDao dao = context.getBean("addCustomerDao", AddCustomerDao.class);
//		addCustomer(dao);
//		addCustomer2(dao);
		addCustomer3(dao);
		
		context.close();
	}
		public static void addCustomer(AddCustomerDao dao) {			
			Customer c = new Customer();
			c.setEmail("qja@java.com");
			c.setPasswd("1111");
			c.setName("장비");
			c.setSsn("111111-2222222");
			c.setPhone("010-1111-2222");
			
			dao.addCustomer(c);
			System.out.println("-inserted-");
		}
		
		public static void addCustomer2(AddCustomerDao dao) {			
			Customer c = new Customer();
			c.setEmail("qja@java.com");
			c.setPasswd("1111");
			c.setName("장비");
			c.setSsn("111111-2222222");
			c.setPhone("010-1111-2222");
			
			dao.addCustomer2(c);
			System.out.println("-inserted-");
		}
	
		public static void addCustomer3(AddCustomerDao dao) {			
			Customer c = new Customer();
			c.setEmail("qja@java.com");
			c.setPasswd("1111");
			c.setName("조조");
			c.setSsn("444411-2222222");
			c.setPhone("010-4444-2222");
			
			long key = dao.addCustomer3(c);
			System.out.println("-key-" + key);
		}
	
	
}
