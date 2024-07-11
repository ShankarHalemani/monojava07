package com.techlabs.srp.violation;

public class Invoice {
	private int id;
	private String description;
	private double amount;

	private double tax;

	public Invoice(int id, String description, double amount, double tax) {
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.tax = tax;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double calculateTax() {
		double taxAmount = (amount * tax) / 100;
		return taxAmount;
	}

	public void printInvoice() {
		System.out.println("\nId : " + getId());
		System.out.println("Description : " + getDescription());
		System.out.println("Amount : " + getAmount() + "/-");
		System.out.println("Tax : " + getTax() + "%");
		System.out.println("Tax Amount : " + calculateTax() + "/-");
	}
}
