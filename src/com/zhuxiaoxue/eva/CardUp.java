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
 * Servlet implementation class CardUp
 */
@WebServlet("/CardUp")
public class CardUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    CardDAO dao = new CardDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = new Integer(strId);
		request.setAttribute("card", dao.findCard(id));
		request.getRequestDispatcher("/WEB-INF/views/carduplist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Card card = new Card();
		String strId = request.getParameter("id");
		int id = new Integer(strId);
		card.setId(id);
		card.setCode(request.getParameter("code"));
		card.setName(request.getParameter("name"));
		card.setTel(request.getParameter("tel"));
		
		dao.upCard(card);
		response.sendRedirect("/cardhome");
		
	}

}
