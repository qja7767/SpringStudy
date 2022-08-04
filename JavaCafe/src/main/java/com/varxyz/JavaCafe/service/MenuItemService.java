package com.varxyz.JavaCafe.service;

import java.util.List;

import com.varxyz.JavaCafe.domain.MenuItemCommand;
import com.varxyz.JavaCafe.domain.MenuImage;
import com.varxyz.JavaCafe.domain.MenuItem;

public interface MenuItemService {
	public void addMenuItem(MenuItem menuItem);
	public void addMenuItemImg(MenuImage menuImage);
	List<MenuItem> getAllMenuItem();
	List<MenuImage> getMenuImageByMenuItem(String menuImg);
	List<MenuImage> getAllMenuImage();
	List<MenuItemCommand> allFindMenu();
	List<MenuItemCommand> allFindMenuByMenuName(String menuName);
	public void updateMenuItem(MenuItemCommand menuItemCommand, String menuName);
	public void deleteMenuItem(String menuName);
}
