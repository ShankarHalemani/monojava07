package com.techlabs.model;

public class CurrentAccount extends Account {
	private static final int OVER_DRAFT_LIMIT = 5000;
	private double overdraftAmount;

	public CurrentAccount(long accountNumber, String accountHolderName, double accountBalance) {
		super(accountNumber, accountHolderName, accountBalance);
		this.overdraftAmount = 0;
	}

	@Override
	public void debit(double amount) {
		double availableBalance = getAccountBalance() + (OVER_DRAFT_LIMIT - overdraftAmount);

		if (amount > availableBalance) {
			System.out.println("Overdraft limit exceeded, can't withdraw.");
			return;
		}

		if (amount <= getAccountBalance()) {
			// Deduct from account balance if there's enough balance
			setAccountBalance(getAccountBalance() - amount);
		}

		if (amount > getAccountBalance()) {
			// Use available balance first, then use overdraft
			double remainingAmount = amount - getAccountBalance();
			setAccountBalance(0);
			overdraftAmount += remainingAmount;
		}

		System.out.println("Amount of " + amount + " is debited from your account.");
		System.out.println("Overdraft amount: " + overdraftAmount);
	}
}
