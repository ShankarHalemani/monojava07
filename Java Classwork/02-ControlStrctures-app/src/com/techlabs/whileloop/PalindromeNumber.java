package com.techlabs.whileloop;

import java.util.Scanner;

public class PalindromeNumber {

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
		
		if(originalNum == reverseNum) {
			System.out.println("This is palindrome number : "+ originalNum);
		}
		else {
			System.out.println("This is not a palindrome number : "+ originalNum);
		}
		
		scanner.close();
	}

}
