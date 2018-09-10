package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;

/**
 * Servlet implementation class DoRegiste
 */
@WebServlet("/doRegiste")
public class DoRegiste extends Base {
	private static final long serialVersionUID = 1L;
       
    public Object doRegiste(HttpServletRequest request,HttpServletResponse response) {
    	String name = request.getParameter("username");
    	String password = request.getParameter("password");
    	String address = request.getParameter("address");
    	String telephone = request.getParameter("telephone");
    	Object uri = null;
    	User user = new User();
    	user.setAddress(address);
    	user.setName(name);
    	user.setPassword(password);
    	user.setTelephone(telephone);
    	if(userservice.registe(user)==true) {
    		//uri = request.getRequestDispatcher("app/detail/Login.jsp");
    		request.setAttribute("check", "true");
    		uri = request.getRequestDispatcher("/app/detail/Login.jsp");
    	}else {
    		uri = "/app/detail/Registe.jsp";
    	}
    	return uri;
    }

}
