package com.varxyz.JavaCafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.JavaCafe.dao.MenuItemProvider;
import com.varxyz.JavaCafe.domain.MenuItem;
import com.varxyz.JavaCafe.service.MenuItemServiceImpl;

@Controller("controller.menuItemFindController")
@RequestMapping("/pages/find_all_menu_item")
public class MenuItemFindController {
	@Autowired
	MenuItemServiceImpl menuItemService;	
	
	@GetMapping
	public String findAllMenuItem1(HttpServletRequest request) {
		
		return "pages/find_all_menu_item";
	}
	
	@PostMapping
	public String findAllMenuItem(HttpServletRequest request) {
		
		List<MenuItem> menuItemList = menuItemService.getAllMenuItem();
		request.setAttribute("menuItemList", menuItemList);
		
		return "pages/find_all_menu_item";
		
	}
	
}
