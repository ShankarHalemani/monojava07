package com.techlabs.model;

public class Account {
	private long accountNumber;
	private String accontType;
	private String accountName;
	private int accountBalance;

	public Account() {
		accountNumber = 0;
		accontType = null;
		accountName = null;
		accountBalance = 0;
	}

	public Account(long accNum, String accType, String accName, int accBalance) {
		accountNumber = accNum;
		accontType = accType;
		accountName = accName;
		accountBalance = accBalance;
	}

	public void setAccNum(long accNum) {
		accountNumber = accNum;
	}

	public long getAccNum() {
		return accountNumber;
	}

	public void setAccType(String accType) {
		accontType = accType;
	}

	public String getAccType() {
		return accontType;
	}

	public void setAccName(String accName) {
		accountName = accName;
	}

	public String getAccName() {
		return accountName;
	}

	public void setAccBalance(int accBalance) {
		accountBalance = accBalance;
	}

	public int getAccBalance() {
		return accountBalance;
	}
}
