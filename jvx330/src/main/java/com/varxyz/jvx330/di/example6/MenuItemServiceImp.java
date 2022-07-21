package com.varxyz.jvx330.di.example6;

import java.util.ArrayList;
import java.util.List;

public class MenuItemServiceImp implements MenuItemService {
	List<MenuItem> menuList = new ArrayList();
	
	
	@Override
	public void addItem(String Name, String Price) {
		System.out.println(Name + "," + Price);
		
	}
	
	public List<MenuItem> findAllItem() {
		return null;
	}
	
	public List<MenuItem> findItemByName() {
		return null;
	}
	
	
}
