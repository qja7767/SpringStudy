package com.varxyz.banking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.service.CustomerServiceImpl;

@Controller
public class LoginController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@GetMapping("/login/login")
	public String loginForm() {
		return "login/login";
	}
	
	@PostMapping("/login/login")
	public String login( HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		if(!customerService.isValidUser(userId, passwd)) {
			request.setAttribute("msg", "아이디 혹은 비밀번호가 틀렸습니다.");
			request.setAttribute("url", "login_add/login");
			return "error";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		
		return "main";
	}
}
