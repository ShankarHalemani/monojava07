package com.techlabs.exceptions;

public class InvalidCellLocationException extends RuntimeException {
    public InvalidCellLocationException(String message) {
        super(message);
    }
}
