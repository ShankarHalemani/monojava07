// Rule : Achieve only single level of indentation ---> use only one for loop in a function

package com.techlabs.model;

import java.util.Scanner;

public class MatricsCalculator {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int[][] matrix = new int[3][3];

		System.out.println("Enter elemnts of matrix");

		createMatrix(matrix, scanner);

		System.out.println();

		displayMatrix(matrix);

	}

	private static void createMatrix(int[][] matrix, Scanner scanner) {
		for (int i = 0; i < 3; i++) {
			createColumn(i, matrix, scanner);
		}

	}

	private static void createColumn(int i, int[][] matrix, Scanner scanner) {
		for (int j = 0; j < 3; j++) {
			matrix[i][j] = scanner.nextInt();
		}

	}

	private static void displayMatrix(int[][] matrix) {
		for (int i = 0; i < 3; i++) {
			displayColumn(i, matrix);
			System.out.println();
		}

	}

	private static void displayColumn(int i, int[][] matrix) {
		for (int j = 0; j < 3; j++) {
			System.out.print(matrix[i][j] + " ");
		}

	}
}
