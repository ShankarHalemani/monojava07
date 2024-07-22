package com.techlabs.dao;

import java.sql.Connection;
import java.sql.Date;
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
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM transactions";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectQuery);

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
		} finally {
			closeConnection(connection, statement, resultSet);
		}

		return transactions;
	}

	public List<Transaction> getUserTransactions(String emailId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT " + "t.tnumber, " + "t.sender_account_number, " + "t.receiver_account_number, "
					+ "t.transaction_type, " + "t.transaction_amount, " + "t.date_of_transaction "
					+ "FROM transactions t "
					+ "JOIN accounts a_sender ON t.sender_account_number = a_sender.account_number "
					+ "JOIN accounts a_receiver ON t.receiver_account_number = a_receiver.account_number "
					+ "JOIN customer c_sender ON c_sender.custid = a_sender.custid "
					+ "JOIN customer c_receiver ON c_receiver.custid = a_receiver.custid "
					+ "WHERE c_sender.email = ? OR c_receiver.email = ?";

			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, emailId);
			resultSet = preparedStatement.executeQuery();

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
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return transactions;
	}

	public int getUserAccount(String emailId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int accountNumber = 0;
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT A.account_number FROM accounts A JOIN customer C ON A.custid=C.custid WHERE email=?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, emailId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				accountNumber = resultSet.getInt("account_number");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return accountNumber;
	}

	public boolean checkSameAccountTransfer(String emailId, int receiverAccount) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int accountNumber = 0;
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT A.account_number FROM accounts A JOIN customer C ON A.custid=C.custid WHERE email=?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, emailId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				accountNumber = resultSet.getInt("account_number");
			}

			return accountNumber == receiverAccount;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		return false;
	}

	public boolean checkAccountExists(int receiverAccount) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM accounts WHERE account_number=?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, receiverAccount);
			resultSet = preparedStatement.executeQuery();

			return resultSet.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		return false;
	}

	public boolean checkSufficientBalance(String emailId, double transferAmount) {
		double customerBalance = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT A.account_number, A.balance FROM customer C JOIN accounts A ON C.custid=A.custid WHERE C.email = ?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, emailId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				customerBalance = resultSet.getDouble("balance");
			}

			return customerBalance >= transferAmount;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		return false;
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

	public List<Transaction> searchTransactionDateWise(Date startDate, Date endDate) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM transactions WHERE DATE(date_of_transaction) BETWEEN ? AND ?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setDate(1, startDate);
			preparedStatement.setDate(2, endDate);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int transactionId = resultSet.getInt("tnumber");
				int senderAccountNumber = resultSet.getInt("sender_account_number");
				int receiverAccountNumber = resultSet.getInt("receiver_account_number");
				Timestamp dateOfTransaction = resultSet.getTimestamp("date_of_transaction");
				System.out.println(dateOfTransaction);
				String transactionType = resultSet.getString("transaction_type");
				double transactionAmount = resultSet.getDouble("transaction_amount");
				Transaction transaction = new Transaction(transactionId, senderAccountNumber, receiverAccountNumber,
						dateOfTransaction, transactionType, transactionAmount);
				transactions.add(transaction);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return transactions;
	}

	public List<Transaction> searchTransactionAccountWise(int accountNumber) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM transactions WHERE sender_account_number=? OR receiver_account_number=?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, accountNumber);
			preparedStatement.setInt(2, accountNumber);

			resultSet = preparedStatement.executeQuery();

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
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return transactions;
	}

	public List<Transaction> searchtransactionAccountDateWise(Date startDate, Date endDate, int ccountNumber) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM transactions WHERE (sender_account_number = ? OR receiver_account_number = ?) AND DATE(date_of_transaction) BETWEEN ? AND ?";

			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, ccountNumber);
			preparedStatement.setInt(2, ccountNumber);
			preparedStatement.setDate(3, startDate);
			preparedStatement.setDate(4, endDate);
			resultSet = preparedStatement.executeQuery();

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
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}

		return transactions;
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

}
