package com.techlabs.model;

public class SavingsAccount extends Account {

	public SavingsAccount(long accountNumber, String accountHolderName, double accountBalance) {
		super(accountNumber, accountHolderName, accountBalance);
	}

	private static final int MIN_BALANCE = 500;

	@Override
	public void debit(double amount) {
		double newBalance = getAccountBalance() - amount;
		if (newBalance < MIN_BALANCE) {
			System.out.println("Minimum balance of " + MIN_BALANCE + " is required in Savings account, can't withdraw");
			return;
		}

		if (newBalance >= MIN_BALANCE) {
			setAccountBalance(newBalance);
		}
		System.out.println("Amount of " + amount + " is debited from your accont");
	}
}
