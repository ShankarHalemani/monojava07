package com.techlabs.arrays2d;

import java.util.Scanner;

public class MultiplicationOfTwoMatrices {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of rows for array 1");
		int rowsOfFirstMatirx = scanner.nextInt();
		System.out.println("Enter number of coloumns for array 1");
		int colOfFirstMatirx = scanner.nextInt();

		int[][] matrixOne = new int[rowsOfFirstMatirx][colOfFirstMatirx];

		System.out.println("Enter number of rows for array 2");
		int rowsOfSecondMatrix= scanner.nextInt();
		System.out.println("Enter number of coloumns for array 2");
		int colOfSecondMatrix = scanner.nextInt();

		int[][] matrixTwo = new int[rowsOfSecondMatrix][colOfSecondMatrix];

		int[][] matrixThree = new int[rowsOfFirstMatirx][colOfSecondMatrix];

		if (colOfFirstMatirx != rowsOfSecondMatrix) {
			System.out.println("Multiplication of these two matrix is not possible");
		} else {

			System.out.println("Enter array elements of 2D Array 1");
			for (int i = 0; i < rowsOfFirstMatirx; i++) {
				for (int j = 0; j < colOfFirstMatirx; j++) {
					matrixOne[i][j] = scanner.nextInt();
				}
			}

			System.out.println("Enter array elements of 2D Array 2");
			for (int i = 0; i < rowsOfSecondMatrix; i++) {
				for (int j = 0; j < colOfSecondMatrix; j++) {
					matrixTwo[i][j] = scanner.nextInt();
				}
			}

			System.out.println("Multiplication result");
			for (int i = 0; i < rowsOfFirstMatirx; i++) {
				for (int j = 0; j < colOfSecondMatrix; j++) {
					for (int k = 0; k < rowsOfSecondMatrix; k++)
						matrixThree[i][j] += matrixOne[i][k] * matrixTwo[k][j];
				}
			}

			for (int i = 0; i < rowsOfFirstMatirx; i++) {
				for (int j = 0; j < colOfSecondMatrix; j++) {
					System.out.print(matrixThree[i][j] + " ");
				}
				System.out.println();
			}
		}

		scanner.close();

	}

}
