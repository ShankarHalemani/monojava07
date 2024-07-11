package com.techlabs.ocp.violation.model;

public class FixedDeposit {
	private int accountNumber;
	private double principle;
	private int duration;
	private FestivalType festival;

	public FixedDeposit(int accountNumber, double principle, int duration, FestivalType festival) {
		super();
		this.accountNumber = accountNumber;
		this.principle = principle;
		this.duration = duration;
		this.festival = festival;
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

	public FestivalType getFestival() {
		return festival;
	}

	public void setFestival(FestivalType festival) {
		this.festival = festival;
	}

	public double getInterestRates() {
		switch (festival) {
		case NEWYEAR:
			return 8.0;
		case DIWALI:
			return 8.5;
		case HOLI:
			return 7.5;
		default:
			return 6.5;
		}
	}

	public double calculateSimpleInterest() {
		return (getPrinciple() * getInterestRates() * getDuration()) / 100;
	}

}
