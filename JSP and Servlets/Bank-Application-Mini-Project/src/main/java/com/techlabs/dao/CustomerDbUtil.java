package com.techlabs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.techlabs.model.Customer;

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

}
