package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IMessageDao;
import util.DBUtil;

public class MessageDaoImpl implements IMessageDao {
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
	public boolean addMessage(String username, int shopid, String content) {
		String sql = "insert into message(username,shopid,content) values(?,?,?)";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, shopid);
			ps.setString(3, content);
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

}
