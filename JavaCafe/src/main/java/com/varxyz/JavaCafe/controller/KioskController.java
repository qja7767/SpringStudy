package com.varxyz.JavaCafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.JavaCafe.domain.Cart;
import com.varxyz.JavaCafe.domain.MenuItem;
import com.varxyz.JavaCafe.domain.MenuItemCommand;
import com.varxyz.JavaCafe.service.MenuItemServiceImpl;



@Controller("controller.KioskController")
public class KioskController {
	@Autowired
	MenuItemServiceImpl menuItemService;
	
	@GetMapping("/pages2/kiosk")
	public String kioskForm(HttpServletRequest request) {
		List<Cart> cartItemList = menuItemService.allFindCart();
		request.setAttribute("cartItemList", cartItemList);
		List<MenuItemCommand> menuItemList = menuItemService.allFindMenu();
		request.setAttribute("menuItemList", menuItemList);

		return "pages2/kiosk";
	}
	
	@GetMapping("/pages2/add_cart_menu_item")
	public String addCartMenuItem(@RequestParam("menuName1") String menuName,
			HttpServletRequest request) {
		MenuItem menuItem = menuItemService.getAllMenuItemByMenuName(menuName);
		Double menuPrice = menuItem.getMenuPrice();
		Cart cart = new Cart();
		cart.setMenuName(menuName);
		cart.setMenuPrice(menuPrice);
		cart.setStock(1);				
		menuItemService.addCart(cart);
		
		List<Cart> cartItemList = menuItemService.allFindCart();
		request.setAttribute("cartItemList", cartItemList);
		List<MenuItemCommand> menuItemList = menuItemService.allFindMenu();
		request.setAttribute("menuItemList", menuItemList);
		
		return "pages2/kiosk";
	}
	
	@GetMapping("/pages2/delete_cart_item")
	public String deleteMenuItem(@RequestParam("menuName1") String menuName,
			HttpServletRequest request) {
		menuItemService.deleteCartItem(menuName);
		
		List<Cart> cartItemList = menuItemService.allFindCart();
		request.setAttribute("cartItemList", cartItemList);
		
		List<MenuItemCommand> menuItemList = menuItemService.allFindMenu();
		request.setAttribute("menuItemList", menuItemList);	
		
		for (Cart CartItemList : cartItemList) {
			
		}
		
		return "pages2/kiosk";
	}
}
