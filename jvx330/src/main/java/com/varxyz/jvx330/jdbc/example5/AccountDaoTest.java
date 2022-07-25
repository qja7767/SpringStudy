package com.varxyz.jvx330.jdbc.example5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Account;
import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;
import com.varxyz.jvx330.jdbc.example1.AddCustomerDao;
import com.varxyz.jvx330.jdbc.example3.CustomerDao;

public class AccountDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		AccountDao dao = context.getBean("accountDao", AccountDao.class);

		findCustomerBySsn(dao);
	}
	
	public static void findCustomerBySsn(AccountDao dao) {
		System.out.println("==========findCustomerBySsn==========");
		System.out.println(dao.findAccountsBySsn("111111-2222222"));
		dao.findAccountsBySsn("111111-2222222");
	}
	

	

}
