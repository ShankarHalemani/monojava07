package com.techlabs.whileloop;

import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =  new Scanner(System.in);
		System.out.println("Enter the number");
		int userNumber = scanner.nextInt();
		int originalNum = userNumber;
		int sum = 0;
		int i = 1;
		while(i<userNumber) {
			if(userNumber%i == 0) {
				sum+=i;
			}
			i++;
		}
		
		if(originalNum == sum) {
			System.out.println("This is a perfect number");
		}
		else {
			System.out.println("This is not a perfect number");
		}
		
		
		
		scanner.close();
	}

}
