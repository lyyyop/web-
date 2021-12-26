package web.z;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * 回复论坛处理
 *
 */
@MultipartConfig
@WebServlet("/ReplyAction")
public class ReplyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		//获取用户提交的信息
		String content=request.getParameter("content");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		Date now=new Date();
		//3.数据输出
		response.setCharacterEncoding("utf-8");
		//注册到数据库
		UserService.reply(content, now, username);
		//获取一个转发对象		
		RequestDispatcher rd=request.getRequestDispatcher("Chat");
		//转发
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
