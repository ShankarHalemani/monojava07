package com.techlabs.model;

public class Account {
	private long accountNumber;
	private String accountType;
	private String name;
	private int balance;

	public void initializeAccount(long accNum, String accType, String accName, int accbalance) {
		accountNumber = accNum;
		accountType = accType;
		name = accName;
		balance = accbalance;
	}

	public void setAccNumber(long accNum) {
		accountNumber = accNum;
	}

	public void setAccType(String accType) {
		accountType = accType;
	}

	public void setAccName(String accName) {
		name = accName;
	}

	public void setBalance(int accBalance) {
		balance = accBalance;
	}

	public long getAccNumber() {
		return accountNumber;
	}

	public String getAccType() {
		return accountType;
	}

	public String getAccname() {
		return name;
	}

	public int getAccBalance() {
		return balance;
	}
}
