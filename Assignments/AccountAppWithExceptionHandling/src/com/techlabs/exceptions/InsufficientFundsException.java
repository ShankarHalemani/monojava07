package com.techlabs.exceptions;

public class InsufficientFundsException extends Exception {
	@Override
	public String getMessage() {
		return "Insufficient Balance";
	}
}
