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
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class DoChangePassword
 */
@WebServlet("/doChangePassword")
public class DoChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected UserServiceImpl userservice = BeanFactory.getInstance("userService", UserServiceImpl.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");
		String password = request.getParameter("password");
		boolean result = userservice.updatePassword(name, password);
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
