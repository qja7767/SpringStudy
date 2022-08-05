package com.varxyz.JavaCafe.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.varxyz.JavaCafe.domain.MenuItemCommand;
import com.varxyz.JavaCafe.service.MenuItemServiceImpl;

import net.sf.json.JSONObject;

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
	
	@RequestMapping(value = "/test.action", method = { RequestMethod.POST })	
	public void test(@RequestParam("name") String name,
	                 @RequestParam("age") String age,
	                 @RequestParam("gender") String gender) {
	                 
	        System.out.println(name);
	        System.out.println(age);
	        System.out.println(gender);
	}
	
}
