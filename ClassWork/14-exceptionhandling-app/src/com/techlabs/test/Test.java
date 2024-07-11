package com.techlabs.test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter number 1");
			int number1 = scanner.nextInt();

			System.out.println("Enter number 2");
			int number2 = scanner.nextInt();

			double divsion = calculateDivision(number1, number2);

			System.out.println("Divion is : " + divsion);
		}

		catch (ArithmeticException e) {
			System.out.println(" we cannot divide by zero");

		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Wrong number of inputs");
		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			System.out.println("Finally");
		}

		System.out.println("Byee");

		scanner.close();
	}

	private static double calculateDivision(int number1, int number2) {
		double division = 0;
		try {
			division = number1 / number2;
		}

		catch (ArithmeticException e) {
			System.out.println("Can't divide by zero");
		}

		finally {
			System.out.println("Finally inside method");
		}

		return division;
	}

}
