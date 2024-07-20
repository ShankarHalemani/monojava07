package com.techlabs.model;

import java.sql.Timestamp;

public class Transaction {
	private int transactionId;
	private int senderAccountNumber;
	private int receiverAccountNumber;
	private Timestamp dateOfTransaction;
	private String transactionType;
	private double transactionAmount;

	public Transaction(int transactionId, int senderAccountNumber, int receiverAccountNumber,
			Timestamp dateOfTransaction, String transactionType, double transactionAmount) {
		super();
		this.transactionId = transactionId;
		this.senderAccountNumber = senderAccountNumber;
		this.receiverAccountNumber = receiverAccountNumber;
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public void setSenderAccountNumber(int senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}

	public int getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(int receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public Timestamp getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Timestamp dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

}
