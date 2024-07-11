package com.techlabs.ifelse;

import java.util.Scanner;

public class TreasureHunt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Treasure Island");
		System.out.println("Your ission is to find Treasure");
		System.out.println();
		System.out.println("Enter any direction You want proceed with :");
		System.out.println("Left or Right or Up or Down or Any direction your heart races towards");
		Scanner sc = new Scanner(System.in);
		String direction = sc.nextLine();
		if(direction.equals("Left")) {
			System.out.println("There is lake ahead !");
			System.out.println("What will you do ? Swim or Wait or do you have some crazy idea ?");
			String action = sc.nextLine();
			if(action.equals("Wait")) {
				System.out.println("Now you have to choose your lucky door");
				System.out.println("Which door will you choose ?");
				System.out.println("Red, Blue , Yellow or any of your favorite colour");
				String colour = sc.nextLine();
				if(colour.equals("Red")) {
					System.out.println("Oh no ! You are burned by fire !");
					System.out.println("Game over !");
				}
				else if(colour.equals("Blue")) {
					System.out.println("Oh no ! You are attacked by beasts");
					System.out.println("Game over !");
				}
				else if(colour.equals("Yellow")) {
					System.out.println("Congratulations you found the treasure !");
					System.out.println("Hurray !!! You win ");
				}
				else {
					System.out.println("It seems your lucky door isn't that lucky");
					System.out.println("Game over !");
				}
			}
			else {
				System.out.println("Oh noo ! You are attacked by trout");
				System.out.println("Game over !");
			}
		}
		else {
			System.out.println("Uh oh ! You fell into a hole");
			System.out.println("Game over !");
		}
		sc.close();
	}

}
