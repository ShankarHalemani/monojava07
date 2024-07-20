package com.techlabs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techlabs.model.Transaction;

public class TransactionDbUtil {
	private DataSource dataSource;

	public TransactionDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Transaction> getAllTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			Connection connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM transactions";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int transactionId = resultSet.getInt("tnumber");
				int senderAccountNumber = resultSet.getInt("sender_account_number");
				int receiverAccountNumber = resultSet.getInt("receiver_account_number");
				Timestamp dateOfTransaction = resultSet.getTimestamp("date_of_transaction");
				String transactionType = resultSet.getString("transaction_type");
				double transactionAmount = resultSet.getDouble("transaction_amount");

				Transaction transaction = new Transaction(transactionId, senderAccountNumber, receiverAccountNumber,
						dateOfTransaction, transactionType, transactionAmount);
				transactions.add(transaction);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}

}
