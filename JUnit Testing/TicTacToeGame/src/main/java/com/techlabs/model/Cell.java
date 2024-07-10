package com.techlabs.model;

import com.techlabs.exceptions.CellAlreadyMarkedException;

public class Cell {
    private MarkType mark;

    public Cell() {
        this.mark = MarkType.EMPTY;
    }

    public boolean isEmpty(){
        return mark == MarkType.EMPTY;
    }

    public MarkType getMark(){
        return mark;
    }

    public void setMark(MarkType mark){
        if (this.mark != MarkType.EMPTY){
            throw new CellAlreadyMarkedException("Cell is Already marked with : "+mark);
        }
        this.mark = mark;
    }
}
