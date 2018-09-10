package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.BeanFactory;
import service.impl.FoodServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.ShopServiceImpl;
import service.impl.UserServiceImpl;
import util.ServletUtil;

/**
 * Servlet implementation class Base
 */
public class Base extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected UserServiceImpl userservice = BeanFactory.getInstance("userService", UserServiceImpl.class); 
    protected FoodServiceImpl foodservice = BeanFactory.getInstance("foodService", FoodServiceImpl.class); 
    protected OrderServiceImpl orderservice = BeanFactory.getInstance("orderService", OrderServiceImpl.class); 
    protected ShopServiceImpl shopservice = BeanFactory.getInstance("shopService", ShopServiceImpl.class); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Base() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		Object result = null;
		try {
			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			result = method.invoke(this, request,response);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("error/error.jsp");
			e.printStackTrace();
		}
		ServletUtil.send(request, response, result);
		//response.sendRedirect("app/detail/Login.jsp");
		//request.getRequestDispatcher("app/detail/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
