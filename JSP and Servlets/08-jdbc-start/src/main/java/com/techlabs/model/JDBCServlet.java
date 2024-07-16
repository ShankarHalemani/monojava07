package com.techlabs.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JDBCServlet")
public class JDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart", "root",
					"root");
			Statement statement = connection.createStatement();

//			String insertQuery = "INSERT INTO `users` VALUES (3,'Soumya','soumyak@gmail.com','910863')";
//			int result = statement.executeUpdate(insertQuery);
//			System.out.println("Number of rows affected : " + result);

//			String updateQuery = "update `users` set name='Suyash' where id = 1";
//			int result = statement.executeUpdate(updateQuery);
//			System.out.println("Number of rows affected : " + result);

//			String deleteQuery = "delete from `users` where id = 3";
//			int result = statement.executeUpdate(deleteQuery);
//			System.out.println("Number of rows affected : " + result);

			String selectQuery = "select * from users";
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				System.out.println(id);
				String name = resultSet.getString("name");
				System.out.println(name);
				String emailId = resultSet.getString("email");
				System.out.println(emailId);
				String password = resultSet.getString("password");
				System.out.println(password);

				System.out.println();

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
