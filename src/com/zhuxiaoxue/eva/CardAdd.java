package com.zhuxiaoxue.eva;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhuxiaoxue.dao.CardDAO;
import com.zhuxiaoxue.entity.Card;

/**
 * Servlet implementation class CardAdd
 */
@WebServlet("/CardAdd")
public class CardAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/cardaddlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	CardDAO dao = new CardDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Card card = new Card();
		card.setCode(request.getParameter("code"));
		card.setName(request.getParameter("name"));
		card.setTel(request.getParameter("tel"));
		
		dao.addCard(card);
		response.sendRedirect("/cardhome");
	}

}
