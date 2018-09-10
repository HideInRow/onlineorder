package filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/app/detail/*")
public class LoginFilter implements Filter {

	private String redirectUrl;//ֱ�ӷ���ҳ��
	private String unchekedUrls;//��ҳ������������
	
	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext context=fConfig.getServletContext();
		redirectUrl=context.getInitParameter("RedirctPage");
		unchekedUrls=context.getInitParameter("UnchekURL");
	}
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//����ת��
				HttpServletRequest req=(HttpServletRequest)request;
				HttpServletResponse res=(HttpServletResponse)response;
			   //1����ȡ�����URL��������·��
			  String requestURL= req.getRequestURL().toString();
			  String requestURI=req.getRequestURI();
			  String servletPath=req.getServletPath();
				//2������ȡ��servletpath�Ƿ���Ҫ����URL�е�һ�������ǣ���ֱ�ӷ��У���������
				List<String>urls=Arrays.asList(unchekedUrls.split(","));
				if(urls.contains(servletPath)){
				//������������ߣ�����
				 chain.doFilter(request, response);
				 return;
				}
				//3����session�л�ȡsessionkey�Ķ�Ӧ��ֵ����ֵ�����ڣ����ض���redirectURl
				Object user=req.getSession().getAttribute("username");
				//û�е�¼
				if(user==null){
					//ʹ�þ���·�����������
					res.sendRedirect(req.getContextPath()+redirectUrl);
				}
				//4�������ڣ�����У��������
				chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	

}
