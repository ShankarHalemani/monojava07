package com.techlabs.whileloop;

import java.util.Scanner;

public class CurrencyApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the withdrawal Amount");
		int Amount = scanner.nextInt();
		
		if(Amount <= 50000) {
			boolean flag = true;
			while(flag) {
				if(Amount % 100 == 0) {
					flag = false;
					int originalAmount = Amount;
					System.out.println("Denominations of "+originalAmount);
					int twoThousand = Amount/2000;
					System.out.println("Two thousand : "+twoThousand);
					Amount %= 2000;
					
					if(Amount>0) {
						int fiveHundred = Amount/500;
						System.out.println("Five Hundred : "+fiveHundred);
						Amount%=500;
						
						if(Amount>0) {
							int twoHundred = Amount/200;
							System.out.println("Two Hundred : "+twoHundred);
							Amount%=200;
							
							if(Amount>0) {
								int oneHundred = Amount/100;
								System.out.println("One Hundred : "+oneHundred);
							}
						}
					}
				}
				else {
					System.out.println("Amount shoud be in the multiples of 100");
					System.out.println("Enter the withdrawal Amount");
					Amount = scanner.nextInt();
					flag = true;
				}
				
			}
			}
		else {
			System.out.println("Amount exceeds withdrawal limit of 50000");
		}
		scanner.close();
	}

}
