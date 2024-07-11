package com.techlabs.model;

public class SavingsAccount extends Account {
	private static final long serialVersionUID = 1L;
	private static final int MIN_BALANCE = 500;

	@Override
	public void debit(double amount) {
		double newBalance = getAccountBalance() - amount;
		if (newBalance < MIN_BALANCE) {
			System.out.println("Minimum balance of " + MIN_BALANCE + " is required in Savings account, can't withdraw");
		} else {
			setAccountBalance(newBalance);
		}
	}
}
