package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IShopDao;
import pojo.Shop;
import util.DBUtil;

public class ShopDaoImpl implements IShopDao {

	
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
	
	@Override
	public List<Shop> getShopByAddress(String address) {
		String sql = "select * from shop where shopaddress=?";
		//String sql = "select * from shop where shopaddress=? ORDER BY shopid ASC LIMIT ?,?";
		List<Object> params = new ArrayList<>();
		params.add((Object)address);
		/*params.add((page-1)*Shop.PAGE_SIZE);
		params.add(Shop.PAGE_SIZE);*/
		List<Shop> shops = new ArrayList<>();
		try {
			shops = DBUtil.queryListExecute(sql, params, Shop.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shops;
	}

	@Override
	public Shop getShopById(int id) {
		String sql = "select * from shop where shopid=?";
		Shop shop = new Shop();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				shop.setSellid(rs.getString("sellid"));
				shop.setShopid(rs.getInt("shopid"));
				shop.setShopaddress(rs.getString("shopaddress"));
				shop.setShopname(rs.getString("shopname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return shop;
	}

	@Override
	public int findCount(String address) {
		int count = 0;
		String sql = "select count(*) from shop where shopaddress=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, address);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
