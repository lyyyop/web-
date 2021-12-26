package web.z;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 将用户状态改成pl
 */
@WebServlet("/InvalidUser")
public class InvalidUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 1 获取数据
	 * 2 处理数据
	 * 3 输出
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1获取数据
		String id = request.getParameter("id");
		
		//将用户的状态更新为0
		UserService.invalidUser(Integer.parseInt(id));
		
		//输出转发到显示页面
		RequestDispatcher rd = request.getRequestDispatcher("MyInfo");
		//转发
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
