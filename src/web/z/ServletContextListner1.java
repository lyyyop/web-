package web.z;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 
 * 监听器
 *
 */
@WebListener
public class ServletContextListner1 implements ServletContextListener {
	//当WEB应用程序停止的时候触发
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
        System.out.println("WEB应用"+arg0.getServletContext().getContextPath()+"停止！！！！");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
    	//获取当前的Servlet上下文环境
    	ServletContext sc=arg0.getServletContext();
    	sc.setAttribute("title", "190110910232 张扬扬 19计算机2班");
    	System.out.println("WEB应用"+arg0.getServletContext().getContextPath()+"启动！！！！");
    }
	
}
