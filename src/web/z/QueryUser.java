package web.z;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 按用户名模糊查询用户
 */
@WebServlet("/QueryUser")
public class QueryUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1 获取数据
		 * 2 处理数据
		 * 3 输出
		 */
		//获取用户输入的查询的关键字
		request.setCharacterEncoding("utf-8");
		String key=request.getParameter("search");
		//获取所有用户的集合
		List<TUser> userList = UserService.queryUserByUsername(key);
		request.setAttribute("userList", userList);
		//输出转发到显示页面
		RequestDispatcher rd = request.getRequestDispatcher("userlist.jsp");
		//转发
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
