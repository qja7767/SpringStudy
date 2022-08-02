package com.varxyz.JavaCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.varxyz.JavaCafe.dao.MenuItemDao;
import com.varxyz.JavaCafe.domain.MenuItem;

public class MenuItemServiceImpl implements MenuItemService{
	
	@Autowired
	MenuItemDao menuItemDao;
	

	@Override
	public void addMenuItem(MenuItem menuItem) {
		menuItemDao.addMenuItem(menuItem);
	}

	@Override
	public List<MenuItem> getAllMenuItem() {
		return menuItemDao.getAllMenuItem();
	}
}



