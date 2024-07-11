/*
Question:
Design a function that takes a sorted array of numbers as input. The function should produce an array containing the squares of all elements from the input array, ensuring that the output array is also sorted. The function should have a time complexity of O(n) and handle all possible input scenarios effectively.

Difficulty: Medium

Example:
[1,2,3,4,5]  =>  [1,4,9,16,25]
[-5,-4,-3,-2,-1]  =>  [1,4,9,16,25]
[-5,-3,1,2,4]  => [1,4,9,16,25]

Constraints:
The function should have a time complexity of O(n) and handle all possible input scenarios effectively.

*/

package com.techlabs.arrays;

import java.util.Scanner;

public class SortedSquareArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Taking array size from user
		System.out.println("Enetr array size");
		int n = scanner.nextInt();
		int array[] = new int[n];
		int resultArray[] = new int[n];

		// Taking array elements from user
		System.out.println("Enter array elements");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}

		int leftPos = 0;
		int rightPos = array.length - 1;
		int index = array.length - 1;

		// Logic to square array elements in sorted order
		while (leftPos <= rightPos) {
			int leftSquare = array[leftPos] * array[leftPos];
			int rightSquare = array[rightPos] * array[rightPos];

			if (leftSquare > rightSquare) {
				resultArray[index] = leftSquare;
				leftPos++;
			} else {
				resultArray[index] = rightSquare;
				rightPos--;
			}

			index--;
		}

		// Printing Sorted Square Array
		System.out.println("Sorted Square Array");
		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}

		scanner.close();
	}

}
