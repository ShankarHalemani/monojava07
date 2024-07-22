package com.techlabs.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.techlabs.model.Customer;
import com.techlabs.model.Transaction;

@WebServlet("/admin-function")
public class AdminFunctions extends HttpServlet {
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
		case "add-new-customer": {
			addNewCustomer(request, response);
			break;
		}

		case "search-customer": {
			searchCustomer(request, response);
			break;
		}

		case "add-bank-account": {
			createBankAccount(request, response);
			break;
		}

		case "search-transaction": {
			searchTransactions(request, response);
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

		if (customerDbUtil.chechCustomerExists(emailId)) {
			request.setAttribute("message", "Customer Already exists");

		} else {
			Customer customer = new Customer(0, firstName, lastName, emailId, password);
			customerDbUtil.addNewCustomer(customer);
			request.setAttribute("message", "Customer added successfully.");
		}

		request.getRequestDispatcher("/add-new-customer.jsp").forward(request, response);
	}

	private void searchCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customer-id"));
		List<Customer> customer = customerDbUtil.getCustomer(customerId);
		if (customer == null) {
			customer = new ArrayList<Customer>();
		}
		request.setAttribute("theCustomer", customer);
		if (!response.isCommitted()) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-bank-account.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	private void createBankAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerIdStr = request.getParameter("customerId");
		System.out.println(customerIdStr);
		if (customerIdStr != null && !customerIdStr.isEmpty()) {
			int customerId = Integer.parseInt(customerIdStr);
			if (customerDbUtil.checkCutomerAccountExists(customerId)) {
				request.setAttribute("message", "Account already exists");
			} else {
				customerDbUtil.createCustomerAccount(customerId);
				request.setAttribute("message", "Account created successfully");
			}
		}

		request.getRequestDispatcher("/add-bank-account.jsp").forward(request, response);

	}

	private void searchTransactions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date startDate = null;
		Date endDate = null;
		int accountNumber = 0;

		List<Transaction> transactions;

		String startDatestr = request.getParameter("start-date");
		String endDateStr = request.getParameter("end-date");

		String accountNumberStr = request.getParameter("account-number");
		if (accountNumberStr != null && !accountNumberStr.isEmpty()) {
			accountNumber = Integer.parseInt(accountNumberStr);
		}

		if ((startDatestr.isEmpty() || startDatestr == null || endDateStr.isEmpty() || endDateStr == null)
				&& (accountNumberStr.isEmpty() || accountNumberStr == null)) {

			transactions = transactionDbUtil.getAllTransactions();
			request.setAttribute("message", "Please provide either a date range or an account number");
			request.setAttribute("theTransactions", transactions);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-transactions.jsp");
			requestDispatcher.forward(request, response);

		} else {
			try {
				if (!startDatestr.isEmpty() && startDatestr != null && !endDateStr.isEmpty() && endDateStr != null) {
					startDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(startDatestr).getTime());
					System.out.println(startDate);
					endDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr).getTime());
					System.out.println(endDate);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			if (accountNumberStr.isEmpty() || accountNumberStr == null) {
				transactions = transactionDbUtil.searchTransactionDateWise(startDate, endDate);
			}

			else if (startDatestr == null || endDateStr == null || startDatestr.isEmpty() || endDateStr.isEmpty()) {
				transactions = transactionDbUtil.searchTransactionAccountWise(accountNumber);
			}

			else {
				transactions = transactionDbUtil.searchtransactionAccountDateWise(startDate, endDate, accountNumber);
			}

			request.setAttribute("theTransactions", transactions);
			request.getRequestDispatcher("/view-transactions.jsp").forward(request, response);
		}

	}
}
