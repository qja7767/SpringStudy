package com.varxyz.JavaCafe.service;

import java.util.List;

import com.varxyz.JavaCafe.domain.MenuCategory;

public interface MenuCategoryService {
	public void addMenuCategory(MenuCategory menuCategory);
	List<MenuCategory> getAllMenuCategory();
	List<MenuCategory> getMenuCategoryByCateCodeRef(String cateCodeRef);
}
