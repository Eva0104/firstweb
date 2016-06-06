package com.zhuxiaoxue.mylistener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

	public SessionListener() {
		// TODO Auto-generated constructor stub
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		ServletContext application = arg0.getSession().getServletContext();
		Object count = application.getAttribute("count");
		if (count == null) {
			application.setAttribute("count", 1);
		}else{
			application.setAttribute("count", (Integer.parseInt(count.toString())+1));
		}
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext application = arg0.getSession().getServletContext();
		Object count = application.getAttribute("count");
		application.setAttribute("count", (Integer.parseInt(count.toString())-1));
	}

}
