package com.techlabs.test;

import java.util.Scanner;
import java.util.function.BinaryOperator;

public class UnaryBinaryTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

//		UnaryOperator<Integer> squarerootOfNumber = (number) -> {
//			return number * number;
//		};
//
//		System.out.println("Enter number to calculate square root of it");
//		int number = scanner.nextInt();
//
//		System.out.println("Square root of number : " + squarerootOfNumber.apply(number));

		BinaryOperator<Double> multiplier = (number1, number2) -> {
			return number1 * number2;
		};

		System.out.println("Enter Number 1");
		double number1 = scanner.nextDouble();

		System.out.println("Enter Number 2");
		double number2 = scanner.nextDouble();

		System.out.println("Multiplication of numbers : " + multiplier.apply(number1, number2));

		scanner.close();
	}

}
