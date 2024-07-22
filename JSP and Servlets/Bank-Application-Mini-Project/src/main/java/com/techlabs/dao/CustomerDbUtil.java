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

	public boolean validateAdmin(String emailId, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String selectQuery = "select * from admininstator where admin_email=? and admin_password=?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (emailId.equals(resultSet.getString("admin_email"))
						&& password.equals(resultSet.getString("admin_password"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		return false;
	}

	public boolean validateCustomer(String emailId, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String selectQuery = "select * from customer where email=? and pass=?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (emailId.equals(resultSet.getString("email")) && password.equals(resultSet.getString("pass"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return false;
	}

	public boolean chechCustomerExists(String emailId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM customer WHERE email=?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, emailId);
			resultSet = preparedStatement.executeQuery();

			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return false;
	}

	public void addNewCustomer(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String insertQuery = "INSERT INTO customer (fname, lname, email, pass) VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(insertQuery);
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
		} finally {
			closeConnection(connection, preparedStatement);
		}

	}

	public List<Customer> getCustomer(int customerId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Customer> customers = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM customer WHERE custid=?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, customerId);

			resultSet = preparedStatement.executeQuery();

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
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return customers;
	}

	public List<Customer> getcurrentCustomerbyEmail(String emailId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Customer> customers = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM customer WHERE email=?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, emailId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String firstName = resultSet.getString("fname");
				String lastName = resultSet.getString("lname");
				int customerId = resultSet.getInt("custid");
				String password = resultSet.getString("pass");

				Customer customer = new Customer(customerId, firstName, lastName, emailId, password);
				customers.add(customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return customers;
	}

	public List<CustomerAccount> searchCustomersByName(String customerName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<CustomerAccount> customerAccounts = new ArrayList<CustomerAccount>();
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT C.custid, C.fname, C.lname, A.account_number, A.balance " + "FROM customer C "
					+ "JOIN accounts A ON C.custid = A.custid " + "WHERE C.fname LIKE ? OR C.lname LIKE ?";

			preparedStatement = connection.prepareStatement(selectQuery);

			String searchCustomer = "%" + customerName + "%";
			preparedStatement.setString(1, searchCustomer);
			preparedStatement.setString(2, searchCustomer);

			resultSet = preparedStatement.executeQuery();

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
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return customerAccounts;
	}

	public List<CustomerAccount> searchCustomersById(int customerId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<CustomerAccount> customerAccounts = new ArrayList<CustomerAccount>();
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT C.custid, C.fname, C.lname, A.account_number, A.balance from customer C JOIN accounts A ON C.custid=A.custid WHERE C.custid=?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, customerId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
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
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return customerAccounts;
	}

	public boolean checkCutomerAccountExists(int customerId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM accounts WHERE custid = ?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, customerId);
			resultSet = preparedStatement.executeQuery();

			return resultSet.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return false;
	}

	public void createCustomerAccount(int customerId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		System.out.println("Inside createCustomerAccount");
		try {
			connection = dataSource.getConnection();
			String insertQuery = "INSERT INTO accounts (custid) VALUES (?)";
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, customerId);
			int rs = preparedStatement.executeUpdate();

			if (rs == 1) {
				System.out.println("Added");
			} else {
				System.out.println("Not added");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement);
		}
	}

	public List<CustomerAccount> getCustomerDetails() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		List<CustomerAccount> customerAccounts = new ArrayList<CustomerAccount>();
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT C.custid, C.fname, C.lname, A.account_number, A.balance from customer C JOIN accounts A ON C.custid=A.custid";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectQuery);

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
		} finally {
			closeConnection(connection, statement, resultSet);
		}

		return customerAccounts;
	}

	public void updateCustomer(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String updateQuery = "UPDATE customer SET fname=?, lname=?, pass=? WHERE email=?";
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getPassword());
			preparedStatement.setString(4, customer.getEmailId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement);
		}

	}

	private void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {

		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void closeConnection(Connection connection, Statement statement) {

		try {

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
