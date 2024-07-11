package com.techlabs.model;

import com.techlabs.exceptions.InsufficientFundsException;
import com.techlabs.exceptions.NegativeAmountException;

public class BankAccount {
	private long accountNumber;
	private double accountBalance;

	public BankAccount(long accountNumber, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void deposite(double amount) throws NegativeAmountException {
		if (amount < 0) {
			throw new NegativeAmountException();
		}
		accountBalance += amount;
	}

	public void withdrawal(double amount) throws NegativeAmountException, InsufficientFundsException {
		if (amount < 0) {
			throw new NegativeAmountException();
		}
		if (accountBalance - amount < 0) {
			throw new InsufficientFundsException();
		}
		accountBalance -= amount;
	}

}
