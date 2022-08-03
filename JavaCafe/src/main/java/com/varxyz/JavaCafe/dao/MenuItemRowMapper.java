package com.varxyz.JavaCafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.JavaCafe.domain.MenuCategory;
import com.varxyz.JavaCafe.domain.MenuItem;

public class MenuItemRowMapper implements RowMapper<MenuItem> {

	@Override
	public MenuItem mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		
		MenuItem menuItem = new MenuItem();
		menuItem.setCateCodeRef(rs.getString("cateCodeRef"));
		menuItem.setCateCode(rs.getString("cateCode"));
		menuItem.setMenuName(rs.getString("menuName"));
		menuItem.setMenuPrice(rs.getDouble("menuPrice"));
		menuItem.setMenuNum(rs.getInt("menuNum"));
		menuItem.setMenuStock(rs.getInt("menuStock"));
		menuItem.setMenuInfo(rs.getString("menuInfo"));
		menuItem.setMenuImg(rs.getString("menuImg"));
		menuItem.setRegDate(rs.getDate("regDate"));
		return menuItem;
	}
}
