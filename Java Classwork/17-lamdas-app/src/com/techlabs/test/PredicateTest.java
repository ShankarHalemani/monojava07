package com.techlabs.test;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

//		Predicate<Integer> evenPredicate = (number) -> {
//			if (number % 2 == 0)
//				return true;
//			return false;
//		};
//
//		if (!evenPredicate.test(3)) {
//			System.out.println("Its is a odd number");
//			System.exit(0);
//		}
//		System.out.println("It is a even number");

//		BiPredicate<Integer, Integer> comparatoreBiPredicate = (number1, number2) -> {
//			if (number1 > number2) {
//				return true;
//			}
//			return false;
//		};
//
//		if (!comparatoreBiPredicate.test(0, 5)) {
//			System.out.println("Number 2 is bigger than Number 1");
//			System.exit(0);
//		}
//		System.out.println("Number 1 is bigger than Number 2");

		Predicate<String> emailValidator = (email) -> {
			if (email.contains("@") && email.indexOf('@') > 0) {
				if (email.contains(".") && email.indexOf('.') > email.indexOf('@') + 1) {
					return true;
				}
				return false;
			}
			return false;
		};

		System.out.println("Enter your Email");
		String emailID = scanner.next();

		if (!emailValidator.test(emailID)) {
			System.out.println("Email is not valid");
			System.exit(0);
		}
		System.out.println("Email is valid");

		scanner.close();
	}

}