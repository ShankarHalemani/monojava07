package com.techlabs.model;

import com.techlabs.exceptions.CellAlreadyMarkedException;
import com.techlabs.exceptions.InvalidCellLocationException;

public class Game {
    private Player currentPlayer;
    private Player[] players;
    private Board board;
    private ResultAnalyzer resultAnalyzer;
    private ResultType result;

    public Game(Player[] players) {
        this.players = players;
        this.resultAnalyzer = new ResultAnalyzer();
        this.board = resultAnalyzer.getBoard();
        this.currentPlayer = players[0];
        this.result = resultAnalyzer.getResult();

        players[0].setMark(MarkType.X);
        players[1].setMark(MarkType.O);
    }

    public void play(int location){
        try {
            board.setCellMark(location,currentPlayer.getMark());
            result = resultAnalyzer.analyzeResult();
            if(result == ResultType.WIN){
                System.out.println(currentPlayer.getPlayerName()+" is a winner");
            }

            if(result == ResultType.DRAW){
                System.out.println("Game is a Draw");
            }

            if(result==ResultType.PROGRESS){
                switchPlayer();
            }
        }
        catch (CellAlreadyMarkedException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidCellLocationException e){
            System.out.println(e.getMessage());
        }

    }

    public void switchPlayer(){
        if(currentPlayer==players[0]){
            currentPlayer=players[1];
            return;
        }
        currentPlayer=players[0];
    }

    public ResultAnalyzer getResultAnalyzer(){
        return resultAnalyzer;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public void printBoard(){
        for (int i = 0; i < board.getCells().length; i++) {
            System.out.print(board.getCells()[i].getMark());
            if ((i + 1) % 3 == 0) {
                System.out.println();
            } else {
                System.out.print(" | ");
            }
        }
    }
}
