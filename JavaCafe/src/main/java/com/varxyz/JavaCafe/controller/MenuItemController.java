package com.varxyz.JavaCafe.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.varxyz.JavaCafe.domain.MenuCategory;
import com.varxyz.JavaCafe.domain.MenuImage;
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
		MenuItem menuItem, Model model, HttpServletRequest request,
		@RequestParam("imgSubmit") MultipartFile multipartFile ) throws IllegalStateException, IOException {
		
		menuItemService.addMenuItem(menuItem);
		model.addAttribute("menuItem", menuItem);
		
		//파일 처리
		String filePath =
				"E:\\JAVA\\javaWork\\JavaCafe\\src\\main\\resources\\UploadImg\\";
		String imgSource =
				multipartFile.getOriginalFilename();
		String imgSourceExtension =
				imgSource.substring(imgSource.lastIndexOf("."));		
		//UUID - 중복 방지, 고유식별자로 쓰인다고함 + 하이폰이 자동으로 들어가서 제거.
		String savedImgName =
				UUID.randomUUID().toString().replaceAll("-", "") + imgSourceExtension;
		
		MenuImage menuImg = new MenuImage();
		menuImg.setImgName(imgSourceExtension);
		menuImg.setImgSource(imgSource);
		menuImg.setImgUrl(filePath);
		menuItemService.addMenuItemImg(menuImg);
		
		File file = new File(filePath + savedImgName);
		
		multipartFile.transferTo(file);
		
		return "main";		
	}
}
