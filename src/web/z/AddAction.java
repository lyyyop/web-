package web.z;

import java.io.IOException;

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
 * 添加人物卡
 *
 */
@MultipartConfig
@WebServlet("/AddAction")
public class AddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		//获取用户提交的信息
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String major=request.getParameter("major");
		String sum=request.getParameter("sum");
		String age=request.getParameter("age");
		String exp=request.getParameter("exp");
		String now=request.getParameter("now");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		//3.数据输出
		//注册到数据库
		UserService.addPc(name, sex, age, major, sum, exp, now, username);
		//获取一个转发对象	
		request.setAttribute("info", "添加成功");
		RequestDispatcher rd=request.getRequestDispatcher("/AllPc");
		//转发
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
