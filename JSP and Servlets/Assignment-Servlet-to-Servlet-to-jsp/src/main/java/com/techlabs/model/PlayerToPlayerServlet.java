package com.techlabs.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlayerToPlayerServlet")
public class PlayerToPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Player> players = PlayerDataUtil.getPlayers();

//		HttpSession session = request.getSession();
//		session.setAttribute("thePlayerList", players);
//
//		response.sendRedirect("PlayerServlet");

		request.setAttribute("thePlayerList", players);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("PlayerServlet");
		requestDispatcher.forward(request, response);
	}

}
