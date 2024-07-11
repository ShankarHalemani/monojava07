package com.techlabs.ifelse;

import java.util.*;

public class RideBillCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the height");
		int height = scanner.nextInt();
		int charge = 0;
		int total_bill;

		if (height > 120) {
			System.out.println("Can ride");
			System.out.println("Enter the age");
			int age = scanner.nextInt();

			if (age < 12) {
				charge = 5;
			} else if (age >= 12 && age < 18) {
				charge = 7;
			} else if (age >= 45 && age <= 55) {
				charge = 0;
			} else if (age >= 18) {
				charge = 12;
			} else {
				System.out.println("Invalid age range.");
			}

			String photos;
			System.out.println("Do you want photos : Yes or No ");
			photos = scanner.next();
			
			if (photos.equalsIgnoreCase("Yes")) {
				total_bill = charge + 3;
			} else {
				total_bill = charge;
			}

			System.out.println("Total bill is : " + total_bill);
		} else {
			System.out.println("Can't ride");
		}

		scanner.close();
	}
}
