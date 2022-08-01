package com.varxyz.JavaCafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "pages/add_category";
	}
	
	
}
