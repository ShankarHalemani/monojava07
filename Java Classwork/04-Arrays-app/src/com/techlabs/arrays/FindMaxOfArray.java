package com.techlabs.arrays;

import java.util.Scanner;

public class FindMaxOfArray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enetr array size");
		int n = scanner.nextInt();
		int array[] = new int[n];

		System.out.println("Enter array elements");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}

		int maxElement = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxElement) {
				maxElement = array[i];
			}
		}
		System.out.println("Maximum element of array is " + maxElement);
		scanner.close();
	}

}
