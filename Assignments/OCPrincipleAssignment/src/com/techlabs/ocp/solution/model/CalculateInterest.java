package com.techlabs.ocp.solution.model;

public class CalculateInterest {
	private FixedDeposit fixedDeposit = null;

	public CalculateInterest(FixedDeposit fixedDeposit) {
		this.fixedDeposit = fixedDeposit;
	}

	public double calculateSimpleInterest() {
		return (fixedDeposit.getInterestRate() * fixedDeposit.getPrinciple() * fixedDeposit.getDuration()) / 100;
	}

}
