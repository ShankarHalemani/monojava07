package com.techlabs.ocp.violation.test;

import java.util.Scanner;

import com.techlabs.ocp.violation.model.FestivalType;
import com.techlabs.ocp.violation.model.FixedDeposit;

public class FixedDepositTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int accountNumber;
		double principle;
		int duration;
		FestivalType festival = FestivalType.OTHERS;

		System.out.println("Enter Account number");
		accountNumber = scanner.nextInt();

		System.out.println("Enter Principle amount");
		principle = scanner.nextDouble();

		System.out.println("Enter duration");
		duration = scanner.nextInt();

		System.out.println("Enter festival (NEWYEAR, DIWALI, HOLI, OTHERS)");
		String festivalInput = scanner.next().toUpperCase();

		try {
			festival = FestivalType.valueOf(festivalInput);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid festival type, defaulting to OTHERS.");
		}

		FixedDeposit fixedDeposit = new FixedDeposit(accountNumber, principle, duration, festival);
		System.out.println("Simple Interest : " + fixedDeposit.calculateSimpleInterest());

		scanner.close();
	}

}
