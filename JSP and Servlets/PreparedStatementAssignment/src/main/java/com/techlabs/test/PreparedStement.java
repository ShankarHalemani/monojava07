package com.techlabs.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String databaseURL = "jdbc:mysql://localhost:3306/ecommerce_cart";
		String user = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(databaseURL, user, password);) {

			String insertQuery = "insert into `users`(name,email,password) values(?,?,?)";

			for (int i = 0; i < 3; i++) {
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

				System.out.println("Enter Name");
				String name = scanner.next();

				System.out.println("Enter Email");
				String email = scanner.next();

				System.out.println("Enter Password");
				String passcode = scanner.next();

				preparedStatement.setString(1, name);
				preparedStatement.setString(2, email);
				preparedStatement.setString(3, passcode);

				preparedStatement.executeUpdate();
			}

			System.out.println("Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		scanner.close();
	}

}
