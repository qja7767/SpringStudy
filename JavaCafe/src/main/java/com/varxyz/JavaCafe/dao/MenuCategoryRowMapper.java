package com.varxyz.JavaCafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import com.varxyz.JavaCafe.domain.MenuCategory;


public class MenuCategoryRowMapper implements RowMapper<MenuCategory> {
	
	@Override
	public MenuCategory mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		
		MenuCategory menuCategory = new MenuCategory();
		menuCategory.setCateName(rs.getString("cateName"));
		menuCategory.setCateCode(rs.getString("cateCode"));
		menuCategory.setCateCodeRef(rs.getString("cateCodeRef"));
		
		return menuCategory;
	}

}
