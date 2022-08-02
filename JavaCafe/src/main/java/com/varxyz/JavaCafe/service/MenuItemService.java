package com.varxyz.JavaCafe.service;

import java.util.List;

import com.varxyz.JavaCafe.domain.MenuImage;
import com.varxyz.JavaCafe.domain.MenuItem;

public interface MenuItemService {
	public void addMenuItem(MenuItem menuItem);
	public void addMenuItemImg(MenuImage menuImage);
	List<MenuItem> getAllMenuItem();
}
