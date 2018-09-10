package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import factory.BeanFactory;
import net.sf.json.JSONObject;
import service.impl.UserServiceImpl;
import util.DBUtil;

/**
 * Servlet implementation class DoSetPicture
 */
@WebServlet("/doSetPicture")
@MultipartConfig(maxFileSize=5765004,fileSizeThreshold=1000)
public class DoSetPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected UserServiceImpl userservice = BeanFactory.getInstance("userService", UserServiceImpl.class);      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoSetPicture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Collection<Part> parts = request.getParts();
		String picture = null;
		//String rel = request.getServletContext().getRealPath("/image");
		if(parts != null) {
			Part part = request.getPart("file");
			String header = part.getHeader("Content-Disposition");
			String filename = util.SplitUtil.getFileName(header);
			//System.out.println(rel);
			String path = "F:\\eclipse-workspace\\OnlineOrder\\WebContent\\image"+File.separator+filename;
			part.write(path);
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			boolean result = userservice.updatePicture(username, path);
			if(result) {
				response.sendRedirect("app/detail/Picture.jsp");
			}
			out.close();
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
