package com.techlabs.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.techlabs.dao.TransactionDbUtil;
import com.techlabs.model.Transaction;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransactionDbUtil transactionDbUtil;

	@Resource(name = "jdbc/bank_application")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		transactionDbUtil = new TransactionDbUtil(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("customer-function");
		System.out.println(command);

		if (command == null) {
			command = "customer-home";
		}

		switch (command) {

		case "Passbook": {
			viewPassbook(request, response);
			break;
		}

		case "New Transaction": {
			newTransaction(request, response);
			break;
		}

		case "Edit Profile": {
			editProfile(request, response);
			break;
		}

		default:
			customerHome(request, response);
		}
	}

	private void customerHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside customerHome doGet method");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer-home.jsp");
		requestDispatcher.forward(request, response);

	}

	private void viewPassbook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside viewPassbook doGet /user");
		HttpSession httpSession = request.getSession();
		String emailId = (String) httpSession.getAttribute("emailId");

		int currentUserAccountNumber = transactionDbUtil.getUserAccount(emailId);
		request.setAttribute("currentUserAccountNumber", currentUserAccountNumber);

		List<Transaction> transactions = transactionDbUtil.getUserTransactions(emailId);
		request.setAttribute("theTransactions", transactions);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("passbook.jsp");
		requestDispatcher.forward(request, response);

	}

	private void newTransaction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside newTransaction doGet method");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("new-transaction.jsp");
		requestDispatcher.forward(request, response);

	}

	private void editProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside editProfile doGet method");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit-profile.jsp");
		requestDispatcher.forward(request, response);
	}

}
