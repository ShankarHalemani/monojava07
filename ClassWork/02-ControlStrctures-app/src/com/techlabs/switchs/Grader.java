package com.techlabs.switchs;

import java.util.Scanner;

public class Grader {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter grade");
		String  grade = scanner.next();
		
		switch(grade) {
		case "A" :
			System.out.println("Excellent");
			break;
			
		case "B" :
			System.out.println("Good");
			break;
			
		case "C" :
			System.out.println("Pass");
			break;
			
		case "D" :
			System.out.println("Fail");
			break;
			
		default :
			System.out.println("Enter proper grade");
		}
		
		scanner.close();
	}

}
