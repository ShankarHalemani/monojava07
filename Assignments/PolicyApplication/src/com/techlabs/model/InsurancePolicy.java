package com.techlabs.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InsurancePolicy {
	private long policyNumber;
	private String policyHolderName;
	private double policyAmount;
	private LocalDate policyCreationDate;

	public InsurancePolicy(long policyNumber, String policyHolderName, double policyAmount,
			LocalDate policyCreationDate) {
		super();
		this.policyNumber = policyNumber;
		this.policyHolderName = policyHolderName;
		this.policyAmount = policyAmount;
		this.policyCreationDate = policyCreationDate;
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public double getPolicyAmount() {
		return policyAmount;
	}

	public void setPolicyAmount(double policyAmount) {
		this.policyAmount = policyAmount;
	}

	public LocalDate getPolicyCreationDate() {
		return policyCreationDate;
	}

	public void setPolicyCreationDate(LocalDate policyCreationDate) {
		this.policyCreationDate = policyCreationDate;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "\n[policyNumber=" + policyNumber + ", policyHolderName=" + policyHolderName + ", policyAmount="
				+ policyAmount + ", policyCreationDate=" + policyCreationDate.format(formatter) + "]";
	}

}
