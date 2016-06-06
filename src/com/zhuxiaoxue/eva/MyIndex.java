package com.zhuxiaoxue.eva;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuxiaoxue.dao.AdminDAO;

@WebServlet("/MyIndex")
public class MyIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyIndex() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookie = request.getCookies();
		String name = null;
		String pwd = null;
		
		if(cookie != null){
			for(Cookie coo:cookie){
				if("username".equals(coo.getName())){
					name = coo.getValue();
				}else if("password".equals(coo.getName())){
					pwd=coo.getValue();
				}
			}
		}
		if("name" != null && "pwd" != null){
			AdminDAO dao = new AdminDAO();
			if(dao.find(name, pwd)){
				response.sendRedirect("/home");
			}else{
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
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
