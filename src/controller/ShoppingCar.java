package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.BeanFactory;
import service.impl.OrderServiceImpl;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShoppingCar
 */
@WebServlet("/shoppingCar")
public class ShoppingCar extends Base {
	private static final long serialVersionUID = 1L;
	
	
	public Object shoppingCar(HttpServletRequest request,HttpServletResponse response) {
		String orderinfo = request.getParameter("orderinfo");
		orderinfo = orderinfo.replace(" ", "");
		String[] orders = orderinfo.split("foodid");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Object uri = null;
		double allMoney = 0;
		for (String str : orders) {
			//System.out.println(str+"---"+str.indexOf("-")+"--"+str.length());
			if(str.length()!=0) {
				String foodid = str.substring(0, str.indexOf("-"));
				String count = str.substring(str.indexOf("-")+1);
				boolean result = orderservice.addOrder(Integer.parseInt(foodid), username, Integer.parseInt(count));
				allMoney += orderservice.getMoney(Integer.parseInt(foodid), Integer.parseInt(count));
				if(result) {
					session.setAttribute("money", allMoney);
					session.setAttribute("orderinfo", orderinfo);
					uri = "/app/detail/Success.jsp";
				}else {
					uri = "/error/Fail.jsp";
				}
			}
		}
		return uri;
	}

}
