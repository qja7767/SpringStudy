package com.varxyz.JavaCafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.JavaCafe.domain.MenuItemCommand;
import com.varxyz.JavaCafe.service.MenuItemServiceImpl;

@Controller("contorller.KioskController")
public class KioskController {
	@Autowired
	MenuItemServiceImpl menuItemService;
	
	@GetMapping("/pages2/kiosk")
	public String kioskForm(HttpServletRequest request) {
		
		List<MenuItemCommand> menuItemList = menuItemService.allFindMenu();
		request.setAttribute("menuItemList", menuItemList);

		return "pages2/kiosk";
	}
			
}
