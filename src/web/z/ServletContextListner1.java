package web.z;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 
 * ������
 *
 */
@WebListener
public class ServletContextListner1 implements ServletContextListener {
	//��WEBӦ�ó���ֹͣ��ʱ�򴥷�
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
        System.out.println("WEBӦ��"+arg0.getServletContext().getContextPath()+"ֹͣ��������");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
    	//��ȡ��ǰ��Servlet�����Ļ���
    	ServletContext sc=arg0.getServletContext();
    	sc.setAttribute("title", "190110910232 ������ 19�����2��");
    	System.out.println("WEBӦ��"+arg0.getServletContext().getContextPath()+"������������");
    }
	
}
