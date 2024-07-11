package com.techlabs.ocp.solution.model;

public class DetailPrinter {
	private FixedDeposit fixedDeposit = null;
	private CalculateInterest calculateInterest = null;

	public DetailPrinter(FixedDeposit fixedDeposit, CalculateInterest calculateInterest) {
		this.fixedDeposit = fixedDeposit;
		this.calculateInterest = calculateInterest;
	}

	public void printDetails() {
		System.out.println("Account Number : " + fixedDeposit.getAccountNumber());
		System.out.println("Principle amount : " + fixedDeposit.getPrinciple());
		System.out.println("Duration : " + fixedDeposit.getDuration());
		System.out.println("Interest rate : " + fixedDeposit.getInterestRate());
		System.out.println("Total Interest : " + calculateInterest.calculateSimpleInterest());
	}

}
