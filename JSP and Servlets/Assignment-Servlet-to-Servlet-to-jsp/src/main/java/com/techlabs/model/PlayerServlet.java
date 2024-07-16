package com.techlabs.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlayerServlet
 */
@WebServlet("/PlayerServlet")
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		List<Player> players = (List<Player>) session.getAttribute("thePlayerList");

		List<Player> players = (List<Player>) request.getAttribute("thePlayerList");

		request.setAttribute("thePlayers", players);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-players.jsp");
		requestDispatcher.forward(request, response);
	}

}
