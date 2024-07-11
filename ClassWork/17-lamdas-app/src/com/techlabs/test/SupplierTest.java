package com.techlabs.test;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Supplier<String> string = () -> {
			System.out.println("Enetr your name");
			String str1 = scanner.next();
			return str1;
		};

		System.out.println("Name is : " + string.get());
		System.out.println();

		Supplier<LocalDate> todayDate = () -> {
			LocalDate todaysDate = LocalDate.now();
			return todaysDate;
		};

		System.out.println(todayDate.get());

		scanner.close();
	}

}
