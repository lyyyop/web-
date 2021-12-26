package web.z;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 修改密码
 */
@WebServlet("/UpdatePwd")
public class UpdatePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取信息
		String username = request.getParameter("username");
		String oldpwd = request.getParameter("oldPwd");
		String newpwd = request.getParameter("newPwd");
		String vcode = request.getParameter("code");
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		if (vcode.equals(code)) {
			if (UserService.updatePassword(username, newpwd, oldpwd)==0){
				request.setAttribute("info", "原密码错误");
				request.getRequestDispatcher("updatepwd.jsp").forward(request, response);
			}else{
				session.invalidate();
				request.setAttribute("info", "修改成功，请重新登录");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("info", "校验码错误");
			request.getRequestDispatcher("updatepwd.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
