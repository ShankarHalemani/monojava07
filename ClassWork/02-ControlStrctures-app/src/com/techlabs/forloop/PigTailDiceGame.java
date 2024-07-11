package com.techlabs.forloop;

import java.util.Random;
import java.util.Scanner;

public class PigTailDiceGame {

	public static void main(String[] args) {

		// initialization
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		// calculating final score and total number of turns
		int[] sumAndTotalTurns = calculateSum(random, scanner);

		// Total score of player
		System.out.println("Total score : " + sumAndTotalTurns[0]);
		System.out.println("You finished in " + sumAndTotalTurns[1] + " turns!");
		System.out.println("Game over!");

		scanner.close();
	}

	// Method to calculate final score and total number of turns
	private static int[] calculateSum(Random random, Scanner scanner) {
		int sum = 0;
		int totalTurns = 0;
		while (sum < 20) {
			totalTurns++;
			System.out.println("TURN : " + totalTurns);

			int scoreForTurn = 0;
			boolean rolling = true;
			while (rolling) {
				System.out.println("Roll or Hold ?");
				String action = scanner.nextLine();

				if (action.equalsIgnoreCase("Hold")) {
					rolling = false;
					continue;
				}

				if (action.equalsIgnoreCase("Roll")) {
					int turnScore = calculateScoreForTurn(random);
					System.out.println("Score for the roll : " + turnScore);
					if (turnScore == 0) {
						System.out.println("Turn over!");
						scoreForTurn = 0;
						rolling = false;
						continue;
					}
					scoreForTurn += turnScore;
				}

				if (!action.equalsIgnoreCase("Roll") && !action.equalsIgnoreCase("Hold")) {
					System.out.println("Invalid input. Please enter 'Roll' or 'Hold'.");
				}
			}

			System.out.println("Score for the turn : " + scoreForTurn);
			sum += scoreForTurn;
			System.out.println();
		}
		return new int[] { sum, totalTurns };
	}

	// Method to calculate score for each roll
	private static int calculateScoreForTurn(Random random) {
		int dice = random.nextInt(6) + 1;
		System.out.println("Dice : " + dice);
		if (dice == 1) {
			return 0;
		}
		return dice;
	}
}
