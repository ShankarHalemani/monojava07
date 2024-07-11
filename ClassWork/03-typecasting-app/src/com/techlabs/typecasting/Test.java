package com.techlabs.typecasting;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double number = 100.5;
		int number3 = 100;
		double number4 = number3; // implicit type conversion or widening expression

		int number2 = (int) number; // type casting or explicit type casting or narrowing expression

		boolean flag = true;

//		int flag2 = (int)flag;		// this is not allowed bcs ->types of both variables or values must be compatible with each other

		int number5 = 10;

		Scanner scanner = new Scanner(System.in);

		float number6 = 10.5f;

		byte number7 = 10;
		byte number8 = 12;

		byte multiplication;

		multiplication = (byte) (number7 * number8);

//		multiplication = number7*number8; 		// here both variable and multiplicatio variable are same type but getting error bcz
		// Whenever u use byte or short datatypes in an arithmetic expression java
		// converts into int datatype

	}

}
