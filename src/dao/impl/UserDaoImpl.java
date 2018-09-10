package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.IUserDao;
import pojo.Food;
import pojo.Shop;
import pojo.User;
import util.DBUtil;

public class UserDaoImpl implements IUserDao{
	
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
	
	public boolean updateUser(User user) {
		String sql = "update user set telephone=?,address=? where username=?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getTelephone());
			ps.setString(2, user.getAddress());
			ps.setString(3, user.getName());
			result = ps.executeUpdate();
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
	public boolean addUser(User user) {
		String sql = "insert into user(username,password,telephone,address) value(?,?,?,?)";
		boolean istrue = false;
		//public static boolean update(String sql,Object ...params) throws SQLException {
		try {
			istrue = DBUtil.update(sql, user.getName(),user.getPassword(),user.getTelephone(),user.getAddress());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return istrue;
	}

	@Override
	public boolean delUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean checkUser(String name, String password) {
		String sql = "select * from user where username=? and password=?";
		List<Object> params = new ArrayList<>();
		User user = null;
		params.add(name);
		params.add(password);
		try {
			user = DBUtil.findBySingleObject(sql, params, User.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//findBySingleObject(String sql,ArrayList<Object> params,Class<T> cls)
		if(user!=null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updatePassword(String name, String password) {
		String sql = "update user set password=? where username=?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, name);
			result = ps.executeUpdate();
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
	public boolean updatePicture(String name, String picture) {
		String sql = "update user set picture=? where username=?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, picture);
			ps.setString(2, name);
			result = ps.executeUpdate();
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
	public String findPicture(String name) {
		String sql = "select picture from user where username=?";
		String picture = "";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				picture = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return picture;
	}

	

	


}
