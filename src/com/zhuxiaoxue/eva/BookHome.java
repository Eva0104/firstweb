package com.zhuxiaoxue.eva;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuxiaoxue.dao.BookDAO;
import com.zhuxiaoxue.entity.Book;

@WebServlet("/BookHome")
public class BookHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BookHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	BookDAO dao = new BookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = "";
		if(request.getParameter("wd") != null){
			str = new String(request.getParameter("wd").getBytes("ISO-8859-1"),"utf-8");
		}
		List<Book> list = dao.findBook(str);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/booklist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
