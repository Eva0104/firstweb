package com.zhuxiaoxue.mylistener;

import javax.print.attribute.standard.Severity;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	ServletContext  application = arg0.getServletContext();
    	String url = application.getInitParameter("url");
    	String user = application.getInitParameter("user");
    	String pwd = application.getInitParameter("pwd");
    	com.zhuxiaoxue.dao.Confg.URL = url + "?user=" + user + "&password=" + pwd;
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
