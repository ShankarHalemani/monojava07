package com.techlabs.ifelse;

import java.util.Scanner;

public class MaxOfTwo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter number 1 : ");
		int number1 = sc.nextInt();
		
		System.out.println("Enter number 2 : ");
		int number2 = sc.nextInt();
		
		if(number1 > number2) {
			System.out.println("The Number 1 : "+number1+" is Maximum of two ");
		}
		else {
			System.out.println("The Number 2 : "+number2+" is Maximum of two ");
		}
		
		sc.close();
	}
}
