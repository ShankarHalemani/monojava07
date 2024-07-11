package com.techlabs.whileloop;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =  new Scanner(System.in);
		System.out.println("Enter the number");
		int userNumber = scanner.nextInt();
		int originalNum = userNumber;
		int remainder = 0;
		int reverseNum = 0;
		
		while(userNumber>0) {
			remainder = userNumber%10;
			reverseNum = reverseNum * 10 + remainder;
			userNumber/=10;
		}
		
		System.out.println("Reverse of " + originalNum + " is "+ reverseNum);
		
		scanner.close();
	}

}
