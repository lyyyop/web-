package web.z;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.z.UserService;

/**
 * �û���¼����
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ȡ�û��ύ����Ϣ
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		String vcode = request.getParameter("code");
		HttpSession session = request.getSession();
		// �Ƚ��û������У������session�е�У�����Ƿ�һ��
		String code = (String) session.getAttribute("code");
		if (vcode.equals(code)) {
			// �û���������ȷ
			if (UserService.userLogin(user, pwd)) {
				// �ѵ�¼���û���д��session��
				session = request.getSession();
				session.setAttribute("username", user);
				// ת��
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("info", "�û����������");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("info", "У�������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
