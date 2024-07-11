package com.techlabs.switchs;

import java.util.Scanner;

public class SeasonOfMonth {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter month number");
		int monthNumber = scanner.nextInt();

		switch (monthNumber) {
			case 1:
			case 2:
			case 12:
				System.out.println("Winter");
				break;

			case 3:
			case 4:
			case 5:
				System.out.println("Summer");
				break;

			case 6:
			case 7:
			case 8:
			case 9:
				System.out.println("Monsoon");
				break;

			case 10:
			case 11:
				System.out.println("Autumn");
				break;

			default:
				System.out.println("Invalid month number");
				break;
		}

		scanner.close();
	}

}
