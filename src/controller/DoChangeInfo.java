package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.BeanFactory;
import net.sf.json.JSONObject;
import pojo.User;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class DoChangeInfo
 */
@WebServlet("/doChangeInfo")
public class DoChangeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected UserServiceImpl userservice = BeanFactory.getInstance("userService", UserServiceImpl.class);    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoChangeInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		User user = new User();
		user.setAddress(address);
		user.setTelephone(telephone);
		user.setName(username);
		boolean result = userservice.updateInfo(user);
		JSONObject json = new JSONObject();
		json.put("result", result);
		PrintWriter out = response.getWriter();
		out.println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
