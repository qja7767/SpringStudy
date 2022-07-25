package com.varxyz.jvx330.mvc.example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ByeController {
	
	@RequestMapping("/example1/sayBye")
	public ModelAndView sayBye() {
		String greeting = "Bye! 스프링 MVC";
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example1/bye");
		mav.addObject("greeting", greeting);
		return mav;
	}
}
