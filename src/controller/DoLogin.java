package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends Base {
	private static final long serialVersionUID = 1L;
       
    public Object doLogin(HttpServletRequest request, HttpServletResponse response) {
    	String name = request.getParameter("loginName");
    	String password = request.getParameter("loginPassword");
    	HttpSession session = request.getSession();
    	Object uri = null;
    	if(userservice.checkLogin(name, password) == true) {
    		session.setAttribute("username", name);
    		uri = "/app/detail/Home.jsp";
    	}else {
    		uri = "/app/detail/Login.jsp";
    	}
    	return uri;
    }
}
