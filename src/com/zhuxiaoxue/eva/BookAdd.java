package com.zhuxiaoxue.eva;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuxiaoxue.dao.BookDAO;
import com.zhuxiaoxue.entity.Book;

/**
 * Servlet implementation class BookAdd
 */
@WebServlet("/BookAdd")
public class BookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/bookaddlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	BookDAO dao = new BookDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Book book = new Book();
		book.setCode(request.getParameter("code"));
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		book.setPublishing(request.getParameter("pb"));
		book.setTotal(Integer.parseInt(request.getParameter("total")));
		book.setCount(Integer.parseInt(request.getParameter("total")));
		
		dao.add(book);
		response.sendRedirect("/bookhome");
	}

}
