package com.varxyz.JavaCafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.JavaCafe.domain.MenuCategory;
import com.varxyz.JavaCafe.service.MenuCategoryServiceImpl;

@Controller("controller.menuCategoryFindController")
@RequestMapping("/pages/find_all_category")
public class MenuCategoryFindController {
	@Autowired
	MenuCategoryServiceImpl menuCategoryService;	
	
	@GetMapping
	public String findAllMenuCategory1(HttpServletRequest request) {
		
		return "pages/find_all_category";
	}
	
	@PostMapping
	public String findAllMenuCategory(HttpServletRequest request) {
		
		List<MenuCategory> menuCategoryList = menuCategoryService.getAllMenuCategory();
		request.setAttribute("menuCategoryList", menuCategoryList);
		
		return "pages/find_all_category";
		
	}
	
	
}
