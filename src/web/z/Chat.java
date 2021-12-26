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
 * 显示聊天论坛
 */
@WebServlet("/Chat")
public class Chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pageSize=5;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo;
		String x=(String)request.getParameter("pageNo");
		if(x == null)
			pageNo=1;
		else
			pageNo = Integer.parseInt(x);
		List<TChat> chatList = UserService.getChat(pageNo, pageSize);
		request.setAttribute("chatList", chatList);
		//输出转发到显示页面
		RequestDispatcher rd = request.getRequestDispatcher("chat.jsp");
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
