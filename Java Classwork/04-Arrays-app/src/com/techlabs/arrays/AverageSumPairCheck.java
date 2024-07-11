package com.techlabs.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class AverageSumPairCheck {

	// Function to check for pair that is equal to Average
	public static boolean checkPairEqualsAverage(int[] arr) {
		int sum = 0;
		int size = arr.length;
		int averageOfElements;
		for (int i = 0; i < size; i++) {
			sum += arr[i];
		}

		averageOfElements = (int) (sum / size);
		System.out.println("Average of elements : " + averageOfElements);

		int left = 0;
		int right = size - 1;

		// Array traversal from left and right
		while (left < right) {

			int currSum = arr[left] + arr[right];
			if (currSum == averageOfElements) {
				return true;
			} else if (currSum < averageOfElements) {
				left++;
			} else {
				right--;
			}

		}
		return false;
	}

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

		Arrays.sort(arr);

		boolean pairExist = checkPairEqualsAverage(arr);

		if (pairExist) {
			System.out.println("Pair exist");
		} else {
			System.out.println("Pair does not exist");
		}

		scanner.close();

	}

}
