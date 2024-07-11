package com.techlabs.exceptions;

public class NegativeAmountException extends Exception {
	@Override
	public String getMessage() {
		return "Enter valid amount to withdrw or deposit";
	}
}
