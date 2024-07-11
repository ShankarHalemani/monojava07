package com.techlabs.model;

public class Account {
	private long accountNumber;
	private String accountHolderName;
	private double accountBalance;

	public Account() {

	}

	public Account(long accountNumber, String accountHolderName, double accountBalance) {

		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void credit(double amount) {
		this.accountBalance += amount;
	}

	public void debit(double amount) {
		if (this.accountBalance < amount) {
			System.out.println("Insufficient Balance");
		}
		this.accountBalance -= amount;
	}
}
