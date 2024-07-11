package com.techlabs.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.techlabs.model.InsuranceComparator;
import com.techlabs.model.InsurancePolicy;

public class InsurancePolicyTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<InsurancePolicy> policies = new LinkedList<InsurancePolicy>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter number of policies to be created");
		int numberOfPolicies = scanner.nextInt();

		for (int i = 0; i < numberOfPolicies; i++) {
			System.out.println("Enter Policy number");
			long policyNumber = scanner.nextLong();
			scanner.nextLine(); // Consume Line

			System.out.println("Enter Policy Holder name");
			String policyHolderName = scanner.nextLine();

			System.out.println("Enter Policy amount");
			double policyAmount = scanner.nextDouble();
			scanner.nextLine(); // Consume Line

			System.out.println("Enter policy date in format of dd/MM/yyyy");
			String policyCreationDateStr = scanner.nextLine();

			LocalDate policyCreationDate = null;
			try {
				policyCreationDate = LocalDate.parse(policyCreationDateStr, formatter);
			} catch (DateTimeParseException e) {
				System.out.println("Invalid date format Please enter date in suggested format");
				i--;
				continue;
			}

			InsurancePolicy insurancePolicy = new InsurancePolicy(policyNumber, policyHolderName, policyAmount,
					policyCreationDate);

			policies.add(insurancePolicy);

		}

		boolean exit = false;

		while (!exit) {
			System.out.println("1. Sort according to policy holder name");
			System.out.println("2. Sort according to policy amount");
			System.out.println("3. Sort according to policy creation date");
			System.out.println("4. Exit");

			System.out.println("Enter your choice");
			int choose = scanner.nextInt();

			switch (choose) {
			case 1:
				Collections.sort(policies, new InsuranceComparator.InsuranceByHolderName());
				System.out.println(policies);
				System.out.println();
				break;
			case 2:
				Collections.sort(policies, new InsuranceComparator.InsuranceByAmount());
				System.out.println(policies);
				System.out.println();
				break;
			case 3:
				Collections.sort(policies, new InsuranceComparator.InsuranceByCreationDate());
				System.out.println(policies);
				System.out.println();
				break;
			case 4:
				System.out.println("Exiting application");
				exit = true;
				break;

			default:
				System.out.println("Enter valid choice");
				break;
			}
		}

		scanner.close();
	}

}
