package com.techlabs.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.techlabs.dao.CustomerDbUtil;
import com.techlabs.model.Customer;

@WebServlet("/admin-function")
public class AdminFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDbUtil customerDbUtil;

	@Resource(name = "jdbc/bank_application")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		customerDbUtil = new CustomerDbUtil(dataSource);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println(command);

		switch (command) {
		case "add-new-customer": {
			addNewCustomer(request, response);
			break;
		}

		case "search-customer": {
			searchCustomer(request, response);
			break;
		}

		case "add-bank-account": {
			addBankAccount(request, response);
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + command);
		}
	}

	private void addNewCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("customer-fname");
		String lastName = request.getParameter("customer-lname");
		String emailId = request.getParameter("customer-email");
		String password = request.getParameter("customer-password");

		Customer customer = new Customer(0, firstName, lastName, emailId, password);
		customerDbUtil.addNewCustomer(customer);

		response.sendRedirect(request.getContextPath() + "/admin");

	}

	private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void addBankAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
