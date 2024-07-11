package com.techlabs.whileloop;

import java.util.Random;
import java.util.Scanner;

public class PageNumberGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		System.out.println("Enter player 1 name");
		String player1 = scanner.next();

		System.out.println("Enter player 2 name");
		String player2 = scanner.next();

		int totalNumberOfPages = 300;

		// Function to calculate player1 total score and turns
		int[] player1Results = playGame(scanner, random, player1, totalNumberOfPages);
		int turnsOfPlayer1 = player1Results[0];
		int totalScoreOfPlayer1 = player1Results[1];

		// Function to calculate player2 total score and turns
		int[] player2Results = playGame(scanner, random, player2, totalNumberOfPages);
		int turnsOfPlayer2 = player2Results[0];
		int totalScoreOfPlayer2 = player2Results[1];

		System.out.println(player1 + "'s total score is " + totalScoreOfPlayer1 + " in " + turnsOfPlayer1 + " turns");
		System.out.println(player2 + "'s total score is " + totalScoreOfPlayer2 + " in " + turnsOfPlayer2 + " turns");

		// Logic to declare winner
		if (totalScoreOfPlayer1 > totalScoreOfPlayer2) {
			System.out.println(player1 + " is the winner");
		} else if (totalScoreOfPlayer1 == totalScoreOfPlayer2) {
			if (turnsOfPlayer1 < turnsOfPlayer2) {
				System.out.println(player1 + " is the winner");
			} else if (turnsOfPlayer1 == turnsOfPlayer2) {
				System.out.println("It's a draw");
			} else {
				System.out.println(player2 + " is the winner");
			}
		} else {
			System.out.println(player2 + " is the winner");
		}
		scanner.close();
	}

	// Function to calculate player total score and turns
	private static int[] playGame(Scanner scanner, Random random, String playerName, int totalNumberOfPages) {
		int turns = 0;
		int totalScore = 0;
		boolean continuePlay = true;

		System.out.println(playerName + " starts playing");

		while (turns < totalNumberOfPages && continuePlay) {
			turns++;
			System.out.println("Turn : " + turns);

			int pageNumberGenerated = random.nextInt(totalNumberOfPages) + 1;
			System.out.println("Page number generated : " + pageNumberGenerated);

			int score = pageNumberGenerated % 7;

			if (score == 0) {
				System.out.println("Score : " + score);
				System.out.println("Total score : " + totalScore);
				break;
			}

			else {
				System.out.println("Score : " + score);

				totalScore += score;
				System.out.println("Total score : " + totalScore);

				System.out.println("Do you want to continue playing ? yes/no");
				String action = scanner.next();

				if (action.equalsIgnoreCase("no")) {
					continuePlay = false;
				}
			}
		}
		return new int[] { turns, totalScore };
	}
}
