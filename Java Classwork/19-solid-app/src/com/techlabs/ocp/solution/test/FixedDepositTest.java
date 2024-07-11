package com.techlabs.ocp.solution.test;

import java.util.Scanner;

import com.techlabs.ocp.solution.model.DiwaliInterestRate;
import com.techlabs.ocp.solution.model.FixedDeposit;
import com.techlabs.ocp.solution.model.HoliInterestRate;
import com.techlabs.ocp.solution.model.IFestivalInterest;
import com.techlabs.ocp.solution.model.NewyearInterestRate;
import com.techlabs.ocp.solution.model.OthersInterestRate;

public class FixedDepositTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int accountNumber;
		double principle;
		int duration;
		IFestivalInterest festival = null;

		System.out.println("Enter account number");
		accountNumber = scanner.nextInt();

		System.out.println("Enter principle amount");
		principle = scanner.nextDouble();

		System.out.println("Enter duration");
		duration = scanner.nextInt();

		boolean exit = false;
		while (!exit) {
			System.out.println("Enter number 1- NewYear, 2-Diwali, 3-Holi, 4-Others");
			int choose = scanner.nextInt();

			switch (choose) {
			case 1:
				festival = new NewyearInterestRate();
				exit = true;
				break;
			case 2:
				festival = new DiwaliInterestRate();
				exit = true;
				break;
			case 3:
				festival = new HoliInterestRate();
				exit = true;
				break;
			case 4:
				festival = new OthersInterestRate();
				exit = true;
				break;

			default:
				System.out.println("Enter Valid Option");
				exit = false;
				break;
			}
		}

		FixedDeposit fixedDeposit = new FixedDeposit(accountNumber, principle, duration, festival);
		System.out.println(fixedDeposit);

		scanner.close();
	}

}
