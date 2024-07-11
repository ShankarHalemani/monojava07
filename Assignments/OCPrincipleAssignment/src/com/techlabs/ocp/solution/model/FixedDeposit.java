package com.techlabs.ocp.solution.model;

public class FixedDeposit {
	private int accountNumber;
	private double principle;
	private int duration;
	private IFestivalInterest interest;

	public FixedDeposit(int accountNumber, double principle, int duration, IFestivalInterest interest) {
		this.accountNumber = accountNumber;
		this.principle = principle;
		this.duration = duration;
		this.interest = interest;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getPrinciple() {
		return principle;
	}

	public void setPrinciple(double principle) {
		this.principle = principle;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getInterestRate() {
		return interest.getInterestRates();
	}

}
