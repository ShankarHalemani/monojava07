package com.techlabs.exceptions;

public class NegativeAmountException extends RuntimeException {
	public String getMessage() {
		return "Enter valid amount to withdrw or deposit";
	}
}
