package web.z;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 用户注册处理
 *
 */
@MultipartConfig
@WebServlet("/RegAction")
public class RegAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		//获取用户提交的信息
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String sign=request.getParameter("sign");
		String age=request.getParameter("age");
		//2.业务处理，数据处理
		//注册时间
		Date now=new Date();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String regTime =sdf1.format(now);
		String ip = request.getRemoteAddr();
		//3.数据输出
		response.setCharacterEncoding("utf-8");
		//在请求中添加一个key,value
		request.setAttribute("username", username);
		request.setAttribute("sex", sex);
		request.setAttribute("regTime", regTime);
		request.setAttribute("ip", ip);
		request.setAttribute("sign", sign);
		request.setAttribute("age", age);
		//注册到数据库
		UserService.addUser(username, password, sex,ip,now,sign,age);
		//获取一个转发对象		
		RequestDispatcher rd=request.getRequestDispatcher("reg_out.jsp");
		//转发
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
