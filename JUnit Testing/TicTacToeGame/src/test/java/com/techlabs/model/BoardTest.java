package com.techlabs.model;

import com.techlabs.exceptions.CellAlreadyMarkedException;
import com.techlabs.exceptions.InvalidCellLocationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void init(){
        board = new Board();
    }

    @Test
    void testCreatedBoard_allNineCellsAreEmpty() {

        for(Cell cell : board.getCells()){
            assertTrue(cell.isEmpty());
        }

        board.setCellMark(3,MarkType.X);
        assertFalse(board.isBoardFull());
    }

    @Test
    void testSetCellMark_ableToMarkAtSpecificLocation(){

        board.setCellMark(3,MarkType.O);
        Cell[] cells = board.getCells();
        assertEquals(MarkType.O,cells[3-1].getMark());

    }

    @Test
    void testSetCellMark_throwsInvalidCellLocationExceptionForInvalidCellLocation(){
        assertThrows(InvalidCellLocationException.class,()->{
            board.setCellMark(10,MarkType.X);
        });
    }

    @Test
    void testIsBoardFull_checkTrueIfBoardIsFull(){
        assertFalse(board.isBoardFull());

        for(int i=1; i<=9; i++){
            board.setCellMark(i,MarkType.X);
        }

        assertTrue(board.isBoardFull());
    }

    @Test
    void testSetCellMark_throwsCellAlreadyMarkedExceptionIfMarkedTwice(){

        board.setCellMark(4,MarkType.O);

        assertThrows(CellAlreadyMarkedException.class,()->{
            board.setCellMark(4,MarkType.X);
        });
    }

}