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
 * ����˽�Ŵ���
 *
 */
@MultipartConfig
@WebServlet("/SendAction")
public class SendAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		//��ȡ�û��ύ����Ϣ
		String content=request.getParameter("content");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String user1=(String)session.getAttribute("user1");
		Date now=new Date();
		//3.�������
		response.setCharacterEncoding("utf-8");
		//ע�ᵽ���ݿ�
		UserService.send(content, now, username,user1);
		//��ȡһ��ת������		
		RequestDispatcher rd=request.getRequestDispatcher("Message");
		//ת��
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
