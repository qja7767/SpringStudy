package com.varxyz.jvx330.di.example7;

import java.util.List;

public interface MenuItemService {
	
	//메뉴 아이템 추가
	void addMenuItem(MenuItem item);

	//모든 메뉴아이템 조회
	List<MenuItem> getAllMenuItemList();
	
	//메뉴명으로 메뉴 아이템 조회
	//name 메뉴명
	MenuItem getMenuItem(String name);
	
	
	
}
