package com.techlabs.exceptions;

public class InvalidProductIdException extends RuntimeException{
    public InvalidProductIdException(String message) {
        super(message);
    }
}
