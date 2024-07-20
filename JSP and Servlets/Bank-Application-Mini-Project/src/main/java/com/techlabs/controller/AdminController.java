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
import javax.sql.DataSource;

import com.techlabs.dao.CustomerDbUtil;
import com.techlabs.dao.TransactionDbUtil;
import com.techlabs.model.CustomerAccount;
import com.techlabs.model.Transaction;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("admin-function");
		System.out.println(command);

		if (command == null) {
			command = "admin-home";
		}

		switch (command) {

		case "Add New Customer": {
			addNewCustomer(request, response);
			break;
		}

		case "Add Bank Account": {
			addBankAccount(request, response);
			break;
		}

		case "View Customers": {
			viewCustomers(request, response);
			break;
		}

		case "View Transactions": {
			viewTransactions(request, response);
			break;
		}

		default:
			adminHome(request, response);
		}

	}

	private void adminHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside adminHome doGet method");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin-home.jsp");
		requestDispatcher.forward(request, response);

	}

	private void addNewCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside addNewCustomer doGet method");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-new-customer.jsp");
		requestDispatcher.forward(request, response);
	}

	private void addBankAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside addBankAccount doGet method");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-bank-account.jsp");
		requestDispatcher.forward(request, response);
	}

	private void viewCustomers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside viewCustomers doGet method");
		List<CustomerAccount> customerAccounts = customerDbUtil.getCustomerDetails();
		request.setAttribute("theCustomerAccounts", customerAccounts);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-customers.jsp");
		requestDispatcher.forward(request, response);
	}

	private void viewTransactions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside viewTransactions doGet method");
		List<Transaction> transactions = transactionDbUtil.getAllTransactions();
		request.setAttribute("theTransactions", transactions);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-transactions.jsp");
		requestDispatcher.forward(request, response);
	}
}
