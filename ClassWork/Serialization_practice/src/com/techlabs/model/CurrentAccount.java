package com.techlabs.model;

public class CurrentAccount extends Account {
	private static final long serialVersionUID = 1L;
	private static final int OVER_DRAFT_LIMIT = 5000;

	@Override
	public void debit(double amount) {
		double newBalance = getAccountBalance() - amount;
		if (newBalance < -OVER_DRAFT_LIMIT) {
			System.out.println("Overdraft limit exceeded, can't withdraw");
		}

		else {
			setAccountBalance(newBalance);
		}
	}
}
