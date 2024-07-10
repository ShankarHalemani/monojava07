package com.techlabs.Test;

import com.techlabs.model.*;

import java.util.Scanner;

public class TicTacToeTest {
    public static void main(String[] args) {
        Player[] players = new Player[2];

        players[0] = new Player("Shankar");
        players[1] = new Player("Deepak");

        Game game = new Game(players);

        ResultAnalyzer resultAnalyzer = game.getResultAnalyzer();
        Board board = resultAnalyzer.getBoard();

        game.printBoard();

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println(game.getCurrentPlayer().getPlayerName()+" is playing");
            System.out.println("Enter your location");
            int location = scanner.nextInt();
            game.play(location);
            game.printBoard();

            if(resultAnalyzer.analyzeResult()!= ResultType.PROGRESS)
                break;
        }

    }
}
