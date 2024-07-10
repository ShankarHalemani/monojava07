package com.techlabs.model;

import com.techlabs.exceptions.CellAlreadyMarkedException;
import com.techlabs.exceptions.InvalidCellLocationException;

public class Board {
    private Cell[] cells = new Cell[9];

    public Board() {
        for(int i=0; i<cells.length;i++){
            cells[i]=new Cell();
        }
    }

    public boolean isBoardFull(){
        for (Cell cell : cells){
            if(cell.getMark() == MarkType.EMPTY)
                return false;
        }
        return true;
    }

    public Cell[] getCells(){
        return cells;
    }

    public void setCellMark(int location, MarkType mark) throws CellAlreadyMarkedException {
        if(location<1 || location>9)
            throw new InvalidCellLocationException("Invalid Location : "+location);

        cells[location-1].setMark(mark);
    }


}
