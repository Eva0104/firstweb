package com.zhuxiaoxue.eva;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuxiaoxue.dao.AdminDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	AdminDAO dao = new AdminDAO();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		String rememberme = request.getParameter("rememberme");
		if (dao.find(name, pwd)) {
			if ("yes".equals(rememberme)) {
				Cookie ck1 = new Cookie("username", name);
				Cookie ck2 = new Cookie("password", pwd);

				ck1.setHttpOnly(true);
				ck1.setMaxAge(60 * 60 * 24 * 7);
				ck1.setPath("/");

				ck2.setHttpOnly(true);
				ck2.setMaxAge(60 * 60 * 24 * 7);
				ck2.setPath("/");
				response.addCookie(ck1);
				response.addCookie(ck2);
			}
			request.getSession().setAttribute("userName", name);
			response.sendRedirect("/home");
		} else {
			response.sendRedirect("/index?err=1001");
		}

	}
}
