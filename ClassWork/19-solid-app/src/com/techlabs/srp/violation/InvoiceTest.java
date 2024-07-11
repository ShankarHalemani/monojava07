package com.techlabs.srp.violation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int id;
		String description;
		double amount;
		double tax;

		System.out.println("Enter number of invoices");
		int numberOfInvoices = scanner.nextInt();

		List<Invoice> invoices = new ArrayList<Invoice>();

		for (int i = 0; i < numberOfInvoices; i++) {
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
			invoices.add(invoice);

		}

		invoices.stream().forEach((invoice) -> invoice.printInvoice());

		scanner.close();

	}

}
