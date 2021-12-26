package web.z;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���û�״̬�ĳ�pl
 */
@WebServlet("/InvalidUser")
public class InvalidUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 1 ��ȡ����
	 * 2 ��������
	 * 3 ���
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1��ȡ����
		String id = request.getParameter("id");
		
		//���û���״̬����Ϊ0
		UserService.invalidUser(Integer.parseInt(id));
		
		//���ת������ʾҳ��
		RequestDispatcher rd = request.getRequestDispatcher("MyInfo");
		//ת��
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
