package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IOrderDao;
import util.DBUtil;

public class OrderDaoImpl implements IOrderDao {

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
	public boolean insertOrder(int foodid, String username,int count) {
		String sql = "select shopid from shopfood where foodid=?";
		int shopid = 0;
		int result = 0;
		int total = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, foodid);
			rs = ps.executeQuery();
			if(rs.next()) {
				shopid = rs.getInt("shopid");
			}
			sql = "update `order` set status='已提交' where status='提交'";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			//insert into `order`(shopid,STATUS,username) value(2,'提交','4564')
			sql = "insert into `order`(shopid,STATUS,username) value(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, shopid);
			ps.setString(2, "提交");
			ps.setString(3, username);
			int r = ps.executeUpdate();
			if(r>0) {
				
				sql = "select orderid from `order` where username=? and status='提交'";
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				rs = ps.executeQuery(); 
				if(rs.next()) {
					int orderid = rs.getInt("orderid");
					sql = "insert into f_order (orderid,foodid,count) values(?,?,?)";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, orderid);
					ps.setInt(2, foodid);
					ps.setInt(3, count);
					result = ps.executeUpdate();
					sql = "select count from food where foodid=?";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, foodid);
					rs = ps.executeQuery();
					if(rs.next()) {
						total = rs.getInt("count");
						if(total-count<0) {
							return false;
						}
					}
					sql = "update food set count=? where foodid=?";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, total-count);
					ps.setInt(2, foodid);
					ps.executeUpdate();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result>0) {
			return true;
		}else {
			return false;
		}
		
	}


	@Override
	public double getMoney(int foodid, int count) {
		String sql = "select price from food where foodid=?";
		double money = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, foodid);
			rs = ps.executeQuery();
			if(rs.next()) {
				double price = rs.getDouble("price");
				money = price * count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return money;
	}


	@Override
	public List<Integer> getShopId(String name) {
		String sql = "select DISTINCT shopid from `order` where username=?";
		List<Integer> shopids = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				shopids.add(rs.getInt("shopid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return shopids;
	}

}
