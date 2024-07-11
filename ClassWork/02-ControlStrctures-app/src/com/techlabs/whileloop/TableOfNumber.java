package com.techlabs.whileloop;

import java.util.Scanner;

public class TableOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter any number");
		int num = scanner.nextInt();
		int i=1;
		System.out.println("Tables of "+num);
		while(i<=10) {
			int mult = num*i;
			System.out.println(mult);
			i++;
	}
		scanner.close();

	}
}
