package com.techlabs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techlabs.model.Account;
import com.techlabs.model.Customer;
import com.techlabs.model.CustomerAccount;

public class CustomerDbUtil {
	private DataSource dataSource;

	public CustomerDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean validateCustomer(String emailId, String password) {
		try {
			Connection connection = dataSource.getConnection();
			String selectQuery = "select * from customer where email=? and pass=?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (emailId.equals(resultSet.getString("email")) && password.equals(resultSet.getString("pass"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void addNewCustomer(Customer customer) {
		try {
			Connection connection = dataSource.getConnection();
			String insertQuery = "INSERT INTO customer (fname, lname, email, pass) VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmailId());
			preparedStatement.setString(4, customer.getPassword());

			int rs = preparedStatement.executeUpdate();

			if (rs == 1) {
				System.out.println("Added");
			} else {
				System.out.println("Not added");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Customer> getCustomer(int customerId) {
		List<Customer> customers = new ArrayList<>();
		try {
			Connection connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM customer WHERE custid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, customerId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String firstName = resultSet.getString("fname");
				String lastName = resultSet.getString("lname");
				String emailId = resultSet.getString("email");
				String password = resultSet.getString("pass");

				Customer customer = new Customer(customerId, firstName, lastName, emailId, password);
				customers.add(customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;
	}

	public void createCustomerAccount(int customerId) {
		System.out.println("Inside createCustomerAccount");
		try {
			Connection connection = dataSource.getConnection();
			String insertQuery = "INSERT INTO accounts (custid) VALUES (?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, customerId);
			int rs = preparedStatement.executeUpdate();

			if (rs == 1) {
				System.out.println("Added");
			} else {
				System.out.println("Not added");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<CustomerAccount> getCustomerDetails() {
		List<CustomerAccount> customerAccounts = new ArrayList<CustomerAccount>();
		try {
			Connection connection = dataSource.getConnection();
			String selectQuery = "SELECT C.custid, C.fname, C.lname, A.account_number, A.balance from customer C JOIN accounts A ON C.custid=A.custid";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int customerId = resultSet.getInt("custid");
				String firstName = resultSet.getString("fname");
				String lastName = resultSet.getString("lname");
				int accountNumber = Integer.parseInt(resultSet.getString("account_number"));
				double balance = Double.parseDouble(resultSet.getString("balance"));

				Customer customer = new Customer(customerId, firstName, lastName, null, null);
				Account account = new Account(accountNumber, balance);

				CustomerAccount customerAccount = new CustomerAccount(customer, account);

				customerAccounts.add(customerAccount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customerAccounts;
	}

	public void updateCustomer(Customer customer) {
		try {
			Connection connection = dataSource.getConnection();
			String updateQuery = "UPDATE customer SET fname=?, lname=?, pass=? WHERE email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getPassword());
			preparedStatement.setString(4, customer.getEmailId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
