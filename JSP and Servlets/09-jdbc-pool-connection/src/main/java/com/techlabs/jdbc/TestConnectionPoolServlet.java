package com.techlabs.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/TestConnectionPool")
public class TestConnectionPoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/ecommerce_cart")
	private DataSource dataSource;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {

			String selectQuery = "select * from users";
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
