package com.varxyz.JavaCafe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.JavaCafe.dao.MenuItemProvider;
import com.varxyz.JavaCafe.domain.MenuCategory;
import com.varxyz.JavaCafe.service.MenuCategoryServiceImpl;

@Controller("controller.menuCategoryController")
@RequestMapping("/pages/add_category")
public class MenuCategoryController {
	@Autowired
	MenuCategoryServiceImpl menuCategoryService;	
	
	@GetMapping
	public String addMenuCategoryForm(Model model) {
		model.addAttribute("menuCategory", new MenuCategory());
		return "pages/add_category";
	}
	
	@PostMapping
	public String addMenuCategory(@ModelAttribute("menuCategory")
		MenuCategory menuCategory, Model model) {
		
		menuCategoryService.addMenuCategory(menuCategory);
		
		model.addAttribute("menuCategory", menuCategory);
		return "main";
	}
	
	@ModelAttribute("MenuItemProviderList")
	public List<MenuItemProvider> getEmailProviderList() {
		List<MenuItemProvider> list = new ArrayList<MenuItemProvider>();
		list.add(new MenuItemProvider("커피", "100"));
		list.add(new MenuItemProvider("에이드", "200"));
		list.add(new MenuItemProvider("스무디", "300"));			
		list.add(new MenuItemProvider("디저트", "400"));
		return list;
	}
	
}
