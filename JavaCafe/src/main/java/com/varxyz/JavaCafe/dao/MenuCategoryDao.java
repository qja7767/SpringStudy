package com.varxyz.JavaCafe.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.JavaCafe.domain.MenuCategory;

public class MenuCategoryDao {
	private JdbcTemplate jdbcTemplate;
	
	public MenuCategoryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//신규 메뉴카테고리 추가
	public void addMenuCategory(MenuCategory menuCategory) {
		String sql = "INSERT INTO MenuCategory (cateName, cateCode, cateCodeRef)"
				+ " VALUES (?, ?, ?)";
		jdbcTemplate.update(sql,menuCategory.getCateName(),
				menuCategory.getCateCode(), menuCategory.getCateCodeRef());
	}
	
	//모든 메뉴카테고리 조회
	public List<MenuCategory> getAllMenuCategory() {
		String sql = "SELECT cateName, cateCode, cateCodeRef FROM MenuCategory";
				
		return jdbcTemplate.query(sql, new MenuCategoryRowMapper());
	}
	
	public List<MenuCategory> getMenuCategoryByCateCodeRef(String cateCodeRef) {
		String sql = "SELECT cateName, cateCode, cateCodeRef FROM MenuCategory"
				+ " WHERE cateCodeRef=?";
				
		return jdbcTemplate.query(sql, new MenuCategoryRowMapper(), cateCodeRef);
	}
	
}
