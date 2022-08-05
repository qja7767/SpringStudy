package com.varxyz.JavaCafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.JavaCafe.domain.MenuItemCommand;
import com.varxyz.JavaCafe.domain.Cart;
import com.varxyz.JavaCafe.domain.MenuImage;
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
	
	//신규 장바구니 상품 추가
	public void addCart(Cart cart) {
		String sql = "INSERT INTO Cart (menuName, menuPrice, stock)"
				+ " VALUES (?, ?, ?)";
		jdbcTemplate.update(sql,
				cart.getMenuName(), cart.getMenuPrice(), cart.getStock()
				);		
	}
	
	//신규 상품 이미지 추가
	public void addMenuItemImg(MenuImage menuImg) {
		String sql = "INSERT INTO MenuImage (cateCode, imgName, imgSource, imgUrl)"
				+ " VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				menuImg.getCateCode(), menuImg.getImgName(),
				menuImg.getImgSource(), menuImg.getImgUrl());
	}
	
	//모든 메뉴 이미지 찾기
	public List<MenuImage> getAllMenuImage() {
		String sql = "SELECT imgCode, cateCode, imgName, imgSource, imgUrl"
				+ " FROM MenuImage";				
		return jdbcTemplate.query(sql, new MenuImageRowMapper());
	}
		
	//MenuImage테이블의 데이터를 MenuItem테이블의 MenuImg 컬럼으로 찾아주는 역할
	public List<MenuImage> getMenuImageByMenuItem(String menuImg) {
		String sql = "SELECT i.imgCode, i.cateCode, i.imgName, i.imgSource, i.imgUrl"
				+ "	FROM MenuImage i INNER JOIN MenuItem m ON i.cateCode = m.cateCode"
				+ "	WHERE m.menuImg=?";
		return jdbcTemplate.query(sql, new MenuImageRowMapper(), menuImg);
	}

	//모든 등록상품 조회
	public List<MenuItem> getAllMenuItem() {
		String sql = "SELECT cateCodeRef, cateCode, menuName, menuPrice, menuNum, "
				+ "menuStock, menuInfo, menuImg, regDate FROM MenuItem";
		return jdbcTemplate.query(sql, new MenuItemRowMapper());
	}
	
	public MenuItem getAllMenuItemByMenuName(String menuName) {
		String sql = "SELECT cateCodeRef, cateCode, menuName, menuPrice, menuNum, "
				+ " menuStock, menuInfo, menuImg, regDate FROM MenuItem"
				+ " WHERE menuName = ?";
		return jdbcTemplate.queryForObject(sql, new MenuItemRowMapper(),
				menuName);
	}
	
	//등록상품 + 상품이미지 조인 조회
	public List<MenuItemCommand> allFindMenu() {
		String sql = "SELECT * FROM MenuItem INNER JOIN MenuImage"
				+ " ON MenuItem.menuImg = MenuImage.imgName";
		
		return jdbcTemplate.query(sql, new RowMapper<MenuItemCommand>() {
			
			public MenuItemCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItemCommand findMenuItemCommand =
						new MenuItemCommand(rs.getString("cateCodeRef"),
						rs.getString("cateCode"), rs.getString("menuName"), 
			     		rs.getDouble("menuPrice"), rs.getString("menuInfo"), 
				    	rs.getLong("imgCode"), rs.getString("imgName"), 
     					rs.getString("imgSource"), rs.getString("imgUrl"));
				return findMenuItemCommand;
			}
		});
	}
	
	public List<Cart> allFindCart() {
		String sql = "SELECT * FROM Cart";						
		return jdbcTemplate.query(sql, new RowMapper<Cart>() {
			
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cart cart =
						new Cart(rs.getString("menuName"),						
			     		rs.getDouble("menuPrice"), rs.getInt("stock"));
				return cart;
			}
		});
	}
	
	//등록상품 + 상품이미지 메뉴이름으로 조회
	public List<MenuItemCommand> allFindMenuByMenuName(String menuName) {
		String sql = "SELECT * FROM MenuItem INNER JOIN MenuImage"
				+ " ON MenuItem.menuImg = MenuImage.imgName"
				+ " WHERE MenuItem.menuName= ?";
				
		return jdbcTemplate.query(sql, new RowMapper<MenuItemCommand>() {
			public MenuItemCommand mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				MenuItemCommand findMenuItemCommand =
						new MenuItemCommand(rs.getString("cateCodeRef"),
						rs.getString("cateCode"), rs.getString("menuName"), 
						rs.getDouble("menuPrice"), rs.getString("menuInfo"), 
						rs.getLong("imgCode"), rs.getString("imgName"), 
						rs.getString("imgSource"), rs.getString("imgUrl"));
				return findMenuItemCommand;
			}
		}, menuName);
	}
		
	//메뉴 아이템 업데이트하기
	public void updateMenuItem(MenuItemCommand menuItemCommand, String menuName) {
		String sql = "UPDATE MenuItem"
				+ " SET cateCodeRef=?, cateCode=?,"
				+ " menuName=?, menuPrice=?,"
				+ " menuInfo=?, menuImg=? WHERE menuName=?";
		jdbcTemplate.update(sql,
				menuItemCommand.getCateCodeRef(), menuItemCommand.getCateCode(),
				menuItemCommand.getMenuName(), menuItemCommand.getMenuPrice(),
				menuItemCommand.getMenuInfo(), menuItemCommand.getImgName(),
				menuName);
	}
	
	//메뉴 아이템 삭제
	public void deleteMenuItem(String menuName) {
		String sql = "DELETE FROM MenuItem WHERE menuName=?";
		jdbcTemplate.update(sql, menuName);
	}

	//카트 아이템 삭제
		public void deleteCartItem(String menuName) {
			String sql = "DELETE FROM Cart WHERE menuName=?";
			jdbcTemplate.update(sql, menuName);
		}
	
}
