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
 * Servlet implementation class BookUp
 */
@WebServlet("/BookUp")
public class BookUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    BookDAO dao = new BookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = new Integer(strId);
		request.setAttribute("book", dao.findBookById(id));
		request.getRequestDispatcher("/WEB-INF/views/bookuplist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String strId = request.getParameter("id");
		int id = new Integer(strId);
		Book book = new Book();
		book.setId(id);
		book.setCode(request.getParameter("code"));
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		book.setPublishing(request.getParameter("pb"));
		book.setTotal(Integer.parseInt(request.getParameter("total")));
		book.setCount(Integer.parseInt(request.getParameter("count")));
		
		dao.update(book);
		response.sendRedirect("/bookhome");
	}

}
