package com.techlabs.whileloop;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =  new Scanner(System.in);
		System.out.println("Enter the number");
		int userNumber = scanner.nextInt();
		int originalNum = userNumber;
		int numberOfDigits = String.valueOf(userNumber).length();
		int remainder = 0;
		int sum=0;
		
		while(userNumber>0) {
			remainder = userNumber%10;
			sum += Math.pow(remainder, numberOfDigits);
			userNumber/=10;
		}
		if(originalNum == sum) {
			System.out.println("This is armstrong number");
		}else {
			System.out.println("This is not armstrong number");
		}
		scanner.close();
	}

}
