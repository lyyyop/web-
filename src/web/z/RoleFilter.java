package web.z;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * �û�Ȩ�޿��ƣ����¼���Է���
 */
@WebFilter(filterName="RoleFilter",urlPatterns={"/*"})
public class RoleFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		String uri=req.getRequestURI();
		if(uri.endsWith(".jpg")|
				uri.endsWith(".CSS")|
				uri.endsWith("reg.jsp")|
				uri.endsWith("login.jsp")|
				uri.endsWith("index.jsp")|
				uri.endsWith("VerCode")|
				uri.endsWith("LoginAction")|
				uri.endsWith("RegAction")){
			chain.doFilter(request, response);
		}else{
			//�ж��Ƿ��¼
			HttpSession session=req.getSession();
			String username=(String) session.getAttribute("username");
			if(username!=null) {
				chain.doFilter(request, response);
			}else {
				request.setAttribute("info", "��¼�Լ���ʹ��");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
