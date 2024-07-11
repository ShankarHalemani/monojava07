package com.techlabs.model;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private long accountNumber;
	private String accountHolderName;
	private double accountBalance;

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
