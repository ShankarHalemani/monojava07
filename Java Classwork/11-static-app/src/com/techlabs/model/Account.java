package com.techlabs.model;

public class Account {
	private long accountNumber;
	private String accountName;
	private int accountBalance;

	private static int countAccount = 0;

	public Account(long accountNumber, String accountName, int accountBalance) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
		countAccount++;
	}

	public void displayAccountInfo() {
		System.out.println("Account Number : " + accountNumber);
		System.out.println("Account Holder Name : " + accountName);
		System.out.println("Account Balance : " + accountBalance);
		System.out.println("Account " + countAccount + " is created");
		System.out.println();
	}

	public static void totalAccounts() {
		System.out.println("Total " + countAccount + " accounts are created");
	}

}
