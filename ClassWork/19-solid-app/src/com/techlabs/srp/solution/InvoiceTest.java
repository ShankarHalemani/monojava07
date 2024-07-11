package com.techlabs.srp.solution;

import java.util.Scanner;

public class InvoiceTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int id;
		String description;
		double amount;
		double tax;

		System.out.println("Enter Id");
		id = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Description");
		description = scanner.nextLine();

		System.out.println("Enter amount");
		amount = scanner.nextDouble();

		System.out.println("Enter Tax in %");
		tax = scanner.nextDouble();

		Invoice invoice = new Invoice(id, description, amount, tax);

		TaxCalculator taxCalculator = new TaxCalculator(invoice);

		InvoicePrinter invoicePrinter = new InvoicePrinter(invoice, taxCalculator);
		invoicePrinter.printInvoice();

		scanner.close();

	}

}
