package com.techlabs.exceptions;

public class InsufficientFundsException extends RuntimeException {
	public String getMessage() {
		return "Insufficient Balance";
	}
}
