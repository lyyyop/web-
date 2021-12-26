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
 * ���û���ģ����ѯ�û�
 */
@WebServlet("/QueryUser")
public class QueryUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1 ��ȡ����
		 * 2 ��������
		 * 3 ���
		 */
		//��ȡ�û�����Ĳ�ѯ�Ĺؼ���
		request.setCharacterEncoding("utf-8");
		String key=request.getParameter("search");
		//��ȡ�����û��ļ���
		List<TUser> userList = UserService.queryUserByUsername(key);
		request.setAttribute("userList", userList);
		//���ת������ʾҳ��
		RequestDispatcher rd = request.getRequestDispatcher("userlist.jsp");
		//ת��
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
