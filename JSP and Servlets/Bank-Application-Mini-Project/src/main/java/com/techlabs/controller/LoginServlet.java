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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
		String emailId = request.getParameter("login-email");
		String password = request.getParameter("login-password");
		String userRole = request.getParameter("userRole");

		System.out.println("Email: " + emailId + ", Password: " + password + ", Role: " + userRole);

		if ("Admin".equals(userRole)) {
			if ("admin@gmail.com".equals(emailId) && "admin123".equals(password)) {
				System.out.println("inside Admin");
				HttpSession session = request.getSession();
				session.setAttribute("emailId", emailId);
				session.setAttribute("userRole", "Admin");
				response.sendRedirect("admin"); // Redirect to AdminController
			} else {
				response.sendRedirect("login.jsp?error=true");
			}
		} else if ("User".equals(userRole)) {
			if (customerDbUtil.validateCustomer(emailId, password)) {
				System.out.println("Inside user");
				HttpSession session = request.getSession();
				session.setAttribute("emailId", emailId);
				session.setAttribute("userRole", "User");
				response.sendRedirect("user"); // Redirect to UserController or user home page
			} else {
				response.sendRedirect("login.jsp?error=true");
			}
		}
	}
}
