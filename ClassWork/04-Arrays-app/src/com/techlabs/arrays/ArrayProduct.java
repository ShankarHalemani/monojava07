/*
Question:
Write a function that accepts an array of n integers, array[]. Create a new array, prod[] such that prod[i] is equal to the product of all the elements of array[] except array[i]. The function should have a time complexity of O(n) and handle all possible input scenarios effectively.

Difficulty: Medium

Example:
 Array[]={2,3,4,5} then prod[]={60,40,30,24}

Array[]={2,3,0,5} then prod[]={0,0,30,0}

Array[]={0,3,0,5} then prod[]={0,0,0,0}

Constraints:
The function should have a time complexity of O(n) and handle all possible input scenarios effectively.


*/

package com.techlabs.arrays;

import java.util.Scanner;

public class ArrayProduct {

	public static int[] productOfArray(int[] arr) {
		int n = arr.length;
		int[] prod = new int[n];

		int countOfZero = 0;
		int totalProduct = 1;

		// calculating product of all array elements except zero
		// counting number of zeros
		for (int i = 0; i < n; i++) {

			if (arr[i] == 0) {
				countOfZero++;
			} else {
				totalProduct *= arr[i];
			}

		}

		// if there are more than 1 zero return prod array as all elements of prod array
		// will be zero
		if (countOfZero > 1) {
			return prod;
		}

		// if there is only one zero store product of all elements in i th index in prod
		// array
		else if (countOfZero == 1) {

			for (int i = 0; i < n; i++) {

				if (arr[i] == 0) {
					prod[i] = totalProduct;
					break;
				}
			}
			return prod;
		}

		// if there are no zeros following operation
		else {

			for (int i = 0; i < n; i++) {
				prod[i] = totalProduct / arr[i];
			}

			return prod;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// user input of array size
		System.out.println("Enter array size");
		int n = scanner.nextInt();
		int[] arr = new int[n];

		// User input of array elements
		System.out.println("Enter array elements");
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		// new array to store product of array elements
		// function to calculate product of array elements
		int[] productOfElements = productOfArray(arr);

		// printing Product array
		System.out.print("Product array = {");
		for (int i = 0; i < n; i++) {
			System.out.print(productOfElements[i] + " ");
		}
		System.out.print("}");
		scanner.close();
	}

}
