package com.techlabs.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PreparedStmtServlet")
public class PreparedStmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String dbURL = "jdbc:mysql://localhost:3306/ecommerce_cart";
	private String userName = "root";
	private String password = "root";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(dbURL, userName, password);) {

//			String updateQuery = "update users set name=? where id=4 ";
//			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
//			preparedStatement.setString(1, "Zoro");
//			int rs = preparedStatement.executeUpdate();

//			String deleteQuery = "delete from `users` where id= ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
//			preparedStatement.setInt(1, 5);
//			int rs = preparedStatement.executeUpdate();

			String selectQuery = "select * from users where email=? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, "luffytaro@gmail.com");
			preparedStatement.setString(2, "luffy@123");
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("name"));
			}

			System.out.println("Rows Affected : " + resultSet.getFetchSize());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
