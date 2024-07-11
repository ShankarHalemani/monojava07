package com.techlabs.model;

public class Account {
	private long accountNumber;
	private String accountName;
	private int balance;
	private AccountType accountType;

	public Account(long accountNumber, String accountName, int balance, AccountType accountType) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
		this.accountType = accountType;
	}

	public Account() {
		super();
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account Number=" + accountNumber + "\nAccount Holder Name=" + accountName + "\nBalance=" + balance
				+ "\nAccount Type=" + accountType + " ";
	}

}
