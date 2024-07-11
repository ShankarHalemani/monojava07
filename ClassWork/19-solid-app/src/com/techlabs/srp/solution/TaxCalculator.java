package com.techlabs.srp.solution;

public class TaxCalculator {
	private double taxAmount;
	private Invoice invoice = null;

	public TaxCalculator(Invoice invoice) {
		this.invoice = invoice;
	}

	public double calculateTax() {
		taxAmount = (invoice.getAmount() * invoice.getTax()) / 100;
		return taxAmount;
	}

}
