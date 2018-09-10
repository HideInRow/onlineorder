package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

/**
 * Servlet implementation class DoValidate
 */
@WebServlet("/doValidata")
public class DoValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = DBUtil.getInstance().getConn();
			String sql = "select * from user where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, request.getParameter("name"));
			PrintWriter out = response.getWriter();
			ResultSet rs = ps.executeQuery();
			String result=null;
			if(rs.next()) {
				result="<font color='red'>该用户名已被注册，请重新注册</font>";
			}else {
				if(request.getParameter("name").equals("")) {
					result="<font color='red'>用户名不能为空</font>";
					
				}else {
					result="<font color='green'>该用户名可用</font>";
				}
				
			}
			out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
