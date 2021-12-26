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
 * ������￨
 *
 */
@MultipartConfig
@WebServlet("/AddAction")
public class AddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		//��ȡ�û��ύ����Ϣ
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String major=request.getParameter("major");
		String sum=request.getParameter("sum");
		String age=request.getParameter("age");
		String exp=request.getParameter("exp");
		String now=request.getParameter("now");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		//3.�������
		//ע�ᵽ���ݿ�
		UserService.addPc(name, sex, age, major, sum, exp, now, username);
		//��ȡһ��ת������	
		request.setAttribute("info", "��ӳɹ�");
		RequestDispatcher rd=request.getRequestDispatcher("/AllPc");
		//ת��
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
