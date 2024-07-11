package com.techlabs.arrays2d;

import java.util.Scanner;

public class AdditionOfTwoMatrices {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of rows");
		int rows = scanner.nextInt();
		System.out.println("Enter number of coloumns");
		int col = scanner.nextInt();

		int[][] array1 = new int[rows][col];
		int[][] array2 = new int[rows][col];
		int[][] array3 = new int[rows][col];

		System.out.println("Enter array elements of 2D Array 1");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				array1[i][j] = scanner.nextInt();
			}
		}

		System.out.println("Enter array elements of 2D Array 2");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				array2[i][j] = scanner.nextInt();
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				array3[i][j] = array1[i][j] + array2[i][j];
			}
		}

		System.out.println("Addition of two 2D arrays");
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(array3[i][j] + " ");
			}
			System.out.println();
		}

		scanner.close();
	}

}
