package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Food;
import pojo.Shop;

/**
 * Servlet implementation class DoSelectShop
 */
@WebServlet("/doSelectShop")
public class DoSelectShop extends Base {
	private static final long serialVersionUID = 1L;
       
    public Object doSelectShop(HttpServletRequest request,HttpServletResponse response) {
    	String name = request.getParameter("shopname");
    	Object uri = null;
    	List<Food> foods = foodservice.getFoodByShopName(name);
    	if(foods!=null) {
    		request.setAttribute("food", foods);
    		uri = request.getRequestDispatcher("/app/detail/Shop.jsp");
    	}else {
    		uri = "/error/error.jsp";
    	}
    	return uri;
    }
}
