package com.varxyz.JavaCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.JavaCafe.dao.MenuCategoryDao;
import com.varxyz.JavaCafe.domain.MenuCategory;

public class MenuCategoryServiceImpl implements MenuCategoryService{
	
	@Autowired
	MenuCategoryDao menuCategoryDao;


	@Override
	public void addMenuCategory(MenuCategory menuCategory) {
		menuCategoryDao.addMenuCategory(menuCategory);
	}

	@Override
	public List<MenuCategory> getAllMenuCategory() {
		return menuCategoryDao.getAllMenuCategory();
	}

	@Override
	public List<MenuCategory> getMenuCategoryByCateCodeRef(String cateCodeRef) {		
		return menuCategoryDao.getMenuCategoryByCateCodeRef(cateCodeRef);
	}
}



