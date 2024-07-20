package com.techlabs.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.techlabs.dao.CustomerDbUtil;
import com.techlabs.dao.TransactionDbUtil;
import com.techlabs.model.Customer;

@WebServlet("/user-function")
public class UserFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerDbUtil customerDbUtil;
	private TransactionDbUtil transactionDbUtil;

	@Resource(name = "jdbc/bank_application")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		customerDbUtil = new CustomerDbUtil(dataSource);
		transactionDbUtil = new TransactionDbUtil(dataSource);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println(command);

		switch (command) {
		case "make-transaction": {
			commitTransaction(request, response);
			break;
		}

		case "submit-profile": {
			updateProfile(request, response);
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + command);
		}
	}

	private void commitTransaction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		String emailId = (String) httpSession.getAttribute("emailId");
		System.out.println(emailId);

		int receiverAccount = Integer.parseInt(request.getParameter("receiver-account-number"));
		System.out.println(receiverAccount);
		double transferAmount = Double.parseDouble(request.getParameter("transfer-amount"));
		System.out.println(transferAmount);
		transactionDbUtil.commitTransaction(emailId, receiverAccount, transferAmount);

		response.sendRedirect(request.getContextPath() + "/user");

	}

	private void updateProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		String emailId = (String) httpSession.getAttribute("emailId");
		String firstName = request.getParameter("c-fname");
		String lastName = request.getParameter("c-lname");
		String password = request.getParameter("c-password");

		Customer customer = new Customer(0, firstName, lastName, emailId, password);
		customerDbUtil.updateCustomer(customer);

		response.sendRedirect(request.getContextPath() + "/user");
	}

}
