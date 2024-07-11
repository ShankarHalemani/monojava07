package com.techlabs.whileloop;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =  new Scanner(System.in);
		System.out.println("Enter the number");
		int userNumber = scanner.nextInt();
		int i =2;
		boolean flag = true;
		if(userNumber<2) {
			System.out.println("It is not prime number");
		}
		else {
			while(i<userNumber) {
				if(userNumber%i == 0) {
					flag = false;
					break;
				}
				i++;
			}
			
			if(flag == true) {
				System.out.println("It is prime number");
			}
			else {
				System.out.println("It is not prime number");
			}
		}
		scanner.close();
	}

}
