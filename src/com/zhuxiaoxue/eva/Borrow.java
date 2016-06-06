package com.zhuxiaoxue.eva;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuxiaoxue.dao.BookService;
import com.zhuxiaoxue.dao.BorrowDAO;

/**
 * Servlet implementation class Borrow
 */
@WebServlet("/Borrow")
public class Borrow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Borrow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    BorrowDAO dao = new BorrowDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", dao.findBorrow());
		request.getRequestDispatcher("/WEB-INF/views/borrow.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bs = new BookService();
		String bookCode = request.getParameter("code");
		String cardCode = request.getParameter("name");
		bs.borrowBook(bookCode, cardCode);
		response.sendRedirect("/borrow");
	}

}
