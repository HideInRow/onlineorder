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
import service.impl.MessageServiceImpl;
import service.impl.ShopServiceImpl;

/**
 * Servlet implementation class DoSendMessage
 */
@WebServlet("/doSendMessage")
public class DoSendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	protected MessageServiceImpl messageservice = BeanFactory.getInstance("messageService", MessageServiceImpl.class);       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoSendMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");
		String message = (String) request.getParameter("info");
		int shopid = Integer.parseInt(request.getParameter("shopid"));
		boolean result = messageservice.addMessage(name, shopid, message);
		PrintWriter out = response.getWriter();
		if(result) {
			JSONObject json = new JSONObject();
			json.put("message",	shopid+message);
			out.println(json);
		}else {
			response.sendRedirect("error/error");
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
