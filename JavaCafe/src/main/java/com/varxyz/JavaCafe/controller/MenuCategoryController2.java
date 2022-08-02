package com.varxyz.JavaCafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.JavaCafe.domain.MenuCategory;
import com.varxyz.JavaCafe.service.MenuCategoryServiceImpl;


@Controller("controller.menuCategoryController2")
@RequestMapping("/pages/add_category2")
public class MenuCategoryController2 {
	@Autowired
	MenuCategoryServiceImpl menuCategoryService;	
	
	@GetMapping
	public String addMenuCategoryForm(HttpServletRequest request ,Model model) {
		model.addAttribute("menuCategory", new MenuCategory());		
		List<MenuCategory> menuCategoryList = menuCategoryService.getAllMenuCategory();
		request.setAttribute("menuCategoryList", menuCategoryList);
		
		return "pages/add_category2";
	}
	
	@PostMapping
	public String addMenuCategory(@ModelAttribute("menuCategory")
		MenuCategory menuCategory, Model model) {
		
		menuCategoryService.addMenuCategory(menuCategory);
		
		model.addAttribute("menuCategory", menuCategory);
		return "main";
	}
	
	
}
