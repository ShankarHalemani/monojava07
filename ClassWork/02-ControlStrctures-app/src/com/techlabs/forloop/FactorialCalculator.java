package com.techlabs.forloop;

import java.util.Scanner;

public class FactorialCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number");
		int userNumber = scanner.nextInt();
		int factorial = 1;
		
		for(int i=userNumber; i>=1;i--) {
			factorial*=i;
		}
		System.out.println("Factorail of "+userNumber+" is "+factorial);
		
		
		scanner.close();
	}

}
