package com.varxyz.JavaCafe.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.JavaCafe.domain.MenuItem;

public class MenuItemDao {
	private JdbcTemplate jdbcTemplate;
	
	public MenuItemDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);		
	}
	
	//신규 상품 추가
	public void addMenuItem(MenuItem menuItem) {
		String sql = "INSERT INTO MenuItem (cateCodeRef, cateCode, menuName, menuPrice,"
				+ " menuNum, menuStock, menuInfo, menuImg)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";				
		jdbcTemplate.update(sql, 
				menuItem.getCateCodeRef(), menuItem.getCateCode(),
				menuItem.getMenuName(), menuItem.getMenuPrice(),
				menuItem.getMenuNum(), menuItem.getMenuStock(),
				menuItem.getMenuInfo(), menuItem.getMenuImg());
	}
	
	//모든 등록상품 조회
	public List<MenuItem> getAllMenuItem() {
		String sql = "SELECT cateCodeRef, cateCode, menuName, menuPrice, menuNum, "
				+ "menuStock, menuInfo, menuImg, regDate FROM MenuItem";
		return jdbcTemplate.query(sql, new MenuItemRowMapper());
	}
	
}
