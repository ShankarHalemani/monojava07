package com.techlabs.exceptions;

public class InvalidSupplierIdException extends RuntimeException{
    public InvalidSupplierIdException(String message) {
        super(message);
    }
}
