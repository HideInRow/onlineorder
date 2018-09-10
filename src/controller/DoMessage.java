package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.BeanFactory;
import net.sf.json.JSONObject;
import pojo.Shop;
import service.impl.FoodServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.ShopServiceImpl;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class DoMessage
 */
@WebServlet("/doMessage")
public class DoMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected UserServiceImpl userservice = BeanFactory.getInstance("userService", UserServiceImpl.class); 
    protected FoodServiceImpl foodservice = BeanFactory.getInstance("foodService", FoodServiceImpl.class); 
    protected OrderServiceImpl orderservice = BeanFactory.getInstance("orderService", OrderServiceImpl.class); 
    protected ShopServiceImpl shopservice = BeanFactory.getInstance("shopService", ShopServiceImpl.class);    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		List<Integer> shopids = orderservice.getShopid(username);
		List<Shop> shops = new ArrayList<>();
		for (Integer integer : shopids) {
			Shop shop = shopservice.getShopById(integer);
			shops.add(shop);
		}
		JSONObject json = new JSONObject();
		json.put("shop", shops);
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
