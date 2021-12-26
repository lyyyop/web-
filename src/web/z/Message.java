package web.z;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 输出当前用户私信列表
 */
@WebServlet("/Message")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String user2=(String)session.getAttribute("username");
		String user1=request.getParameter("user1");
		if(user1==null)
			user1=(String)session.getAttribute("user1");
		else
			session.setAttribute("user1", user1);
		List<TMessage> messageList = UserService.getMessage(user2, user1);
		request.setAttribute("messageList", messageList);
		//输出转发到显示页面
		RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
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
