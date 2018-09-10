package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import pojo.Food;
import pojo.Shop;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends Base {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public Object listShop(HttpServletRequest request, HttpServletResponse response) {
		String shopAddress = null;
		HttpSession session = request.getSession();
		if(request.getParameter("shopAddress")!=null) {
			shopAddress = request.getParameter("shopAddress");
			session.setAttribute("shopAddress", shopAddress);
		}else {
			shopAddress = (String) session.getAttribute("shopAddress");
		}
		
		
		/*int currPage=1;
		if(request.getParameter("page") != null) {
			currPage = Integer.parseInt(request.getParameter("page"));
		}*/
		List<Shop> shops = shopservice.foundShopByAddress(shopAddress);
		int pages;
		int count = shopservice.findCount(shopAddress);
		/*if(count % Shop.PAGE_SIZE == 0 ) {
			pages = count / Shop.PAGE_SIZE;
		}else {
			pages = count /Shop.PAGE_SIZE+1;
		}
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=pages;i++) {
			if(i == currPage) {
				sb.append("["+i+"]");
			}else {
				sb.append("<a href='./index?method=listShop&page="+i+"'>"+i+"</a>");
			}
			sb.append(" ");
		}*/
		Object uri = null;
		request.setAttribute("listShopByAddress", shops);
		//request.setAttribute("bar", sb.toString());
		uri = request.getRequestDispatcher("/app/detail/ListTest.jsp");
		return uri;
	}

}
