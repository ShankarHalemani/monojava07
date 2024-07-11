package com.techlabs.arrays;

import java.util.Scanner;

public class SecondLargestElementOfArray {

	public static void main(String[] args) {

		// Initialization
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = scanner.nextInt();
		int[] arr = new int[size];

		// Taking input from user
		System.out.println("Enter array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}

		// Exit if size of array is less than 2
		if (size < 2) {
			System.out.println("There is no second largest element");
		} else {
			// Sort the array using selection sort
			selectionSort(arr);

			// Find the second largest element in the sorted array
			int maxElement = arr[size - 1];
			int secondLargestElement = maxElement;
			boolean found = false;

			for (int i = size - 2; i >= 0; i--) {
				if (arr[i] != maxElement) {
					secondLargestElement = arr[i];
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("There is no second largest element");
			} else {
				System.out.println("Second largest element: " + secondLargestElement);
			}
		}
		scanner.close();
	}

	// Selection sort method
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			// Swap the found minimum element with the first element
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
}