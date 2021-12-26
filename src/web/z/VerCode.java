package web.z;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * У����
 */
@WebServlet("/VerCode")
public class VerCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//֪ͨ�������Ҫ����
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		//�����ĵ�����
		response.setContentType("image/jpeg");
		
		//����һ���ڴ�ͼƬ
		BufferedImage image=new BufferedImage(120,38,BufferedImage.TYPE_INT_RGB);
		//����
		Graphics g=image.getGraphics();
		
		Random r =new Random();
		
		g.setColor(Color.white);
		
		for(int i=0;i<10;i++){
			g.drawLine(r.nextInt(5), r.nextInt(25),r.nextInt(120), r.nextInt(38));
		}
		
		g.setColor(Color.white);
		
		g.setFont(new Font("΢���ź�",Font.BOLD|Font.ITALIC,25));
		
		String code=String.valueOf(r.nextInt(8999)+1000);
		HttpSession session=request.getSession();
		session.setAttribute("code", code);
		g.drawString(code, 30, 30);
		
		OutputStream ops=response.getOutputStream();
		
		ImageIO.write(image,"jpg",ops);
		
		ops.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}