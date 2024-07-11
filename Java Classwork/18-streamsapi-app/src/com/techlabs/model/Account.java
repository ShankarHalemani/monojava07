package com.techlabs.model;

public class Account {
	private long accountNumber;
	private String accountHolderName;
	private int accountBalance;

	public Account(long accountNumber, String accountHolderName, int accountBalance) {
		super();
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

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "\n[accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", accountBalance="
				+ accountBalance + "]";
	}

}
