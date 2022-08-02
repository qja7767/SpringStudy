package com.varxyz.JavaCafe.service;

import java.util.List;

import com.varxyz.JavaCafe.domain.MenuItem;

public interface MenuItemService {
	public void addMenuItem(MenuItem menuItem);
	List<MenuItem> getAllMenuItem();
}
