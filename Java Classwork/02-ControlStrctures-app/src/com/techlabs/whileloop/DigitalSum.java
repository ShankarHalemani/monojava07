package com.techlabs.whileloop;

import java.util.Scanner;

public class DigitalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =  new Scanner(System.in);
		System.out.println("Enter the number");
		int userNumber = scanner.nextInt();
		int originalNum = userNumber;
		int remainder = 0;
		int sum=0;
		
		while(userNumber>0) {
			remainder = userNumber%10;
			sum += remainder;
			userNumber/=10;
		}
		
		System.out.println("Digital sum of "+ originalNum + " is "+sum);
		scanner.close();
	}

}
