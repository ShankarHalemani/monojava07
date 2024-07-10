package com.techlabs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultAnalyzerTest {
    private ResultAnalyzer resultAnalyzer;
    private Board board;

    @BeforeEach
    void init(){
        resultAnalyzer = new ResultAnalyzer();
        board = resultAnalyzer.getBoard();
    }

    @Test
    void testHorizontalWinCheck_FirstRowWin(){
        board.setCellMark(1,MarkType.X);
        board.setCellMark(2,MarkType.X);
        board.setCellMark(3,MarkType.X);

        resultAnalyzer.horizontalWinCheck();

        assertEquals(ResultType.WIN,resultAnalyzer.getResult());
    }

    @Test
    void testHorizontalWinCheck_SecondRowWin(){
        board.setCellMark(4,MarkType.X);
        board.setCellMark(5,MarkType.X);
        board.setCellMark(6,MarkType.X);

        resultAnalyzer.horizontalWinCheck();

        assertEquals(ResultType.WIN,resultAnalyzer.getResult());
    }

    @Test
    void testHorizontalWinCheck_ThirdRowWin(){
        board.setCellMark(7,MarkType.X);
        board.setCellMark(8,MarkType.X);
        board.setCellMark(9,MarkType.X);

        resultAnalyzer.horizontalWinCheck();

        assertEquals(ResultType.WIN,resultAnalyzer.getResult());
    }

    @Test
    void testVerticalWinCheck_FirstColumWin(){
        board.setCellMark(1,MarkType.X);
        board.setCellMark(4,MarkType.X);
        board.setCellMark(7,MarkType.X);

        resultAnalyzer.verticalWinCheck();

        assertEquals(ResultType.WIN,resultAnalyzer.getResult());
    }

    @Test
    void testVerticalWinCheck_SecondColumWin(){
        board.setCellMark(2,MarkType.X);
        board.setCellMark(5,MarkType.X);
        board.setCellMark(8,MarkType.X);

        resultAnalyzer.verticalWinCheck();

        assertEquals(ResultType.WIN,resultAnalyzer.getResult());
    }

    @Test
    void testVerticalWinCheck_ThirdColumWin(){
        board.setCellMark(3,MarkType.X);
        board.setCellMark(6,MarkType.X);
        board.setCellMark(9,MarkType.X);

        resultAnalyzer.verticalWinCheck();

        assertEquals(ResultType.WIN,resultAnalyzer.getResult());
    }

    @Test
    void testResultAnalyzerWin(){
        board.setCellMark(1,MarkType.X);
        board.setCellMark(2,MarkType.O);
        board.setCellMark(3,MarkType.O);


        board.setCellMark(5,MarkType.X);
        board.setCellMark(6,MarkType.O);

        board.setCellMark(7,MarkType.X);
        board.setCellMark(8,MarkType.X);
        board.setCellMark(9,MarkType.O);

        assertEquals(ResultType.WIN,resultAnalyzer.analyzeResult());
    }

    @Test
    void testResultAnalyzerDraw(){
        board.setCellMark(1,MarkType.X);
        board.setCellMark(2,MarkType.X);
        board.setCellMark(3,MarkType.O);

        board.setCellMark(4,MarkType.O);
        board.setCellMark(5,MarkType.X);
        board.setCellMark(6,MarkType.X);

        board.setCellMark(7,MarkType.X);
        board.setCellMark(8,MarkType.O);
        board.setCellMark(9,MarkType.O);

        assertEquals(ResultType.DRAW,resultAnalyzer.analyzeResult());
    }

    @Test
    void testResultAnalyzerProgress(){
        board.setCellMark(1,MarkType.X);
        board.setCellMark(2,MarkType.X);
        board.setCellMark(3,MarkType.O);

        board.setCellMark(4,MarkType.O);
        board.setCellMark(5,MarkType.X);
        board.setCellMark(6,MarkType.X);

        board.setCellMark(7,MarkType.X);

        assertEquals(ResultType.PROGRESS,resultAnalyzer.analyzeResult());
    }


}