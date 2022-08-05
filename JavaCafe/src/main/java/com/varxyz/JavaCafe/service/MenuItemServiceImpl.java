package com.varxyz.JavaCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.varxyz.JavaCafe.dao.MenuItemDao;
import com.varxyz.JavaCafe.domain.MenuItemCommand;
import com.varxyz.JavaCafe.domain.Cart;
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
	public List<MenuItemCommand> allFindMenu() {
		return menuItemDao.allFindMenu();
	}

	@Override
	public List<MenuItemCommand> getMenuItemByMenuName(String menuName) {
		return menuItemDao.allFindMenuByMenuName(menuName);
	}
	
	@Override
	public void updateMenuItem(MenuItemCommand menuItemCommand, String menuName) {
		menuItemDao.updateMenuItem(menuItemCommand, menuName);		
	}

	@Override
	public void deleteMenuItem(String menuName) {
		menuItemDao.deleteMenuItem(menuName);
		
	}

	@Override
	public void addCart(Cart cart) {
		menuItemDao.addCart(cart);
		
	}

	@Override
	public MenuItem getAllMenuItemByMenuName(String menuName) {		
		return menuItemDao.getAllMenuItemByMenuName(menuName);
	}

	@Override
	public List<Cart> allFindCart() {
		return menuItemDao.allFindCart();
	}

	@Override
	public void deleteCartItem(String menuName) {
		menuItemDao.deleteCartItem(menuName);
		
	}
	
	
}



