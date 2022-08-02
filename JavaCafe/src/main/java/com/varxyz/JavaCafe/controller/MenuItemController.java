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
import com.varxyz.JavaCafe.domain.MenuItem;
import com.varxyz.JavaCafe.service.MenuCategoryServiceImpl;
import com.varxyz.JavaCafe.service.MenuItemServiceImpl;

@Controller("controller.menuItemController")
@RequestMapping("pages/add_menu_item")
public class MenuItemController {
	@Autowired
	MenuItemServiceImpl menuItemService;
	@Autowired
	MenuCategoryServiceImpl menuCategoryService;
	
	@GetMapping
	public String addMenuItemForm(Model model, HttpServletRequest request) {
		model.addAttribute("menuItem", new MenuItem());
		List<MenuCategory> menuCategoryList =
				menuCategoryService.getAllMenuCategory();
		request.setAttribute("menuCategoryList", menuCategoryList);							
		
		return "pages/add_menu_item";
	}
	
	@PostMapping
	public String addMenuItem(@ModelAttribute("menuItem")
		MenuItem menuItem, Model model) {
		
		menuItemService.addMenuItem(menuItem);
		model.addAttribute("menuItem", menuItem);
		return "main";		
	}
}
