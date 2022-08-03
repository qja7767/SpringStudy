package com.varxyz.JavaCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.varxyz.JavaCafe.dao.MenuItemDao;
import com.varxyz.JavaCafe.domain.FindMenuItemCommand;
import com.varxyz.JavaCafe.domain.MenuImage;
import com.varxyz.JavaCafe.domain.MenuItem;

public class MenuItemServiceImpl implements MenuItemService{
	
	@Autowired
	MenuItemDao menuItemDao;
	

	@Override
	public void addMenuItem(MenuItem menuItem) {
		menuItemDao.addMenuItem(menuItem);
	}

	@Override
	public void addMenuItemImg(MenuImage menuImage) {
		menuItemDao.addMenuItemImg(menuImage);		
	}
	
	@Override
	public List<MenuItem> getAllMenuItem() {
		return menuItemDao.getAllMenuItem();
	}
	
	@Override
	public List<MenuImage> getMenuImageByMenuItem(String menuImg) {		
		return menuItemDao.getMenuImageByMenuItem(menuImg);
	}

	@Override
	public List<MenuImage> getAllMenuImage() { 
		return menuItemDao.getAllMenuImage();
	}

	@Override
	public List<FindMenuItemCommand> allFindMenu() {
		return menuItemDao.allFindMenu();
	}

}



