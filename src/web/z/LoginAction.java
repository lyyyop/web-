package web.z;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.z.UserService;

/**
 * 用户登录处理
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取用户提交的信息
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		String vcode = request.getParameter("code");
		HttpSession session = request.getSession();
		// 比较用户输入的校验码与session中的校验码是否一致
		String code = (String) session.getAttribute("code");
		if (vcode.equals(code)) {
			// 用户名密码正确
			if (UserService.userLogin(user, pwd)) {
				// 把登录的用户名写到session里
				session = request.getSession();
				session.setAttribute("username", user);
				// 转发
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("info", "用户名密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("info", "校验码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
