package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import pojo.Food;
import pojo.User;
import service.IUserService;
import service.impl.UserServiceImpl;

class test {

	@org.junit.Test
	void test() {
		DBUtil db = DBUtil.getInstance();
		try {
			Connection conn = db.getConn();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
