package web.z;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 显示个人信息
 */
@WebServlet("/MyInfo")
public class MyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1获取当前的用户名
		 * 2根据用户名 获取用户的信息
		 * 3显示用户信息
		 */
		//1获取当前用户名
		//获取session,从session中获取用户名
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		//2根据用户名 获取用户的信息
		TUser user=UserService.getUserInfo(username);
		//3显示用户信息----转发
		request.setAttribute("user", user);
		request.getRequestDispatcher("myInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
