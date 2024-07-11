package com.techlabs.exceptions;

public class DuplicateSupplierException extends RuntimeException{
    public DuplicateSupplierException(String message) {
        super(message);
    }
}
