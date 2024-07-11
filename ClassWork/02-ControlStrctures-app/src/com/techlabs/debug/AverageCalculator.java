package com.techlabs.debug;

public class AverageCalculator {

	public static void main(String[] args) {
		int number1 = 10;
		int number2 = 20;

		int sum = Addition(number1, number2);
		double avg = Average(sum);

		System.out.println("Average of " + number1 + " and " + number2 + " is " + avg);

	}

	public static int Addition(int number1, int number2) {
		System.out.println("Inside Addition");
		System.out.println("Inside addition 2");

		return number1 + number2;
	}

	public static double Average(int sum) {
		return sum / 2;
	}

}
