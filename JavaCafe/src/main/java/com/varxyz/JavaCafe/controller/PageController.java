package com.varxyz.JavaCafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
			
	@GetMapping("/*/main")
	public String mainForm() {
		return "main";
	}
	
	//로그아웃
	@GetMapping("/login/logout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();		
		return "login/login";
	}
}
