package com.techlabs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public List<Transaction> getUserTransactions(String emailId) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			Connection connection = dataSource.getConnection();
			String selectQuery = "SELECT " + "t.tnumber, " + "t.sender_account_number, " + "t.receiver_account_number, "
					+ "t.transaction_type, " + "t.transaction_amount, " + "t.date_of_transaction "
					+ "FROM transactions t "
					+ "JOIN accounts a_sender ON t.sender_account_number = a_sender.account_number "
					+ "JOIN accounts a_receiver ON t.receiver_account_number = a_receiver.account_number "
					+ "JOIN customer c_sender ON c_sender.custid = a_sender.custid "
					+ "JOIN customer c_receiver ON c_receiver.custid = a_receiver.custid "
					+ "WHERE c_sender.email = ? OR c_receiver.email = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, emailId);
			ResultSet resultSet = preparedStatement.executeQuery();

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

	public int getUserAccount(String emailId) {
		int accountNumber = 0;
		try {
			Connection connection = dataSource.getConnection();
			String selectQuery = "SELECT A.account_number FROM accounts A JOIN customer C ON A.custid=C.custid WHERE email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, emailId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				accountNumber = resultSet.getInt("account_number");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accountNumber;
	}

	public void commitTransaction(String emailId, int receiverAccount, double transferAmount) {
		System.out.println("operational-commitTransaction");

		int senderAccount = 0;
		double senderBalance = 0;
		double receiverBalance = 0;

		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			// Getting sender's account number and balance
			String getSender = "SELECT A.account_number, A.balance FROM customer C JOIN accounts A ON C.custid=A.custid WHERE C.email = ?";
			PreparedStatement getSenderPst = connection.prepareStatement(getSender);
			getSenderPst.setString(1, emailId);
			ResultSet getSenderResultSet = getSenderPst.executeQuery();

			if (getSenderResultSet.next()) {
				senderAccount = getSenderResultSet.getInt("account_number");
				senderBalance = getSenderResultSet.getDouble("balance");
			}

			// Getting receiver's balance
			String getReceiver = "SELECT balance FROM accounts WHERE account_number = ?";
			PreparedStatement getReceiverPst = connection.prepareStatement(getReceiver);
			getReceiverPst.setInt(1, receiverAccount);
			ResultSet getReceiverResultSet = getReceiverPst.executeQuery();

			if (getReceiverResultSet.next()) {
				receiverBalance = getReceiverResultSet.getDouble("balance");
			}

			// Updating sender's balance if sufficient funds
			if (senderBalance >= transferAmount) {
				String updateSender = "UPDATE accounts SET balance=? WHERE account_number=?";
				PreparedStatement updateSenderPst = connection.prepareStatement(updateSender);
				updateSenderPst.setDouble(1, senderBalance - transferAmount);
				updateSenderPst.setInt(2, senderAccount);
				updateSenderPst.executeUpdate();

				// Updating receiver's balance
				String updateReceiver = "UPDATE accounts SET balance=? WHERE account_number=?";
				PreparedStatement updateReceiverPst = connection.prepareStatement(updateReceiver);
				updateReceiverPst.setDouble(1, receiverBalance + transferAmount);
				updateReceiverPst.setInt(2, receiverAccount);
				updateReceiverPst.executeUpdate();

				// Inserting transaction record
				String insertTransactions = "INSERT INTO transactions (sender_account_number, receiver_account_number, transaction_type, transaction_amount) VALUES (?,?,?,?)";
				PreparedStatement updateTransactionsPst = connection.prepareStatement(insertTransactions);
				updateTransactionsPst.setInt(1, senderAccount);
				updateTransactionsPst.setInt(2, receiverAccount);
				updateTransactionsPst.setString(3, "Transfer");
				updateTransactionsPst.setDouble(4, transferAmount);
				updateTransactionsPst.executeUpdate();

				connection.commit(); // Committing transaction
			} else {
				System.out.println("Insufficient funds for transfer.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback(); // Rolling back transaction on error
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true); // Restoring auto-commit mode
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
