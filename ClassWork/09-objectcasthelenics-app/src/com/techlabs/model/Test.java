package com.techlabs.model;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number ");
		int number = scanner.nextInt();

		int factorialOfNumber = calculateFactorial(number);
		if (number >= 0) {
			System.out.println("Fatorial of " + number + " is " + factorialOfNumber);
		}

		scanner.close();
	}

	private static int calculateFactorial(int number) {
		int factorial = 1;

		if (number < 0) {
			System.out.println("Factorial of negative number is not possible");
			return -1;
		}

		if (number == 0) {
			return 1;
		}

		for (int i = 2; i < number; i++) {
			factorial *= i;
		}

		return factorial;

	}

}
