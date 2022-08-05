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
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.JavaCafe.domain.MenuItemCommand;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.varxyz.JavaCafe.domain.MenuImage;
import com.varxyz.JavaCafe.domain.MenuItem;
import com.varxyz.JavaCafe.service.MenuItemServiceImpl;

@Controller("controller.menuItemFindController")
public class MenuItemFindController {
	@Autowired
	MenuItemServiceImpl menuItemService;	
	
	@GetMapping("/pages/find_all_menu_item")
	public String findAllMenuItemForm(HttpServletRequest request) {
		
		return "pages/find_all_menu_item";
	}
	
	@PostMapping("/pages/find_all_menu_item")
	public String findAllMenuItem(HttpServletRequest request, Model model) {
		
		List<MenuItemCommand> menuItemList = menuItemService.allFindMenu();
		request.setAttribute("menuItemList", menuItemList);

		return "pages/find_all_menu_item";
	}
	
	@GetMapping("/pages/update_menu_item")
	public String updateMenuItemForm(String menuName,
			HttpServletRequest request) {
		
		List<MenuItemCommand> wantItemList =
				menuItemService.getMenuItemByMenuName(menuName);
		request.setAttribute("wantItemList", wantItemList);
		return "pages/update_menu_item";
	}
	
//	@PostMapping("/pages/update_menu_item")
//	public String updateMenuItemDo(Model model, 
//			@ModelAttribute("menuItem") MenuItemCommand menuItemCommand,
//			HttpServletRequest request, String menuName) {
//		
//		model.addAttribute("menuItemCommand", menuItemCommand);				
//		menuItemService.updateMenuItem(menuItemCommand, menuName);
//		
//		return "main";
//	}
	
	@GetMapping("/pages/delete_menu_item")
	public String deleteMenuItem(@RequestParam("menuName1") String menuName) {
		
		menuItemService.deleteMenuItem(menuName);
		return "main";
	}
	
	
	
}

