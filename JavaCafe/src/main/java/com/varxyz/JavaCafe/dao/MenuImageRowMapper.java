package com.varxyz.JavaCafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.JavaCafe.domain.MenuCategory;
import com.varxyz.JavaCafe.domain.MenuImage;
import com.varxyz.JavaCafe.domain.MenuItem;

public class MenuImageRowMapper implements RowMapper<MenuImage> {

	@Override
	public MenuImage mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		
		MenuImage menuImage = new MenuImage();
		menuImage.setImgCode(rs.getLong("imgCode"));
		menuImage.setCateCode(rs.getString("cateCode"));
		menuImage.setImgName(rs.getString("imgName"));
		menuImage.setImgSource(rs.getString("imgSource"));
		menuImage.setImgUrl(rs.getString("imgUrl"));
		return menuImage;
	}
}
