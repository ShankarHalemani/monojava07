package com.techlabs.ifelse;

import java.util.Scanner;

public class MaxOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number 1 : ");
		int num1 = sc.nextInt();
		System.out.println("Enter number 2: ");
		int num2 = sc.nextInt();
		System.out.println("Enter number 3: ");
		int num3 = sc.nextInt();
		
		if(num1>num2 && num1>num3) {
			System.out.println("The Number 1 : "+num1+" is Maximum of three ");
		}
		else if(num2>num1 && num2>num3) {
			System.out.println("The Number 2 : "+num2+" is Maximum of three ");
		}
		else {
			System.out.println("The Number 3 : "+num3+" is Maximum of three ");
		}
		
		sc.close();
	}

}
