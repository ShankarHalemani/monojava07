package com.techlabs.srp.solution;

public class InvoicePrinter {
	private Invoice invoice = null;

	private TaxCalculator taxCalculator = null;

	public InvoicePrinter(Invoice invoice, TaxCalculator taxCalculator) {
		this.invoice = invoice;
		this.taxCalculator = taxCalculator;
	}

	public void printInvoice() {
		System.out.println("\nId : " + invoice.getId());
		System.out.println("Description : " + invoice.getDescription());
		System.out.println("Amount : " + invoice.getAmount() + "/-");
		System.out.println("Tax : " + invoice.getTax() + "%");
		System.out.println("Tax Amount : " + taxCalculator.calculateTax() + "/-");
	}
}
