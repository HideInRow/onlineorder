package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
 * Servlet implementation class DoOrder
 */
@WebServlet("/doOrder")
public class DoOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected UserServiceImpl userservice = BeanFactory.getInstance("userService", UserServiceImpl.class);    
	protected static Map<String, String> order = new HashMap<>();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public DoOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("foodid");
		String count = request.getParameter("count");
		HttpSession session = request.getSession();
		@SuppressWarnings("unused")
		String username = (String) session.getAttribute("username");
		boolean isFirst =  (boolean) session.getAttribute("isFirst");
		if(isFirst) {
			order.clear();
		}
		session.setAttribute("isFirst", false);
		
		order.put("foodid"+id, id+"-"+count);
		Set<String> keys = order.keySet();
		JSONObject json = new JSONObject();
		json.put("order", order);
		json.put("key", keys);
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
