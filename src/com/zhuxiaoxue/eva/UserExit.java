package com.zhuxiaoxue.eva;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserExit
 */
@WebServlet("/UserExit")
public class UserExit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserExit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		Cookie ck1 = new Cookie("username", "");
		Cookie ck2 = new Cookie("password", "");

		ck1.setHttpOnly(true);
		ck1.setMaxAge(0);
		ck1.setPath("/");

		ck2.setHttpOnly(true);
		ck2.setMaxAge(0);
		ck2.setPath("/");
		response.addCookie(ck1);
		response.addCookie(ck2);
		response.sendRedirect("/index");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
