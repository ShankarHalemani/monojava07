package com.techlabs.arrays;

import java.util.Scanner;

public class PeakElementsPrint {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enetr array size");
		int n = scanner.nextInt();
		int array[] = new int[n];
		int[] result = new int[n];

		// Taking array elements from user
		System.out.println("Enter array elements");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}

		System.out.println();
		if (n == 1) {
			System.out.println(array[0]);
		} else {
			for (int i = 0; i < array.length; i++) {
				if (i == 0 && array[i] > array[i + 1]) {
//					System.out.print(array[i] + " ");
					result[i] = array[i];
				}

				if (i == array.length - 1 && array[i] > array[i - 1]) {
//					System.out.print(array[i] + " ");
					result[i] = array[i];
				}

				if (i > 0 && i < array.length - 1 && array[i] > array[i + 1] && array[i] > array[i - 1]) {
//					System.out.print(array[i] + " ");
					result[i] = array[i];
				}
			}

			for (int i = 0; i < result.length; i++) {
				if (result[i] == 0) {
					continue;
				} else {
					System.out.print(result[i] + " ");
				}
			}
		}

		scanner.close();

	}

}
