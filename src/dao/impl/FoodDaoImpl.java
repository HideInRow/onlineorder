package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IFoodDao;
import pojo.Food;
import pojo.Shop;
import util.DBUtil;

public class FoodDaoImpl implements IFoodDao {


	private static Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	static {
		try {
			conn = DBUtil.getInstance().getConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public List<Food> getAllFood() {
		String sql = "select * from food";
		ArrayList<Object> params = null;
		List<Food> foods = new ArrayList<>();
		try {
			foods = DBUtil.queryListExecute(sql, params, Food.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foods;
	}

	
	public Food findByName(String name) {
		String sql = "select * from food where name=?";
		Food food = new Food();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				food = (Food) rs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return food;
	}

	
	public List<Food> getFoodByKeyword(String keyword) {
		String sql = "select * from food where keyword=?";
		List<Object> params = new ArrayList<>();
		params.add((Object)keyword);
		List<Food> foods = new ArrayList<>();
		try {
			foods = DBUtil.queryListExecute(sql, params, Food.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foods;
	}
	

	public List<Food> getFoodByShopName(String name) {
		String sql = "select shopid from shop where shopname=?";
		Shop shop = new Shop();
		List<Integer> foodid = new ArrayList<>();
		List<Food> foods = new ArrayList<>();
		int id = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getInt("shopid");
			}
			sql = "select foodid from shopfood where shopid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				foodid.add(rs.getInt("foodid"));
			}
			sql = "select * from food where foodid=?";
			ps = conn.prepareStatement(sql);
			for(int i=0;i<foodid.size();i++) {
				ps.setInt(1, foodid.get(i));
				rs = ps.executeQuery();
				while(rs.next()) {
					Food food = new Food();
					food.setFoodid(rs.getInt("foodid"));
					food.setDescrip(rs.getString("descrip"));
					food.setCount(rs.getInt("count"));
					food.setName(rs.getString("name"));
					food.setKeyword(rs.getString("keyword"));
					food.setPrice(rs.getBigDecimal("price"));
					food.setPicture(rs.getString("foodpic"));
					foods.add(food);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return foods;
	}

}
