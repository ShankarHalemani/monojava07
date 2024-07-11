package com.techlabs.arrays;

import java.util.Scanner;

public class SumOfArray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enetr array size");
		int n = scanner.nextInt();
		int array[] = new int[n];
		int sum = 0;

		System.out.println("Enter array elements");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
			sum += array[i];
		}

		System.out.println("Sum of elements : " + sum);
		scanner.close();
	}

}
