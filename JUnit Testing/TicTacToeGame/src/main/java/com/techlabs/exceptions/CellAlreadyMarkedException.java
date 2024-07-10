package com.techlabs.exceptions;

public class CellAlreadyMarkedException extends RuntimeException {
    public CellAlreadyMarkedException(String message){
        super(message);
    }
}
