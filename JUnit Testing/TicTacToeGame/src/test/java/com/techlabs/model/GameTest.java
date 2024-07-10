package com.techlabs.model;

import com.techlabs.exceptions.CellAlreadyMarkedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Player[] players = new Player[2];
    private ResultAnalyzer resultAnalyzer;
    private Board board;

    private Game game;

    @BeforeEach
    void init(){
        players[0] = new Player("Shankar");
        players[0].setMark(MarkType.X);
        players[1] = new Player("Sourav");
        players[1].setMark(MarkType.O);
        game = new Game(players);

        resultAnalyzer = game.getResultAnalyzer();
        board = resultAnalyzer.getBoard();
    }

    @Test
    void testPlayer(){
        assertEquals("Shankar",game.getCurrentPlayer().getPlayerName());
    }

    @Test
    void testPlayerSwitch(){
        game.play(3);
        assertEquals("Sourav",game.getCurrentPlayer().getPlayerName());

        assertThrows(CellAlreadyMarkedException.class, ()->{
            game.play(3);
        });
    }

    @Test
    void testWinCheck(){
        game.play(1);
        game.play(4);
        game.play(2);
        game.play(5);
        game.play(3);

        assertEquals(ResultType.WIN, resultAnalyzer.analyzeResult());
    }

    @Test
    void testDrawCheck(){
        game.play(1);
        game.play(3);
        game.play(2);
        game.play(4);
        game.play(5);
        game.play(8);
        game.play(6);
        game.play(9);
        game.play(7);

        assertEquals(ResultType.DRAW, resultAnalyzer.analyzeResult());
    }

    @Test
    void testProgressCheck(){
        game.play(1);
        game.play(4);
        game.play(6);
        game.play(9);
        game.play(7);


        assertEquals(ResultType.WIN, resultAnalyzer.analyzeResult());
    }
}