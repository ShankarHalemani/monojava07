package com.techlabs.test;

import java.util.Scanner;
import java.util.function.BiFunction;

public class FunctionTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

//		Function<String, Integer> stringLengthFinder = (string) -> {
//			return string.length();
//		};
//
//		System.out.println("Enter a string");
//		String string = scanner.nextLine();
//
//		System.out.println("Length of string : " + stringLengthFinder.apply(string));

		BiFunction<Integer, Double, String> moneyFinder = (rupay, paisa) -> {
			return "You have " + rupay + " rupees and " + paisa + " paisas";
		};

		System.out.println("Enter number of rupay you have");
		int rupay = scanner.nextInt();

		System.out.println("Enter number of paisas you have");
		double paisa = scanner.nextDouble();

		System.out.println(moneyFinder.apply(rupay, paisa));

		scanner.close();
	}

}
