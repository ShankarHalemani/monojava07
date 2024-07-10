package com.techlabs.model;


import com.techlabs.exceptions.CellAlreadyMarkedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private Cell cell;

    @BeforeEach
    void init(){
        cell = new Cell();
    }

    @Test
    void testCreatedCellIsEmpty() {
        assertEquals(MarkType.EMPTY, cell.getMark());
    }

    @Test
    void testSetMark_checkIfCanMarkX() {
        assertTrue(cell.isEmpty());

        cell.setMark(MarkType.X);
        assertFalse(cell.isEmpty());
    }

    @Test
    void testSetMark_checkIfCanMarkO() {
        assertTrue(cell.isEmpty());

        cell.setMark(MarkType.O);
        assertFalse(cell.isEmpty());
    }

    @Test
    void testSetMark_throwsCellAlreadyMarkedExceptionWhenMarkedTwice() {
        cell.setMark(MarkType.O);

        assertThrows(CellAlreadyMarkedException.class,()->{
            cell.setMark(MarkType.X);
        });

        assertThrows(CellAlreadyMarkedException.class,()->{
            cell.setMark(MarkType.O);
        });
    }
}